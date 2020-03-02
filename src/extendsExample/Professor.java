package extendsExample;

public class Professor extends Person {
    private String subject;

    public Professor(){
        super();
        System.out.println("Employee 생성자 실행!");
    }

    public Professor(String name, int age, String subject){
        super(name,age); // name,age를 인자로 받는 부모클래스의 생성자 실행
        this.subject = subject;
        System.out.println("Employee(name, age, subject) 생성자 실행!");
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String toString(){
        return super.toString() + ":" + subject;
    }
}
