package chapter16;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*      === DTO, VO, DAO, Entity ===
          데이터를 목적에 따라 정의하는 구조

          - DTO(Data Transfer Object): 데이터를 전달하기 위한 객체
          - VO(Value Object): 값 자체를 표현하는 객체
          - DAO(Data Access Object): DB 에 접근하는 역할을 하는 객체
          - Entity: 실제 DB 테이블과 매핑되는 클래스

          1) DTO(Data Transfer Object)
            - 계층 간 데이터 교환을 위해 사용하는 객체
            - 로직을 가지지 않는 순수한 데이터 객체 (Get & set 만 가진 클래스)
            - DB 에서 데이터를 가져오거나 REST API 통신에서
            - 요청 및 응답 데이터를 담아 전달할 때 사용

// 사용자의 아이디와 비밀번호만을 가진 로그인 요청 정보를 가진 DTO
*/
class UserSignInRequestDto {
    private String userId;
    private String password;
}

/*        2) VO(Value Object)
            값을 표현하는 객체
            - 데이터를 담는 용도, 불변성을 가짐(한 번 생성되면 내용 변경 불가!)
            - 필드값을 final 설정
            - Getter 만을 가짐
*/
@AllArgsConstructor
@Getter
class Address {
    private final String city;
    private final String zipCode;
}

/*        3) DAO(Data Access Object)
            DB 또는 저장 매체의 데이터에 접근하는 객체
            - 서비스 모델과 DB를 연결하는 역할
            - 데이터의 CRUD 작업을 시행하는 클래스
            - 비즈니스 로직에서 DB의 직접적인 조작 없이 데이터를 다룰 수 있게 함

            Ex) 사용자의 ID에 일치하는 데이터를 응답
                사용자 로그인 후 아이디, 닉네임 등을 포함하여 응답

*/
@AllArgsConstructor
class UserSignInResponseDto {
    private String userId;
    private String nickname;
}

// 사용자 DB와 연관된 작업을 모두 명시
class UserDao {
    public UserSignInResponseDto getUserById(String userId) {

//      DB 에서 userId 에 해당하는 사용자 정보를 조회
        String id = "qwe";
        String nickname = "아무개";

        return new UserSignInResponseDto(id, nickname);
    }
}

/*          4) Entity(실제)
              DB 의 테이블에 해당하는 데이터의 구조와 거의 일치하는 클래스
              - JPA(Java Persistence API) 와 같은 ORM(Object Related Mapping) 툴에서 사용
              - DB 의 테이블의 레코드와 매핑, 데이터와 관련된 비즈니스 로직을 포함
*/
class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private String nickname;
}

public class F_Entity {
    public static void main(String[] args) {

    }
}
