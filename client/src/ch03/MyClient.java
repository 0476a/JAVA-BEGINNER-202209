package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyClient {

	Socket socket;
	final String IP = "localhost"; // 현재 본인 pc의 IP
	final int PORT = 2000;
	// ip주소 / 포트번호
	BufferedWriter bufferedWriter; // 보조 스트림
	// 키보드에서 --> 프로그램으로 데이터를 받는 스트림
	BufferedReader keyboardReader; // 키보드에서 오는 데이터를 받는 스트림
	
	// 새로운 쓰레드가 필요하다 <-- 서브측으로 부터 들어노는 메시지를 확인하는 녀석
	// 서버에서 온 데이터를 받는 스트림 생성
	BufferedReader bufferedReader;
	
	public MyClient() {
		System.out.println("1. 클라이언트 소켓 시작");
		// 클라이언트 역할을 하는 소켓
		// 서버 측으로 연결될 컴퓨터에 ip 주소와 포트번호를 알고 있어야 한다.
		// 크롬창에 www.naver.com : 8080 과 같은 의미
		try {
			socket = new Socket(IP, PORT);
			
			// 표준 입력 스트림 -- 키보드
			keyboardReader = new BufferedReader(new InputStreamReader(System.in));
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();
			
			while (true) {
				System.out.println("키보드로 글자를 입력해주세요");
				String keyboardMsg = keyboardReader.readLine();
				
				bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bufferedWriter.write(keyboardMsg + "\n");
				bufferedWriter.flush();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	// 내부 클래스 생성
	class ReadThread implements Runnable {

		@Override
		public void run() {
			
			while(true) {
				String msg;
				try {
					msg = bufferedReader.readLine();
					System.out.println("서버로 부터 온 메시지 : " + msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
	}
	public static void main(String[] args) {
		new MyClient();
	}
} // end of class

	

