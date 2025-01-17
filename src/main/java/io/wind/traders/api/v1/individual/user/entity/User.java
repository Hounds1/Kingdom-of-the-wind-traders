package io.wind.traders.api.v1.individual.user.entity;

import io.wind.traders.api.v1.individual.ban.entity.BanRecord;
import io.wind.traders.api.v1.individual.user.entity.element.UserRole;
import io.wind.traders.api.v1.individual.user.entity.element.UserStatus;
import io.wind.traders.api.v1.individual.user.entity.request.UserCreationRequest;
import io.wind.traders.api.v1.individual.user.exception.IllegalUserMetaException;
import io.wind.traders.core.global.exception.element.GlobalExceptionType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_INFO", indexes = {
        @Index(name = "idx_login_id", columnList = "login_id"),
        @Index(name = "idx_nickname", columnList = "nickname")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class User {

    @Id
    @Column(nullable = false, name = "user_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, updatable = false, name = "login_Id", length = 50)
    private String loginId;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(name = "password_changed_at")
    private LocalDateTime passwordChangedAt;

    @Column(nullable = false, length = 12, name = "nickname")
    private String nickname;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    @Column(nullable = false, name = "role")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserRole role = UserRole.NORMAL;

    @OneToMany
    @Builder.Default
    private List<BanRecord> banRecords = new ArrayList<>();

    @Column(nullable = false, updatable = false, name = "joined_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Builder.Default
    private LocalDateTime joinedAt = LocalDateTime.now();

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    public void setEncryptedPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    public static User exchangeWithCreation(UserCreationRequest request) {
        validateCreationRequest(request);

        return User.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build();
    }

    private static void validateCreationRequest(UserCreationRequest request) {
        if (request == null) {
            throw new IllegalUserMetaException(GlobalExceptionType.USER_CREATION_REQUEST_NOT_FOUND);
        }
        if (request.getLoginId() == null || request.getLoginId().isEmpty()) {
            throw new IllegalUserMetaException(GlobalExceptionType.EMPTY_LOGIN_ID_FIELD);
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new IllegalUserMetaException(GlobalExceptionType.EMPTY_PASSWORD_FIELD);
        }
        if (request.getNickname() == null || request.getNickname().isEmpty()) {
            throw new IllegalUserMetaException(GlobalExceptionType.EMPTY_NICKNAME_FIELD);
        }
    }
}
