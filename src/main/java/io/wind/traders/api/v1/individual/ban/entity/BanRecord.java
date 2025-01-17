package io.wind.traders.api.v1.individual.ban.entity;

import io.wind.traders.api.v1.individual.ban.entity.element.BanReason;
import io.wind.traders.api.v1.individual.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BAN_RECORD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class BanRecord {

    @Id
    @Column(name = "ban_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long banId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "reason")
    @Enumerated(EnumType.STRING)
    private BanReason reason;

    @Column(name = "banned_at", updatable = false, nullable = false)
    private LocalDateTime bannedAt;

    @Column(name = "unbanned_at", nullable = false)
    private LocalDateTime unbannedAt;


}
