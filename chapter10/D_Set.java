package chapter10;

/*      === List 인터페이스 ===
        중복 O , 순서 O, >> Null 요소 포함 가능
        >> Null 요소 포함 가능


        === Set 인터페이스 ===
        중복 X , 순서 X, >> Null 요소 포함 가능
         중복된 요소를 포함하지 않는 객체의 집합
        > 객체의 저장 순서를 저장하지 않는다 ( 삽입 순서 유지 X)


        === Set 컬렉션종류 (구현체)
        1. HashSet
         가장 많이 사용되는 Set 구현체, 빠른 데이터 접근과 삽입을 지원
         정렬 또는 순서 보장X

        2. LinkedHashSet
          HashSet 에서 순서를 추가한 형태
          중복 X, 순서 O

        3. TreeSet
          데이터가 자동 정렬, 중복 제거와 정렬된 순서 유지가 필요할 때 사용
          중복X, 순서 O
*/

import java.util.HashSet;
import java.util.Set;

public class D_Set {
    public static void main(String[] args) {

        // === Set 주요 메서드
        // add, remove, contains, size, is empty

        // Set 컬렉션 선언 방법
        // Set<E> set 명 = new Set 컬랙션 종류<>();
        Set<String> emampleSet = new HashSet<>();
        emampleSet.add("자바");
        emampleSet.add("파이썬");
        emampleSet.add("스크립트");
        emampleSet.add("C++");

        System.out.println(emampleSet); // [C++, 스크립트, 파이썬, 자바]

        emampleSet.remove("자바");    // remove (제거하고자하는 값 입력)
        System.out.println(emampleSet); // [C++, 스크립트, 파이썬]

        System.out.println(emampleSet.size());  // 3

        // 중복된 데이터는 추가 할 수 없음
        emampleSet.add("파이썬");
        System.out.println(emampleSet); // [C++, 스크립트, 파이썬]

        System.out.println(emampleSet.contains("스크립트"));    // true
        System.out.println(emampleSet.contains("자바"));  // false

        System.out.println(emampleSet.isEmpty());   // false
        emampleSet.clear();
        System.out.println(emampleSet.isEmpty());   // true
    }
}
