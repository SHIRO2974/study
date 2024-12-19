package chapter09;

/*          java.time 패키지
            ISO - 8601 표준을 기반으로 설계
            YYYY - MM - DDThh:mm:ss.sssZ
*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.DuplicateFormatFlagsException;
import java.util.Locale;

public class JavaTime {
    public static void main(String[] args) {

        System.out.println("========= LocalDate ===========");
/*
         1) LocalDate (날짜)
            : 날짜(년도, 월, 일)
            .new() - 현재 날짜 반환
            .of(년도, 월, 일) - 특정 날짜 반환
*/
        LocalDate today = LocalDate.now();
        System.out.println(today);  // 2024-12-05

        LocalDate specificDate = LocalDate.of(2025,3,14);
        System.out.println(specificDate);   // 2025-03-14

        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);   // // 2024-12-06

        LocalDate oneMonthAgo = today.minusMonths(1);
        System.out.println(oneMonthAgo);    // 2024-11-05

        System.out.println("========= LocalTime ===========");
/*      2) LocalTime (시간)
         시간(시, 분, 초, 나노초)만 다룸
         날짜와 시간대 정보는 포함하지 않는다
         .new() - 현재 시간 반환
         .of(년도, 월, 일) - 특정 시간 반환
*/
        LocalTime now = LocalTime.now();
        System.out.println(now);    // 12:19:49.594956

        LocalTime specificTime = LocalTime.of(14, 30);
        System.out.println(specificTime);   // 14:30

        LocalTime thirtyThreeMinutesLater = now.plusMinutes(33);
        System.out.println(thirtyThreeMinutesLater);    // 12:52:49.594956

        LocalTime oneHourAgo = now.minusHours(1);
        System.out.println(oneHourAgo); // 11:19:49.594956

        // cf) get 메서드
        // getYear(), getMonth(), getDayOfMonth(): 날짜 정보 반환
        // getHour(), getMinute(), getSecond(): 시간 정보 반환
        System.out.println(today.getMonth()); // DECEMBER - 키워드
        System.out.println(now.getHour()); // 12


//      cf) LocalDateTime 클래스
//        : 날짜와 시간을 함께 다루는 클래스
//        .now(), .of(), .plus~(), .minus~() 사용 가능
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime); // 2024-12-05T12:23:55.865501
        System.out.println(nowDateTime.toLocalDate()); // 2024-12-05
        System.out.println(nowDateTime.toLocalTime()); // 12:23:38.332914700


        // 날짜와 시간 포맷팅(formatting)
        LocalDateTime example = LocalDateTime.now();
        System.out.println(example);    // 2024-12-05T12:29:53.533818600
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(example.format(formatter));  // 2024-29-05 12:29:23
    }
}
