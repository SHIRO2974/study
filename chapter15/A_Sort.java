package chapter15;

import java.util.*;
import java.util.stream.Collectors;

/*      스트림 API

        1. 스트림 생성
           .stream() 메서드 사용

        2. 중간 연산
           .map (Function)
           .filter (Predication)
           .sorted (Comparator)

        3. 최종 연산
           .collect
           .foreach

       === 자바에서 배열과 리스트의 정렬 ===
        1. 배열 정렬
          Arrays 클래스에서 제공하는 정적 메서드 사용
          Arrays.sort()
          - 오름차순 정렬만 지원

          내림차순 정렬은 Comparator 클래스를 사용

        2. 리스트(List 클래스) 정렬
          Collections.sort() 또는 List 클래스의 sort() 메서드를 사용
*/
public class A_Sort {
    public static void main(String[] args) {

//      1. 배열 정렬
//      1) 오름차순 정렬

        int[] numbers = {5,2,7,4,1};
        Arrays.sort(numbers);   // 오름차순 정렬
        System.out.println(Arrays.toString(numbers));   // [1, 2, 4, 5, 7]

//      2) 내림차순 정렬 - Comparator 클래스 내의 reverseOrder() 정적 메서드를 사용
//      Collections.reverseOrder() Comparator<T> 를 반환하는 메서드
//      객체간의 비교를 실시
//      기본 데이터 타입에 대한 비교 X, Comparator 는 객체 타입에 대한 비교 O
        Integer[] numbers2 = {5,1,4,6,7,};
        Arrays.sort(numbers2, Collections.reverseOrder());
        System.out.println(Arrays.toString(numbers2));  // [7, 6, 5, 4, 1]

//      2. 리스트 정렬
//      1) 오름차순
        List<Integer> number3 = new ArrayList<>(List.of(5,2,4,1));
        Collections.sort(number3);
        System.out.println(number3);    // [1, 2, 4, 5]

//      2) 내림차순
        Collections.sort(number3, Collections.reverseOrder());
        System.out.println(number3); // [5, 4, 2, 1]

//      == Comparator 클래스 사용 정렬
        List<String> names = new ArrayList<>(List.of("Tom", "Jerry", "Ruffy", "Pororo"));

//      문자열 길이 기준 정렬
//      순회) name -> name.length == String::length
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names);  // [Tom, Jerry, Ruffy, Pororo]

//      == 람다식 사용 ==
        List<String> names2 = new ArrayList<>(List.of("Pororo","Tom", "Jerry", "Ruffy"));
        names2.sort((a, b) -> b.length() - a.length());
/*          .sort() 메서드
            List 인터페이스의 메서드
           리스트를 특정 기전에 따라 정렬
           정렬 기준을 결정하는 Comparator 를 인수로 받음

           (a, b) -> b.length() - a.length()
           a 와 b 는 리스트 안의 두 개의 요소를 나타냄
           두 요소를 비교한 결과를 반환
           1) 반환값이 양수: b 가 a 보다 앞에 옴
           2) 반환값이 0: 순서 변경 X
           3) 반환값이 음수: a가 b보다 앞에 옴
           오름차순: a.length() - b.length()
*/
        System.out.println(names2); // [Pororo, Jerry, Ruffy, Tom]


//      == 스트림 API 사용 정렬
//      정렬된 결과를 새로운 리스트로 받음
        List<Integer> listNumbers = new ArrayList<>(List.of(2,1,4,3,5));

        List<Integer> sorted = listNumbers.stream()
                .sorted()   // 오름차순 - 중간연산자
                .collect(Collectors.toList());
        System.out.println(sorted); // [1, 2, 3, 4, 5]

        // == 내림차순 ==
        List<Integer> reverseSorted = sorted.stream()
                .sorted((a,b) -> b - a) // 내림차순
                .collect(Collectors.toList());
        System.out.println(reverseSorted);  // [5, 4, 3, 2, 1]

        List<String> charterNames = new ArrayList<>(List.of("Pororo","Tom", "Jerry", "Ruffy"));

        List<String> sortedCharacter = charterNames.stream()
                .sorted((n1, n2) -> n1.length() - n2.length())
                .collect(Collectors.toList());
        System.out.println(sortedCharacter);    // [Tom, Jerry, Ruffy, Pororo]

        // Comparator 클래스
        // 사용자 정의 정렬 정의 시 유용한 인터페이스
        // 람다식 & 메서드 참조와 함께 사용

        List<String> fruits = new ArrayList<>(List.of("banana", "strawberry", "mango","apple"));
        // 여러 조건으로 정렬
        // 1) 문자열 길이 기준 정렬
        fruits.sort(Comparator.comparingInt(String::length)
                // String 클래스 compareTo 메서드
                // 두 개의 문자열 값을 비교하여 int 값으로 반환해주는 함수
                .thenComparing(String::compareTo));
        System.out.println(fruits);     // [apple, mango, banana, strawberry]

    }
}
