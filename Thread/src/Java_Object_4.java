import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Event{
	String eventName;
	String location;
	String date;
	int maxParticipants;
	int currentParticipants;


	public Event(String eventName, String location, String date, int maxParticipants) {
		super();
		this.eventName = eventName;
		this.location = location;
		this.date = date;
		this.maxParticipants = maxParticipants;
		this.currentParticipants = 0;
	}
	
	public boolean isFull() {
		return maxParticipants==currentParticipants ? true : false;
	}
	
	public boolean addParticipant() {
		if(!isFull()) {
			currentParticipants++;
			return true;
		} else
		return false;
	}
	
	public void removeParticipant() {
		if(currentParticipants > 0)
		currentParticipants--;
	}

	public int getCurrentParticipants() {
		return currentParticipants;
	}
}

class Participant implements Comparable<Participant>{
	String name;
	List<Event> joinEvent;
	
	public Participant(String name) {
		super();
		this.name = name;
		this.joinEvent = new ArrayList<>();
	}
	
	public void addJoinEvent(Event event) {
		this.joinEvent.add(event);
	}
	
	public void removeJoinEvent(Event event) {
        this.joinEvent.remove(event);
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Participant other) {
		return this.name.compareTo(other.name);
	}
}

class EventManager{
	List<Event> events;
	Map<String, Participant> participants;
	
	public EventManager() {
		super();
		this.events = new ArrayList<>();
		this.participants = new HashMap<>();
	}
	
	public void createEvent(String eventNameInput, String eventLocationInput, String eventDateInput, int eventMaxParticipant) {
		events.add(new Event(eventNameInput, eventLocationInput, eventDateInput, eventMaxParticipant));
		System.out.println("이벤트가 성공적으로 추가됐습니다!");
	}
	
	public boolean registerParticipant(String participant) {
		if(participants.containsKey(participant)) {
			System.out.print("이미 존재하는 이름입니다\n이름 대신 닉네임을 입력해주세요 >> ");
			return false;
		} else {
			participants.putIfAbsent(participant, new Participant(participant));
			System.out.println(participant+"님이 성공적으로 추가됐습니다!");
			return true;
		}
	}
	
	public void participantJoinEvent(String participantNameInput, String[] eventNameInput) {
		Participant participant = participants.get(participantNameInput);
		for(String eventName : eventNameInput) {
			Event event = findEventByName(eventName);
			if(event != null) {
				if(!event.isFull()) {
					participant.addJoinEvent(event);
					event.addParticipant();
					System.out.println(event.eventName+"라는 이벤트를 성공적으로 추가했습니다");
				} else {
					System.out.println("인원이 가득차서 추가할 수 없습니다");
					return;
				}
			} else {
				System.out.println(participantNameInput+"이라는 이름을 가진 이벤트를 찾지 못했습니다.");
				System.out.println("이벤트 수정은 참가자 정보 및 수정에서 가능합니다");
			}
		}
	}
	
	public void participantJoinEvent(String participantNameInput, String eventNameInput) {
		Participant participant = participants.get(participantNameInput);
		Event event = findEventByName(eventNameInput);
		if(event != null) {
			if(!event.isFull()) {
				participant.addJoinEvent(event);
				event.addParticipant();
				System.out.println(event.eventName+"라는 이벤트를 성공적으로 추가했습니다");
			} else {
				System.out.println("이벤트 인원이 가득차서 추가할 수 없습니다");
			}
		} else {
			System.out.println(participantNameInput+"이라는 이름을 가진 이벤트를 찾지 못했습니다.");
			System.out.println("이벤트 수정은 참가자 정보 및 수정에서 가능합니다");
		}
	}
	
	public Event findEventByName(String targetEventName) {
		for(Event isTarget : events) {
			if(isTarget.eventName.equals(targetEventName)) {
				return isTarget;
			}
		}
		return null;
	}
	
