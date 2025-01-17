package io.wind.traders.api.v1.individual.user.entity.response;

import io.wind.traders.api.v1.individual.ban.entity.BanRecord;
import io.wind.traders.api.v1.individual.user.entity.User;
import io.wind.traders.api.v1.individual.user.entity.element.UserRole;
import io.wind.traders.api.v1.individual.user.entity.element.UserStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserInfoResponse {

    private String loginId;
    private String nickname;
    private UserStatus status;
    private UserRole role;
    private List<BanRecord> banRecords;
    private LocalDateTime joinedAt;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordChangedAt;

    public static UserInfoResponse from(User user) {
        return UserInfoResponse.builder()
                .loginId(user.getLoginId())
                .nickname(user.getNickname())
                .status(user.getStatus())
                .role(user.getRole())
                .banRecords(user.getBanRecords())
                .joinedAt(user.getJoinedAt())
                .lastLoginAt(user.getLastLoginAt())
                .passwordChangedAt(user.getPasswordChangedAt())
                .build();
    }
}
