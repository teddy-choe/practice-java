package extendsExample;

public class Employee extends Person {
    private String dept;

    public Employee(){
        super();
        System.out.println("Employee 생성자 실행!");
    }

    public Employee(String name, int age, String dept){
        super(name,age); // name,age를 인자로 받는 부모클래스의 생성자 실행
        this.dept = dept;
        System.out.println("Employee(name, age, dept) 생성자 실행!");
    }

    public String getDept(){
        return dept;
    }

    public void setDept(String dept){
        this.dept = dept;
    }

    public String toString(){
        return super.toString() + ":" + dept;
    }
}