	public void cancelEvent(String eventNameInput) {
		for(Event event : events) {
			if(event.eventName.equals(eventNameInput)) {
				events.remove(event);
				System.out.println(eventNameInput+"이 성공적으로 삭제됐습니다");
				return;
			}
		}
		
		System.out.println("이벤트를 찾지 못했습니다");
	}
	
	public void getEventSummary(String eventNameInput) {
		Event targetEvent = findEventByName(eventNameInput);
		if(targetEvent==null) {
			System.out.println("해당 이벤트는 존재하지 않습니다");
			return;
		}
		System.out.println(">> 이벤트 이름 : "+targetEvent.eventName);
		System.out.println(">> 이벤트 지역 : "+targetEvent.location);
		System.out.println(">> 이벤트 날짜 : "+targetEvent.date);
		System.out.println(">> 이벤트 수용 가능 인원 : "+targetEvent.maxParticipants);
		System.out.println(">> 이벤트 현재 인원 : "+targetEvent.currentParticipants);
	}
	
	public boolean getParticipantSummary(String participantNameInput) {
		Participant targetParticipant = findParticipantByName(participantNameInput);
		
		if(targetParticipant != null) {
			System.out.println(">> 참가자 이름 : "+targetParticipant.name);
			System.out.println(">> 참가자의 이벤트 참여 목록");
			for(Event eventInfo : targetParticipant.joinEvent) {
				System.out.println("- "+eventInfo.eventName);
			}			
			return true;
		} else {
			System.out.println("해당 이름을 가진 참가자는 존재하지 않습니다");
			return false;
		}
	}
	
	public void editParticipant(String participantNameInput) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Participant targetParticipant = findParticipantByName(participantNameInput);
		
		while(true) {
			System.out.println();
			System.out.println("==========Edit Menu==========");
			System.out.println("1.이름 변경 2.이벤트 추가 3.이벤트 삭제 0.편집 종료");
			System.out.print("편집 메뉴에서 명령을 선택하세요 >> ");
			String command = br.readLine();
			if(command.equals("0")) {
				System.out.println("편집 종료");
				break;
			}
			
			System.out.println();
			switch(command) {
				case "1" : { // 이름 변경
					System.out.println("*참가자 이름 수정을 선택했습니다*");
					System.out.print("어떤 이름으로 바꿀건가요? >> ");
					String editedParticipantName = br.readLine();
					if(findParticipantByName(editedParticipantName) != null) {
						System.out.print("\n이미 존재하는 이름입니다");
					} else {
						participants.remove(targetParticipant.name);
						targetParticipant.setName(editedParticipantName);
						participants.put(editedParticipantName, targetParticipant);
						System.out.println(targetParticipant.name+"으로 정상 변경되었습니다");
					}
					
					break;
				}
				case "2" : { // 이벤트 추가
					System.out.println("*참가자 이벤트 추가를 선택했습니다*");
					System.out.println("---현재 등록된 이벤트 목록---");
					for(Event event : events) {
						System.out.println(event.eventName);
					}
					System.out.println();
					System.out.print("어떤 이벤트를 추가할건가요? >> ");
					String addedEventNameInput = br.readLine();
					
					Event eventToAdd = findEventByName(addedEventNameInput);
					if(findEventByName(addedEventNameInput) == null) {
						System.out.println(addedEventNameInput+"는 존재하지 않는 이벤트입니다");
					} else if(targetParticipant.joinEvent.contains(eventToAdd)) {
						System.out.println(addedEventNameInput+"는 이미 참여중인 이벤트입니다");
					} else {
						participantJoinEvent(targetParticipant.name, addedEventNameInput);
						System.out.println(addedEventNameInput+"가 정상적으로 추가됐습니다");
					}
					break;
				}
				case "3" : { // 이벤트 삭제
					System.out.println("*참가자 이벤트 삭제를 선택했습니다*");
					System.out.println("---현재 참가자에게 등록된 이벤트 목록---");
					for(Event event : targetParticipant.joinEvent) {
						System.out.println(event.eventName);
					}
					System.out.println();
					System.out.print("어떤 이벤트를 삭제할건가요? >> ");
					String deletedEventNameInput = br.readLine();
					if(findEventByName(deletedEventNameInput) == null) {
						System.out.println("존재하지 않는 이벤트입니다");
						break;
					} else {
						participantDeleteEvent(targetParticipant.name, deletedEventNameInput);
					}
					
					break;
				}
				default : {
					System.out.println("잘못된 입력입니다.\n다시 입력해주세요");
					break;
				}
			}//switch
		}//while
	}
	
	private void participantDeleteEvent(String participantNameInput, String deletedEventNameInput) {
		Participant participant = participants.get(participantNameInput);
		Event eventToRemove = findEventByName(deletedEventNameInput);
		
		if(eventToRemove == null) {
			System.out.println("존재하지 않는 이벤트입니다");
		} else {
			participant.removeJoinEvent(eventToRemove);
			eventToRemove.removeParticipant();
			System.out.println(participant.name+"의 이벤트 목록에서 "+eventToRemove.eventName+"을 성공적으로 삭제했습니다");
		}
	}

	public Participant findParticipantByName(String participantNameInput) {
		for(String targetParticipant : participants.keySet()) {
			if(targetParticipant.equals(participantNameInput)) {
				return participants.get(targetParticipant);
			}
		}
		return null;
	}
	
	public void showHelp() {
		System.out.println("이벤트 관리 애플리케이션 사용 지침");
		System.out.println("1. ");
		System.out.println("1. ");
		System.out.println("1. ");
	}
}

