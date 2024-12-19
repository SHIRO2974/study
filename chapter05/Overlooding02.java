package chapter05;

/*  음식점 클래스
    다양한 방법으로 주문을 받는 메서드
*/
    class Restaurant {
/*
       메서드 정의
       : placeOrder 주문 메서드

       >> 메뉴 이름 (String dish)
       >> 메뉴 이름, 수량 제공 (int quantity)
       >> 메뉴 이름, 특별 요청 사항 (String specialRequests)
       >> 메뉴 이름, 수량 제공, 특별 요청 사항
*/

    void placOrder(String dish) {
        System.out.println(dish);
    }

    void placOrder(String dish, int qiantity) {
        System.out.println("메뉴: " + dish + " , " + qiantity + "개");
    }

    void placOrder(String dish, String specialRequsets) {
        System.out.println("메뉴: " + dish + " , " + specialRequsets);
    }

    void placOrder(String dish, int qiantity, String specialRequsets) {
        System.out.println("메뉴: " + dish + " , " + qiantity + "개" + " , " + specialRequsets);

    }
}
public class Overlooding02 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.placOrder("햄버거");
        restaurant.placOrder("피자", 2);
        restaurant.placOrder("파스타", "치즈많이");
        restaurant.placOrder("햄버거",2, "피클뺴고");

    }

}
