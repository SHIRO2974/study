package chapter14.Practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    public static User signUp(UserSignUpRequestDto dto) {
        String password = dto.getPassword();
        String passwordCheck = dto.getPasswordCheck();

        if (!password.equals(passwordCheck)) {
            throw  new Error("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        long id = 1L;
        Date nowData = new Date();

        User user = User.builder()
                .id(id)
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .userName(dto.getUserName())
                .nickname(dto.getNickname())
                .phone(dto.getPhone())
                .signUpDate(nowData)
                .build();

        return user;
    }
    public static void main(String[] args) {
        UserSignUpRequestDto dto1 = new UserSignUpRequestDto("123", "12321", "12321"
                , "아무개", "wqewq", "0321432104", "개");

        User user1 = signUp(dto1);
        System.out.println(user1.getSignUpDate());  // Thu Dec 12 12:06:28 KST 2024

        List<User> userList = null;
        List<UserSignUpRequestDto> dtos = new ArrayList<>();
        dtos.add(new UserSignUpRequestDto("123", "12321", "12321"
                , "아무개", "wqewq", "0321432104", "개"));
        dtos.add(new UserSignUpRequestDto("123", "12321", "12321"
                , "아무배", "wqewq", "0321432104", "개"));
        dtos.add(new UserSignUpRequestDto("123", "12321", "12321"
                , "아무새", "wqewq", "0321432104", "개"));

        userList = dtos.stream()
                .map(dto -> signUp(dto))
                .collect(Collectors.toList());

        userList = dtos.stream()
                .map(UserService::signUp)
                .collect(Collectors.toList());

        userList.forEach(System.out::println);
/*      chapter14.Practice.User@1cd072a9
        chapter14.Practice.User@7c75222b
        chapter14.Practice.User@4c203ea1
*/

    }
}
