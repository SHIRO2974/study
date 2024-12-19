package chapter08;

/*      추상 클래스
        모바일 앱
*/
abstract class MobileApp {
    // 추상화 메서드
    // 실행에 대한 동작 정의
    // "반드시" 각 앱 마다 "고유한 실행" 정의
   abstract void execute();

    // 일반 메서드
    void appInfo() {

        System.out.println("This is a mobile app");
    }
}

//
class GameApp extends MobileApp {
    // 추상 메서드 구현
    void execute() {

        System.out.println("Game app executes");
    }
}

class SocialApp extends MobileApp {
    String  name;

    SocialApp(String name) {
        this.name = name;

    }

    void execute() {
        System.out.println(name + "app executes");
    }

    void appInfo() {
        System.out.println(name + "app is most popular social app");
    }

    void sharerContent(String content) {
        System.out.println(name + "shares : " + content);
    }
}
public class Practice01 {
    public static void main(String[] args) {
        // == 다형성 적용 ==
            MobileApp gameApp = new GameApp();
            MobileApp socialApp = new SocialApp("instagram");

        // 다형성
        gameApp.execute();  // Game app executes
        gameApp.appInfo();  // This is a mobile app

        socialApp.execute();    // instagram app executes
        socialApp.appInfo();    // instagram app is most popular social app

//        socialApp.sharerContent("images");

        // 형 변환 (Type Casting)
        if (socialApp instanceof GameApp) {

            System.out.println("socialApp 은 GameApp 입니다.");
            GameApp onlyGameApp = (GameApp) socialApp;

        } else if (socialApp instanceof SocialApp) {

            System.out.println("socialApp 은 socialApp 입니다.");
            SocialApp onlySocialApp = (SocialApp) socialApp;
            onlySocialApp.sharerContent("images");  // 고유 메서드 사용 가능
          // instagram shares : images
        }

/*          === 객체 배열과 다형성 활용 ===
            배열 선언 & 초기화: 데이터타입[] 변수명 = {요소1, 요소2, }
*/
        MobileApp[] apps = {
                // 생성과 동시에 업캐스팅 - 묵시적 형 변환
                new GameApp(),
                new SocialApp("Facebook"),
                new SocialApp(" X ")
        };
        for (MobileApp app : apps) {

            app.appInfo();
            app.execute();

            // SocialApp
            if (app instanceof SocialApp) {

                SocialApp specificSocialApp = (SocialApp) app;
                specificSocialApp.sharerContent("Files");   //  X shares : Files
            }
        }
    }

}
