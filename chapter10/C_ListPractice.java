package chapter10;
/*

         === 이벤트 관리 시스템 ===
         - 이벤트 참가자 명단과 대기열 관리를 위한 시스템
         - 참가자는 사전 등록된 명단을 통해 이벤트에 참가
         - 명단이 꽉 차면 대기열로 추가, 참가자가 떠나면 대기열에 다음 사람이 추가

         1) 이벤트 참가자 명단 관리
         : 사전에 등록, 이벤트 당일에는 추가적인 참가자 등록 X
         >> ArrayList (목록 추가, 삭제 X / 참가자 조회 O)

         2) 대기열 관리
         : 이벤트에는 한정된 좌석, 좌석이 모두 차면 추가 도착 참가자들은 대기열에 등록
         >> LinkedList (목록 추가, 삭제 O / 참가자 조회 X)
*/

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {

    // === 필드 ===
    // 이벤트 참가자 명단
    ArrayList<String> participantList = new ArrayList<>();

    // 대기열 명단
    LinkedList<String> waitingQueue = new LinkedList<>();

    // === 메서드 ===
    void addParticipant(String name) {
        participantList.add(name);
    }

    void addToWaitingQueue(String name) {
        waitingQueue.add(name);

    }

    void leaveParticipant(String name) {

        if (waitingQueue.size() > 0) {
            String nextParticipant = waitingQueue.remove(0);
            addParticipant(nextParticipant);
        }
    }

    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}

public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("이재현");
        eventManagement.addParticipant("이재이");
        eventManagement.addParticipant("이재흐");
        eventManagement.addParticipant("이재자");
        eventManagement.addParticipant("이재하");
        eventManagement.addParticipant("이재비");


        eventManagement.addToWaitingQueue("아무개");
        eventManagement.addToWaitingQueue("아무삼");
        eventManagement.addToWaitingQueue("아무자");
        eventManagement.addToWaitingQueue("아무하");

        System.out.println(eventManagement.participantList);    // [이재현, 이재이, 이재흐, 이재자, 이재하, 이재비]
        System.out.println(eventManagement.waitingQueue);       // [아무개, 아무삼, 아무자, 아무하]

        eventManagement.leaveParticipant("이재이");
        System.out.println(eventManagement.participantList);
        // [이재현, 이재이, 이재흐, 이재자, 이재하, 이재비, 아무개]

        eventManagement.leaveParticipant("이재비");
        System.out.println(eventManagement.participantList);
        // [이재현, 이재이, 이재흐, 이재자, 이재하, 이재비, 아무개, 아무삼]

        System.out.println(eventManagement.checkParticipant("이재현"));    // true
        System.out.println(eventManagement.checkParticipant("아무자"));    // false

        System.out.println(eventManagement.waitingQueue);   // [아무자, 아무하]

    }
}
