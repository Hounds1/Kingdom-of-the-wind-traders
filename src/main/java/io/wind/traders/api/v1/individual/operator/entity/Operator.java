package io.wind.traders.api.v1.individual.operator.entity;

import io.wind.traders.api.v1.individual.operator.entity.element.OperatorRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OPERATOR_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operatorId;

    @Column(nullable = false, name = "login_id")
    private String loginId;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "nickname")
    private String nickname;

    @Column(nullable = false, name = "role")
    private OperatorRole role;
}