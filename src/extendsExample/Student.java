package extendsExample;

public class Student extends Person {
    private String major;

    public Student(){
        super();
        System.out.println("Employee 생성자 실행!");
    }

    public
    Student(String name, int age, String major){
        super(name,age); // name,age를 인자로 받는 부모클래스의 생성자 실행
        this.major = major;
        System.out.println("Employee(name, age, major) 생성자 실행!");
    }

    public String getMajor(){
        return major;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public String toString(){
        return super.toString() + ":" + major;
    }
}
