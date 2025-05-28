import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Video {
    private String videoName;
    private boolean isAvailable;

    public Video(String videoName) {
        this.videoName = videoName;
        this.isAvailable = true;
    }

    public boolean rentOut() {
        if (isAvailable) {
            isAvailable = false; // 대여 가능 상태를 false로 변경
            return true; // 대여 성공
        }
        return false; // 대여 실패
    }

    public void returnBack() {
        isAvailable = true; // 반납 후 대여 가능 상태로 변경
    }

    public String getStatus() {
        return isAvailable ? "available" : "borrowed";
    }

    public String getTitle() {
        return videoName;
    }
}

class Customer {
    private String name;
    private List<Video> rentList;

    public Customer(String name) {
        this.name = name;
        this.rentList = new ArrayList<>();
    }

    public void rentVideo(Video video) {
        rentList.add(video);
    }

    public void returnVideo(Video video) {
        if (rentList.remove(video)) {
            video.returnBack();
        } else {
            System.out.println(video.getTitle() + " was not rented by " + name);
        }
    }

    public void showRentedVideos() {
        System.out.print(name + "'s borrowed videos: ");
        if (rentList.isEmpty()) {
            System.out.println("None");
        } else {
            for (Video video : rentList) {
                System.out.print(video.getTitle() + " ");
            }
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }
}

class VideoStore {
    private Map<String, Video> videoList;
    private Map<String, Customer> customerList;

    public VideoStore() {
        this.videoList = new HashMap<>();
        this.customerList = new HashMap<>();
    }

    // 비디오 추가
    public void addVideoToCollection(String title) {
        videoList.putIfAbsent(title, new Video(title));
    }

    // 비디오 삭제
    public void removeVideoFromCollection(String title) {
    	
    }
    
    // 고객 추가
    public void registerCustomer(String name) {
        if (!customerList.containsKey(name)) {
            customerList.put(name, new Customer(name));
            System.out.println(name + " has been registered as a new customer.");
        } else {
            System.out.println(name + " is already a registered customer.");
        }
    }

    // 비디오 대여
    public void lendVideoToCustomer(String name, String title) {
        Video video = videoList.get(title);
        Customer customer = customerList.get(name);

        if (video == null) {
            System.out.println("Video not found.");
            return;
        }
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        if (video.rentOut()) {
            customer.rentVideo(video);
            System.out.println(name + " borrowed " + title);
        } else {
            System.out.println(title + " is currently on rent.");
        }
    }

    // 비디오 반납
    public void acceptVideoReturn(String name, String title) {
        Video video = videoList.get(title);
        Customer customer = customerList.get(name);

        if (video == null) {
            System.out.println("Video not found.");
            return;
        }
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        customer.returnVideo(video);
        System.out.println(name + " returned " + title);
    }

    // 비디오 및 고객 상태 출력
    public void displayStoreStatus() {
        for (Video video : videoList.values()) {
            System.out.println(video.getTitle() + " is " + video.getStatus());
        }
        for (Customer customer : customerList.values()) {
            customer.showRentedVideos();
        }
    }
}

public class Java_Object_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        VideoStore videoStore = new VideoStore();

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) { // while 종료 조건
                break;
            }
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "AddVideo":
                    videoStore.addVideoToCollection(commands[1]);
                    break;
                case "AddCustomer":
                    videoStore.registerCustomer(commands[1]);
                    break;
                case "Borrow":
                    videoStore.lendVideoToCustomer(commands[1], commands[2]);
                    break;
                case "Return":
                    videoStore.acceptVideoReturn(commands[1], commands[2]);
                    break;
                case "Status":
                    videoStore.displayStoreStatus();
                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}
