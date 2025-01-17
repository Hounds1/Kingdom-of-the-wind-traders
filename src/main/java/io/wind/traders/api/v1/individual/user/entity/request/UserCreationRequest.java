package io.wind.traders.api.v1.individual.user.entity.request;

import io.wind.traders.api.v1.individual.user.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCreationRequest {

    private String loginId;
    private String password;
    private String nickname;
}
