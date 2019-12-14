package example2;

public class Student {
	private String rollNo;
	private String name;
	
	public String getRollNo() {
		return rollNo; // rollNo에 대한 Getter함수
	}
	
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo; // rollNo에 대한 Setter 함수
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
