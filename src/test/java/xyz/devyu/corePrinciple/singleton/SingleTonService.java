package xyz.devyu.corePrinciple.singleton;

// JVM이 실행될 때, static 영역에 'SingleTonService' 인스턴스를 생성한 뒤 참조를 걸어둔다.
public class SingleTonService {

    // static 키워드를 사용 -> class level에 존재하므로 단 하나의 인스턴스만 존재하게 됨.
    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }

    // 외부에서 인스턴스를 생성하지 못하도록 -> 싱글톤 유지
    private SingleTonService() {
    }

}
