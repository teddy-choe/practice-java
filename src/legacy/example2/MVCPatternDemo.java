package legacy.example2;

public class MVCPatternDemo {

	public static void main(String[] args) {
		Student model = retrieveStudentFromDatabase();
		
		StudentView view = new StudentView();
		
		StudentController controller = new StudentController(model, view);
		
		controller.updataView();
		
		/*
		 * 스튜턴트 네임 업데이트
		 */
		controller.setStudentName("John");
		
		controller.updataView();
	}
	
	/*
	 * student 타입을 반환하는 초기화 함수
	 */
	private static Student retrieveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}

}
