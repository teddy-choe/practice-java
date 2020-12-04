package legacy.example2;

public class StudentController {
	private Student model; //모델 클래스 초기화
	private StudentView view; //뷰 클래스 초기화
	
	/*
	 * 생성자 함수 정의
	 */
	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setStudentName(String name) {
		model.setName(name); //모델 클래스의 setname함수 호출해서 name 데이터 설정
	}
	
	public String getStudentName() {
		return model.getName();
	}
	
	public void setStudentRollNo(String rollNo) {
		model.setRollNo(rollNo);
	}
	
	public String getStudentRollNo() {
		return model.getRollNo();
	}
	
	public void updataView() {
		view.printStudentDetails(model.getName(), model.getRollNo()); //함수를 매개값으로 넣을 수 있다
	}
}
