package example;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn = new Button(); // 버튼 타입에 버튼 객체를 참조한다
		
		btn.setOnClickListener(new CallListener()); // 버튼 클래스의 메소드를 통해 인터페이스 타입에 콜리스너 객체를 참조시킨다.
		btn.touch(); // 콜리스너의 오버라이딩된 메소드를 실행한다.
		
		btn.setOnClickListener(new MessageListener());
		btn.touch(); // 메세지리스너의 오버라이딩된 메소드를 실행한다.
	}
}
