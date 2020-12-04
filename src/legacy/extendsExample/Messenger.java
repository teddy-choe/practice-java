package legacy.extendsExample;

public interface Messenger {

    public static final int MIN_SIZE = 1;
    public static final int MAX_SIZE = 104857600; // 상수 사용이나 값을 함부로 변경하지 못하게 하려고

    public abstract String getMessage();

    public abstract void setMessage(String msg);

    /*
    java8부터 가능한 본문 작성하는 인터페이스 내 디폴트 메서드
     */
    public default void setLogin(boolean login) {
        log();
        if (login) {
            System.out.println("로그인 처리합니다.");
        } else {
            System.out.println("로그아웃 처리합니다.");
        }
    }

    public static void getConnection(){
        System.out.println("네트워크에 연결합니다.");
    }

    private void log(){
        System.out.println("start Job!");
    }

}