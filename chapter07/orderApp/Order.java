package chapter07.orderApp;

/*      Order 클래스 - 실제 주문 로직 구현

        특정 제품(Product)과 수량을 기반으로 주문 생성
       +) 총 가격(세금 포함)을 계산하는 역할
*/

public class Order {
    private Product product;
    private int quantity;   // 수량

    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    // 총 가격 계산 메서드
    double calculateeToTalPrice() {
        double tex = product.calculateTax();
        double totalPrice = (product.getPrice() + tex) * quantity;
        return  totalPrice;
    }
    // 주문 정보를 반환하는 메서드
    public String toString() {
        return "Order Detail[ " + product.getName() + " / " + "Quantity : " + quantity + " >> " + calculateeToTalPrice()
                + " ]"; // Order Detaol [ snake * 2 >> 18000 ]
    }
}
