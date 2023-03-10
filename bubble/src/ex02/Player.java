package ex02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable{

	private int x;
	private int y;
	
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	// 움직임 상태
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	
	
	public Player() {
		initData();
		setInitLayout();
	}

	private void initData() {
		playerL = new ImageIcon("image/playerL.png");
		playerR = new ImageIcon("image/playerR.png");
	}

	private void setInitLayout() {
		x = 55;
		y = 535;
		this.setIcon(playerR);
		this.setSize(50, 50);
		this.setLocation(x,y);
	}

	@Override
	public void left() {
		setIcon(playerL);
		x -= 10;
		setLocation(x,y);
	}

	@Override
	public void right() {
		setIcon(playerR);
		x += 10;
		setLocation(x,y);
	}

	@Override
	public void up() {
		System.out.println("점프");
	}

	@Override
	public void down() {
	}
}
