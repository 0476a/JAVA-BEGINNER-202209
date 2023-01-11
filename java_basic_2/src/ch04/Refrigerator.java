package ch04;

public class Refrigerator extends HomeAppliances implements RemoteController, SoundEffect{

	@Override
	public void turnOn() {
		System.out.println("냉장고를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("냉장고를 끕니다.");
	}

	@Override
	public void notification() {
		System.out.println("띠ㄸ리링~!~~ ");
	}

}
