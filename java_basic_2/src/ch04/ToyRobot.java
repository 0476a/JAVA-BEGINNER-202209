package ch04;

public class ToyRobot implements RemoteController, SoundEffect{

	public String name;

	@Override
	public void turnOn() {
		System.out.println("장난감 로봇을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("장난감 로봇을 끕니다.");
	}

	@Override
	public void notification() {
		System.out.println("땅땅땅따아앙~~~");
	}

}
