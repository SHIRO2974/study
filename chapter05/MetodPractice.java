package chapter05;

class BaseballPlayer {
/*     === 인스턴스 변수 ===
       선수 이름(name -  문자열)
       타율(battingAverage - 실수)
       홈런 수(homeRuns - 정수)
*/
    String name;
    double battingAverage;
    int homeRuns;

    // === 정적(클래스) 변수 ===
    // : 생성된 선수의 총 인원(playerCount - 정수)
    // >> 모든 인스턴스에서 공유
    static int playerCount;


    // 생성자 초기화
    // >> 인스턴스 변수 초기화 & 정적 변수 후위 증가(변수명++)
    BaseballPlayer(String name, double battingAverage, int homeRuns){
        this.name = name;
        this.battingAverage = battingAverage;
        this.homeRuns = homeRuns;

        playerCount++; // 플레이어 생성시 전체 수 증가

    }

    void updetesStatusd(double newBattingAverage, int newHomeRuns) {

        battingAverage = newBattingAverage;
        homeRuns = newHomeRuns;

    }
//        === static 메서드 ===
//          특정 홈런수 이상인 선수

    static String evaluateHomeRun(int homeRunsCpunt) {

        if (homeRunsCpunt >= 20){
            return "홈런상 후보에 등록됩니다.";

        }else {
            return "홈런상 후보에 들어갈 수 없습니다.";
        }
    }

    }








public class MetodPractice {
    public static void main(String[] args) {

        // 인스턴스 생성
        BaseballPlayer player1 = new BaseballPlayer("이재현", 0.325, 25);
        BaseballPlayer player2 = new BaseballPlayer("이민우", 0.293, 7);
        BaseballPlayer player3 = new BaseballPlayer("권민창", 0.301, 11);
        BaseballPlayer player4 = new BaseballPlayer("배수빈", 0.274, 9);

        System.out.println("총 생성된 선수의 수: " + BaseballPlayer.playerCount);   // 4

        player1.updetesStatusd(0.316, 18);
        System.out.println(player1.battingAverage); // 0.316
        System.out.println(player1.homeRuns);   // 18

        System.out.println(BaseballPlayer.evaluateHomeRun(21));
        System.out.println(BaseballPlayer.evaluateHomeRun(19));


    }
}