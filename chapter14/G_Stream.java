package chapter14;

/*      스트림 API
        (컬렉션) 데이터의 처리를 선언적으로 작성할 수 있도록 지원하는 도구
        데이터를 필터링, 변환, 정렬, 집계 등의 작업
        - 람다 표현식과 결합하여 직관적이며 간결한 코드 작성

        === 특징 ===
        컬렉션 데이터를 간결하고 효율적으로 처리
        데이터 필터링, 매핑, 축소 등의 작업 용이
        함수형 프로그래밍 기법과 함께 사용

        1. 데이터 파이프 라인
           스트림은 데이터를 소스로부터 연속적으로 처리하는 파이프라인을 구축
           
        2. 데이터 변경 및 저장X (불변성, 메모리에 할당 X)
           스트림은 원본 데이터 변경 X, 새로운 값을 반환
           스트림은 데이터를 제공하지 않고 처리하는 방식만 제공

        3. 지연 평가
           중간 처리가 지연되어 최종 처리가 호출될 때 한 번에 처리

        === 스트림 API 기본 구성 요소 ===
        1. 소스(Source)
           스트림 생성 단계
           컬렉션, 배열 또는 파일을 소스로 사용

        2. 중간 연산
           데이터를 필터링, 매핑(변환)하는 과정
           연산을 연속적으로 사용 가능
           스트림은 새로운 스트림을 반환
           - filter, map, sorted 등

        3. 최종 연산
           모든 데이터를 처리한 후 결과를 반환하거나 출력하는 연산
           - collect, forEach, count 등
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class G_Stream {
    public static void main(String[] args) {
        List<String > names = new ArrayList<>();

        names.add("아무개");
        names.add("아무재");
        names.add("아무배");
        names.add("아무새");

        System.out.println(names);  // [아무개, 아무재, 아무배, 아무새]
/*

           1. 데이터 소스(Stream 생성)
              데이터.stream()

           2. 중간 연산
           : filter(조건에 맞는 요소만 선택), map(요소를 변환),
             sorted(요소 정렬), distinct(중복 제거),
             limit(처음부터 지정된 개수만큼 선택), skip(처음부터 지정된 개수만큼 건너뜀) 등

           3. 최종 연산
           : forEach(각 요소를 처리), collect(요소를 변환하여 컬렉션으로 반환),
             reduce(모든 요소를 하나의 값으로 줄임), count(요소의 개수를 반환) 등
*/

        names.stream()
                .map(name -> name + "님")
                .filter(name -> name.endsWith("님")) // 반대: startsWith();
//              .forEach(name -> System.out.println(name));

                // (instance::instanceMethod)
                .forEach(System.out::println);
/*              아무개님
                아무재님
                아무배님
                아무새님
*/

        System.out.println(names);  // [아무개, 아무재, 아무배, 아무새]

        // Arrays.asList();
        // : 일반 배열을 ArrayList 로 반환
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        List<Integer> newNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(newNumbers); // [1, 4, 9, 16, 25]
/*
           .stream() 으로 생성된 스트림은 일회성!!
           메서드 체이닝 가능
           스트림으로 생성된 데이터를 다시 스트림으로 변경 X
*/
        Stream<Integer> stream = newNumbers.stream();
        stream.map(n -> n * n)
                .collect(Collectors.toList());
/*
        stream.filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
                스트림을 재사용하는 경우 예외 발생: IllegalStateException
*/

    }
}
