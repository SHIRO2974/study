package chapter10;

/*      === Map 인터페이스 ===
         키(key) 와 값(Value) 의 쌍으로 요소를 저장하는 데이터 구조
         키는 고유한 데이터를 가짐 (중복 키 허용)
         동일한 키에 서로 다른 값을 전달하는 경우 기존 값이 새로운 값으로 덮어씌워짐

         Ex) name: "이재현" 가 존재한 상태에서 name: "아무개" 를 추가하는 경우
            name 의 키에는 "아무개" 만이 존재

        서로 다른 키에서 동일한 값 저장은 가능

        키의 유일성, 값의 중복성
        +) 순서 보장 X (LinkedHashMap)은 순서보장 O
           키를 기반으로 빠른 검색 가능

       Map 인터페이스 종류 (구현체)
       1. HashMap
         가장 많이 사용되는 Map 구현체
         키와 값에 null 허용
         빠른 검색 및 삽입 성능 제공
         - 순서 유지 X

       2. LinkedHashMap
         HashMap + 삽입 순서 유지
         - 삽입 순서 중요하고 빠른 검색이 중요할 때 주로 사용

       3. TreeMap
         키에 따라 자동 정렬 기능 보장
         키에 null 허용 X
*/

import java.util.*;

public class E_Map {
    public static void main(String[] args) {
/*
           Map 인터페이스 메서드
           put(K key, V value): 키와 값을 Map 에 추가
           get(Object key): 지정된 키에 매핑된 '값' 을 반환
           remove(Object key) : 주어진 키와 연관된 '키-값' 쌍 삭제 (반환)
           containsKey(Object key) : 주어진 키가 Map 에 있는지 확인하여 boolean 값으로 반환

           keySet(): Map 의 키를 Set 로 반환
           values(): Map 의 값을 컬렉션 타입으로 반환
                Collection 의 경우 컬렉션 프레임워크들의 상위 집합
           entrySet(): Map 의 키-값 쌍을 나타내는 Set 을 반환

           Map 컬렉션 선언 방법
           Map<반환타입,반환타입> Map 명 = new 컬렉션 종류<>();
*/
        Map<String,Integer> student = new HashMap<>();
        // 이름(키), 나이(값)
        student.put("이재현", 50);
        student.put("이무개", 40);
        student.put("아무개", 20);

        System.out.println(student);    // {아무개=20, 이무개=40, 이재현=50}
        // 순서 보장 X, {} 중괄호 형식 사용, 키와 값을 = 로 구분

        System.out.println(student.get("이재현")); // 50   get = 값을 반환

        student.remove("아무개");
        System.out.println(student);    // {이무개=40, 이재현=50}

        System.out.println(student.containsKey("이재현")); // true
        System.out.println(student.containsKey("아무개")); // false

        System.out.println(student.size()); // 2

        System.out.println(student.keySet());   // [이무개, 이재현]
        Set<String> names = student.keySet();

        System.out.println(student.values());   // [40, 50]
        Collection<Integer> ages = student.values();

        // Collection 을 List 로 변환
        // List 인터페이스의 구현체로 변환
        List<Integer> listAges = new ArrayList<>(ages);

        System.out.println(student.entrySet()); // [이무개=40, 이재현=50]

    }
}
