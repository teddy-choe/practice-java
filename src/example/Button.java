package example;

public class Button {
	OnClickListener listener; // 인터페이스 타입 필드
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	interface OnClickListener {
		void onClick(); // 중첩 인터페이스 선언
	}
}
