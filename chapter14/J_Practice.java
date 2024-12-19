package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 주문 목록에서 상품별 총 판매량 계산
@AllArgsConstructor
@Getter
@ToString
class Order {
        private String product; // 제품
        private int quantity;   // 수량
}
public class J_Practice {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("노트북", 5),
                new Order("핸드폰", 6),
                new Order("테블릿", 4),
                new Order("노트북", 3),
                new Order("핸드폰", 3)
        );

        // 상품별 총 판매량 계산
        Map<String, Integer> productSales = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,
                        Collectors.summingInt(Order::getQuantity)));

        System.out.println(productSales);   // {핸드폰=9, 노트북=8, 테블릿=4}

    }
}
