package xyz.devyu.corePrinciple.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);

        // 싱글톤 패턴을 사용할 경우 문제가 되는 코드
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
