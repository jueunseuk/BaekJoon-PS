import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Person{
	String name;
	int day;
	int month;
	int year;
	
	public Person(String name, int day, int month, int year) {
		super();
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}
}

public class Main_BJ_5635_사람정보다루기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Person> human = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			human.add(new Person(st.nextToken(),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		
		Person oldest = human.get(0);
		Person youngest = human.get(0);
		
		for(Person person : human) {
			if(isOld(person, oldest)) { // person이 나이가 더 많으면 true를 반환
				oldest = person;
			}
			else if(isYoung(person, youngest)) { // person이 나이가 더 적으면 true를 반환
				youngest = person;
			}
		}
		
		System.out.println(youngest.name);
		System.out.println(oldest.name);
	}

	private static boolean isYoung(Person person, Person youngest) {
		if(person.year > youngest.year) {
			return true;
		}
		else if(person.year == youngest.year) {
			if(person.month > youngest.month) {
				return true;
			}
			else if(person.month == youngest.month) {
				if(person.day > youngest.day) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isOld(Person person, Person oldest) {
		if(person.year < oldest.year) {
			return true;
		}
		else if(person.year == oldest.year) {
			if(person.month < oldest.month) {
				return true;
			}
			else if(person.month == oldest.month) {
				if(person.day < oldest.day) {
					return true;
				}
			}
		}
		return false;
	}
}