public class Java_Object_4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EventManager eventManager = new EventManager();
		
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println("=================== MENU ===================");
			System.out.println("1.이벤트 추가 2.이벤트 취소 3.이벤트 정보 4.참가자 추가 5.참가자 정보 6.참가자 정보 수정 help.도움말 0.종료");
			System.out.print("Menu에서 원하는 명령을 선택하세요 >> ");
			String command = br.readLine();
			if(command.equals("0")) {
				System.out.println("시스템 종료");
				break;
			}
			
			System.out.println();
			switch(command) {
				case "1" : { // 이벤트 추가 - 완료
					System.out.println("*이벤트 추가를 선택했습니다*");
					System.out.print("이벤트 이름을 입력해주세요 >> ");
					String eventNameInput = br.readLine();
					System.out.print("이벤트 장소를 입력해주세요 >> ");
					String eventLocationInput = br.readLine();
					System.out.print("이벤트 날짜를 입력해주세요 >> ");
					String eventDateInput = br.readLine();
					System.out.print("이벤트 수용 인원을 입력해주세요 >> ");
					int eventMaxParticipant = Integer.parseInt(br.readLine());
					
					eventManager.createEvent(eventNameInput, eventLocationInput, eventDateInput, eventMaxParticipant);
					break;
				}
				case "2" : { // 이벤트 취소 - 완료
					if(eventManager.events.size()==0) {
						System.out.println("현재 등록된 이벤트가 없어 MENU로 이동합니다");
						break;
					}
					System.out.println("*이벤트 취소를 선택했습니다*");
					System.out.println("---현재 등록된 이벤트 목록---");
					for(Event event : eventManager.events) {
						System.out.println(event.eventName);
					}
					System.out.println();
					System.out.print("취소할 이벤트의 이름을 입력해주세요 >> ");
					String eventNameInput = br.readLine();
					
					eventManager.cancelEvent(eventNameInput);
					break;
				}
				case "3" : { // 이벤트 조회 - 완료
					System.out.println("*이벤트 정보를 선택했습니다*");
					System.out.println("---현재 등록된 이벤트 목록---");
					for(Event event : eventManager.events) {
						System.out.println(event.eventName);
					}
					System.out.println();
					System.out.print("보고싶은 이벤트의 이름을 입력해주세요 >> ");
					String eventNameInput = br.readLine();
					
					eventManager.getEventSummary(eventNameInput);
					break;
				}
				case "4" : { // 참가자 추가 - 완료
					if(eventManager.events.size()==0) {
						System.out.println("참가자를 추가하기 위해선 최소 하나 이상의 이벤트를 등록해야합니다");
						break;
					}
					System.out.println("*참가자 추가를 선택했습니다*");
					System.out.print("참가자 이름을 입력해주세요 >> ");
					String participantNameInput = br.readLine();
					
					while(!eventManager.registerParticipant(participantNameInput)) {
						participantNameInput = br.readLine();
					}
					
					System.out.print("참가자가 속한 이벤트의 개수를 입력하세요 >> ");
					String N = br.readLine();
					int intN = Integer.parseInt(N);
					if(N.isEmpty()) {
						System.out.println("아무런 입력이 없어 이벤트를 추가하는 과정은 자동으로 건너뜁니다");
						System.out.println("6번 메뉴에서 이벤트에 대한 수정이 가능합니다");
						break;
					}
					
					while(intN > eventManager.events.size()) {
						System.out.println("\n"+eventManager.events.size()+" 이하의 숫자를 입력하세요");
						System.out.println(">> ");
						N = br.readLine();
						intN = Integer.parseInt(N);
					}
					
					System.out.println("---현재 등록된 이벤트 목록---");
					for(Event event : eventManager.events) {
						System.out.println(event.eventName);
					}
					System.out.println();
					
					String[] eventNameInput = new String[intN];
					System.out.print("참가자가 속한 이벤트를 하나씩 입력하세요 >> ");
					for(int i = 0 ; i < intN; i++) {
						eventNameInput[i] = br.readLine();
					}
					eventManager.participantJoinEvent(participantNameInput, eventNameInput);
					break;
				}
				case "5" : { // 특정 참가자 조회 - 완료
					if(eventManager.participants.size() == 0) {
						System.out.println("현재 등록된 참가자가 존재하지 않습니다");
						System.out.println("4번 메뉴를 통해 참가자부터 등록하세요");
						break;
					}
					
					System.out.println("*참가자 정보 조회하기를 선택했습니다*");
					System.out.println("---현재 등록된 참가자 목록---");
					for(String participantName : eventManager.participants.keySet()) {
						System.out.println("- "+participantName);
					}
					System.out.println();
					System.out.print("조회하려는 참가자의 이름을 입력해주세요 >> ");
					String participantNameInput = br.readLine();
					
					while(!eventManager.getParticipantSummary(participantNameInput)) {
						System.out.print("정확한 참가자의 이름을 입력해주세요 >> ");
						participantNameInput = br.readLine();
					}
					
					System.out.println("\n참가자 정보를 수정하시겠습니까? yes or no");
					System.out.print(">> ");
					String nextStep = br.readLine();
					if(nextStep.equals("yes")) {
					} else if(nextStep.equals("no")) {
						break;
					} else {
						System.out.println("잘못된 입력으로 메뉴 창으로 나갑니다");
						break;
					}
				}
				case "6" : { // 참가자 이벤트 관리 - 진행 중
					if(eventManager.participants.size() == 0) {
						System.out.println("현재 등록된 참가자가 존재하지 않습니다");
						System.out.println("4번 메뉴를 통해 참가자부터 등록하세요");
						break;
					}
					
					System.out.println("*참가자 정보 수정하기를 선택했습니다*");
					System.out.println("---현재 등록된 참가자 목록---");
					for(String participantName : eventManager.participants.keySet()) {
						System.out.println("- "+participantName);
					}
					System.out.println();
					System.out.print("수정하려는 참가자의 이름을 입력해주세요 >> ");
					String participantNameInput = br.readLine();
					
					while(eventManager.findParticipantByName(participantNameInput) == null) {
						System.out.println("존재하지 않는 참가자입니다");
						System.out.print("정확한 참가자의 이름을 입력해주세요 >> ");
						participantNameInput = br.readLine();
					}
					eventManager.editParticipant(participantNameInput);
					break;
				}
				case "help" : {
					eventManager.showHelp();
					break;
				}
				default : { //재입력
					System.out.println("잘못된 입력입니다.\n다시 입력해주세요");
					break;
				}
			}//switch
		}//while
		
		br.close();
	}//main
}//main Class
