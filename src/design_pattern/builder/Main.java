package design_pattern.builder;

/*
 * 이펙티브 자바 아이템 2 - 매개변수가 많을 때는 빌더 패턴을 사용하라
 * 계층적 생성자 패턴, 자바 빈즈 패턴을 사용할 수 있지만, 확장성과 일관성의 문제로 빌더 패턴이 유리하다
 */
public class Main {
    public static void main(String[] args) {
        Building building = new Building.Builder(1)
                .floor(5)
                .livingNum(10)
                .build();

        System.out.println(building.getBuildingId() + building.getFloor() + building.getLivingNum());
    }
}
