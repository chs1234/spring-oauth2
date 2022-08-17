package com.example.kakao_oauth.config.dto;

import com.example.kakao_oauth.domain.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 직렬화 기능을 가진 User클래스
 * User클래스를 그대로 사용하면 직렬화를 구현하지 않았기 때문에 에러가 발생.
 * User클래스에 직렬화 하지 않는 이뉴는 다른 엔티티와도 연관관계가 생길 수 있는 엔티티이기 때문에
 * 성능이슈, 부수효과가 발생할 확률이 높기 때문.
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getUsername();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
