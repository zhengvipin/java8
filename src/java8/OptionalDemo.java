package java8;

import java.util.Optional;

public class OptionalDemo {

    // 需求：从user中获取username
    // before java 8
    public static String getName1(User user) {
        if (user == null){
            return "无名氏";
        }
        return user.getUsername();
    }
    // java 8 way
    public static String getName2(User user) {
        return Optional.ofNullable(user).map(User::getUsername).orElse("无名氏");
    }
}

class User{
    private String username;

    String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

