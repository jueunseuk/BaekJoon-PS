public class Main1 {
	public static void main(String[] args) { // 메인으로 실행되는 메서드
		// 실린더 객체 생성
		// 일회용 Circle 객체와 반지름 전달해서 생성
		Cylinder cy = new Cylinder(new Circle(7), 8);
		System.out.println(cy.getVolume()); // 부피 출력
	}
}

class Cylinder {
	private Circle c; // Circle 객체를 멤버 변수로 설정
	private int h; // 실린더의 높이 변수
	
	public Cylinder(Circle c, int h) { // 실린더 생성자
		this.c = c; // 실린더의 멤버 변수 c에 매개변수 c를 할당
		this.h = h; // 실린더의 멤버 변수 h에 매개변수 h를 할당
	}
	
	public double getVolume() {
		return c.getArea() * h;
	}
}

class Circle {
	static final double PI = 3.141592; // 상수 파이 할당
	private int r; // int 타입의 반지름 변수
	
	public Circle(int r) { // Circle 생성자
		this.r = r; // Circle의 멤버 변수 r에 매개변수 r을 할당
	}
	
	public double getArea() { // Circle의 면적을 구하는 메서드
		return r * r * PI; // 반지름과 상수를 연산해서 면적 구함
	}
}