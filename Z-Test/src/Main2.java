
public class Main2 {

	public static void main(String[] args) {
		Triangle t = new Triangle(); // 삼각형 객체 생성
		System.out.println(t.getArea(3.0, 4.0)); // 오버라이딩된 메서드 호출
		System.out.println(t.getShapeArea(3.0, 4.0)); // 삼각형이 상속 받은 Shape 클래스의 면적 출력
	}
}

class Shape {
	public double getArea(double h, double w) { // 면적 구하는 메서드
		return h * w; // 일반적인 사각형의 면적 반환
	}
}

class Triangle extends Shape { // 기본 생성자 생력된 삼각형 클래스, Shape를 상속 받음
	public double getArea(double h, double w) { // 삼각형의 면적
		return h * w * 0.5; // 삼각형을 위한 면적 계산 반환
	}
	public double getShapeArea(double h, double w) { // 사각형의 면적
		return super.getArea(h, w); // super 키워드로 부모 클래스 메서드 직접 호출
	}
}