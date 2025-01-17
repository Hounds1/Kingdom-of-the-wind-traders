package io.wind.traders.api.v1.individual.user.entity.element;

import lombok.Getter;

@Getter
public enum UserStatus {

    ACTIVE,
    INACTIVE,
    HARD_BANNED,
    TRADING_BANNED_ONLY,
    COMMUNITY_BANNED_ONLY;
}
