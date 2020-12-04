package legacy.example2;

import java.util.Date;

public class UnderstandDI {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
	}

	public static void getDate(Date d) {
		Date date = d;
		System.out.println(date);
	}
	
	public static void memberUse1() {
		Member m1 = new Member();
	}
	
	public static void memberUse2(Member m) {
		Member m2 = m;
	}
}

//Member를 사용한다  -> Member의 기능에 의존한다.
class Member {
	String name;
	String nickname;
	
	public Member() {}
	
}
