package chapter11;

/*      === SOLID 원칙 ===
        1. SRP (단일 책임 원칙)
          - 클래스는 하나의 책임만 가져야 한다

        2. OCP (개방-폐쇠 원칙)
           - 클래스는 확장에 열려 있고, 수정에는 닫혀 있어야 한다.

        3. LSP (리스코프 치환 원칙)
           - 자식 클래스는 부모 클래스를 대체할 수 있어야 한다.

        4. ISP (인터페이스 분리 원칙)
            - 클라이언트는 자신이 사용하지 않는 인터페이스에 의존하지 않아야 한다.

        5. DIP (의존성 역전 원칙)
            - 고수준 모듈이 저수준 모듈에 의존하지 않고, 추상화에 의존해야 한다.
*/

//      === SOLID 원칙 예시 (주문 관리 시스템) ===

class Order {

    private String orderId;
    private int amount; // 갯수

    public Order(String orderId, int amount) {

        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getAmount() {
        return amount;
    }
}

// OCP, DIP: 확장 가능하도록 PaymentProcessor 를 추상화

interface PaymentProcessor {

    void processPayment(Order order);

}

class PaypalPaymentProcessor implements PaymentProcessor{

    public void processPayment(Order order) {
        System.out.println("신용카드로 결제를 진행합니다.: " + order.getOrderId());
    }

}

class PayoakPaymentProcessor implements PaymentProcessor {

    public void processPayment(Order order) {
        System.out.println("페이팔로 결제를 진행합니다.: " + order.getOrderId());
    }
}

// ISP: 클라이언트가 불필요한 인터페이스에 의존 X
interface GeneratorReport {
    void generateReport(Order order);
}

class PdfReport implements GeneratorReport {

    public void generateReport(Order order) {
        System.out.println("주문 정보 보고서를 PDF 파일로 생성: " + order.getOrderId());
    }
}

// DIP(의존성 역전 원칙)
//  OrderService (고수준 모듈)
class OrderService {
    // 결제 방식과 보고서 생성의 인터페이스에 의존
    // cf) CreditCardPaymentProcessor, PaypalPaymentProcessor(저수준 모듈)
    private final PaymentProcessor paymentProcessor;
    private final GeneratorReport generatorReport;

    // OrderService 생성자: 결제 처리기와 보고서 생성기를 주입받음
    public OrderService(PaymentProcessor paymentProcessor, GeneratorReport generatorReport) {

        this.paymentProcessor = paymentProcessor; // 결제 처리기 초기화
        this.generatorReport = generatorReport; // 보고서 생성기 초기화
    }
        // 주문 처리 메서드
    void placeOrder(Order order) {
        paymentProcessor.processPayment(order); // 결제 처리기에 결제 로직 호출
        generatorReport.generateReport(order);  // 보고서 생성기에 보고서 생성 로직 호출
        System.out.println("Order processed successfully.");
    }
}

public class C_OOP {
    public static void main(String[] args) {
        // CreditCardPaymentProcessor
        PaymentProcessor paymentProcessor = new PaypalPaymentProcessor();

        // generatorReport 를 보고서 생성기로 선택
        GeneratorReport generatorReport = new PdfReport();

        OrderService orderService = new OrderService(paymentProcessor, generatorReport);
        Order order1 = new Order("1", 18000);
        Order order2 = new Order("2", 17000);
        Order order3 = new Order("3", 16000);
        orderService.placeOrder(order1);
        orderService.placeOrder(order2);
        orderService.placeOrder(order3);


    }
}
