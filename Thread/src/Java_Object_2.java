/*요구 사항:
Book 클래스: 책을 나타내는 클래스를 작성하세요.
필수 필드: 책 제목, 대여 가능 여부
메서드: 책을 대여하는 메서드, 책을 반납하는 메서드, 책의 현재 상태를 반환하는 메서드

Library 클래스: 도서관을 관리하는 클래스를 작성하세요.
필수 필드: 책 목록
메서드: 책을 추가하는 메서드, 책을 대여하는 메서드, 책을 반납하는 메서드, 도서 목록을 출력하는 메서드

*입력 예씨*
3
Add Book1
Add Book2
Add Book3
Borrow Book1
Borrow Book2
Return Book1
Status

*출력 예시*
Book1 is available
Book2 is borrowed
Book3 is available
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Book{
	String title;
	boolean isRentaled;
	
	public Book(String title) {
		super();
		this.title = title;
		this.isRentaled = false;
	}

	public boolean rentalBook() {
		if(!isRentaled) {
			isRentaled = true;
			return true;
		}
		return false;
	}
	
	public void returnBook() {
		isRentaled = false;
	}
	
	public boolean stateBook() {
		return isRentaled ? true : false;
	}
}

class Library{
	Map<String, Book> books;

	public Library() {
		super();
		this.books = new HashMap<>();
	}
	
	// 추가 메서드
	public void addBook(String title) {
		books.putIfAbsent(title, new Book(title));
	}
	
	// 대여 메서드
	public void rentalBook(String title) {
		Book book = books.get(title);
		if (book.rentalBook()) {  // 대여 성공 시 상태를 변경
            System.out.println("You succeeded in borrowing " + title);
        } else {
            System.out.println(title + " is currently on rent.");
        }
	}
	
	// 반납 메서드
	public void returnBook(String title) {
		Book book = books.get(title);
		if(book.isRentaled) {
			book.returnBook();
			System.out.println("반납 성공!");
		}
		else {
			System.out.println("대여 중인 도서가 아닙니다.");
		}
	}
	
	// 도서 목록 출력
	public void bookList() {
		StringBuilder sb = new StringBuilder();
		for(Book book : books.values()) {
			sb.append(book.title);
			if(!book.isRentaled)
			sb.append(" is available.").append("\n");
			else {
				sb.append(" is NOT available.").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}


public class Java_Object_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Library library = new Library();
		
		for(int i = 0; i < N; i++) {
				library.addBook(br.readLine());
		}
		
		while(true) {
			String inputCommand = br.readLine();
			if(inputCommand.isBlank()) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(inputCommand, " ");
			
			String command = st.nextToken();
			String title = "";
			if(st.hasMoreTokens()) {
				title = st.nextToken();
			}
			
			switch(command) {
				case "borrow" : {
					library.rentalBook(title);
					break;
				}
				case "return" : {
					library.returnBook(title);
					break;
				}
				case "status" : {
					library.bookList();
					break;
				}
			default : System.out.println("입력 종료"); break;
			}
			
		}
	}

}
