package extendsExample;

public class Person {
    private String name;
    private int age; // 객체의 캡슐화를 위해선 데이터에 접근 못하게 해야한다.

    public Person(){
        System.out.println("Person 생성자 실행!");
    }

    /*
    생성자 오버로딩
     */
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age; // age = age면 지역변수에 지역변수를 넣는 꼴이라 메소드 종료시 의미없어진다.
    }

    public String toString(){
        return name + ":" + age;
    }
}
