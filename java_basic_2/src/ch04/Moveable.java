package ch04;

public interface Moveable {
	int a = 10;
	static final int A = 10; // 무조건 상수 이어야 한다.
	public void left(); // 인터페이스 안에 선언된 메서드, 함수는 추상 메서드 이어야 한다.
	
	// 약속 - 자바문법 (이해 X 외워야함)
	// 인터페이스는 구현된 것이 아무 것도 없는 밑그림만 있는 설계도면 이다.

}
