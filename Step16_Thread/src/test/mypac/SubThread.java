package test.mypac;
/*
 * 새로운 작업단위(스레드) 만드는 방법
 * 
 * 1.Thread클래스 상속받는 클래스를 정의한다
 * 2.run() 메소드를 오버라이드 한다.
 * 3.해당클래스로 객체를 생성한다.
 * 4.생성한 객체의 start() 메소드를 호출하면
 * 	run() 메소드가 호출되면서 새로운 작업단위(스레드)가 시작된다.
 * 	새로운 작업단위에서 할 작업은 run() 메소드 안에 코딩하면 됩니다. 
 */
public class SubThread extends Thread {//1.Thread를 상속받는다
	@Override
	public void run() {//2.원하는 작업 내용 
		try {
			System.out.println("무언가 10초(오랜시간)이 걸리는 작업을 합니다.");
			Thread.sleep(10000);
			System.out.println("시간이 오래걸리는 작업이 끝났습니다.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
