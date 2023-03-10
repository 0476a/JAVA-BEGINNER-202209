package swing.s_06;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame2 extends JFrame {

	JLabel jLabel;
	Container rootContainer;
	
	public MyFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		
		// 프레임 안에 자동으로 루트 패널이 생성 되어 실행 된다.
		rootContainer = getContentPane();
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jLabel = new JLabel("Hello Java");
	}

	private void setInitLayout() {
		setLayout(null);
		// 크기, 위치
		jLabel.setSize(100,100);
		jLabel.setLocation(200,200);
		add(jLabel);
		setVisible(true);
	}

	private void addEventListener() {
		// 이름이 다르다 !! - 마우스 이벤트 !!
		// 익명 클래스 -> 이름이 없는 클래스 (변수명이없다.)
		// 변수명이 없기 때문에 다른 메서드에서, 클래스에서 사용할 수 없다.
		// 딱 그 순간에 필요하기 때문에 사용한다.
		// MyFrame1 과 다른 코드 방식을 적용해 보자.
		
		// 추상 클래스 --> new 할 수 없다. (기본적으로)
		// 인터 페이스 --> new 할 수 없다. (기본적으로)
		// 익명 구현 클래스(인터페이스) --> 인터페이스를 new 키워드를 사용해서 추상메서드를
		// 오버라이드 해서 일반 메서드로 변경 완료 하였다.
		rootContainer.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(e.toString());
				System.out.println("mouseReleased 메서드 호출 됨!!!");
				jLabel.setLocation(e.getX(), e.getY());
			}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
	}
	
	// 테스트 코드
	public static void main(String[] args) {
		new MyFrame2();
	}

	
	
	
	
	
}
