package io.wind.traders.api.v1.individual.ban.entity.element;

import lombok.Getter;

@Getter
public enum BanReason {
    ILLEGAL_TRADING_DETECTION("부정 거래로 인한 정지", 7, 30, 90),
    FRAUDULENT_BEHAVIOR("사기 또는 기망 행위로 인한 정지", 7, 30, 90),
    COMMUNITY_MISCONDUCT("커뮤니티 내 부적절한 행위", 1, 3, 30),
    VERBAL_ABUSE("폭언 또는 욕설로 인한 제한", 1, 3, 30),
    DISRUPTIVE_BEHAVIOR("미풍양속 저해 행위", 1, 3, 30),
    OFFENSIVE_LANGUAGE("모욕적 언어 사용", 1, 3, 30),
    INAPPROPRIATE_CONDUCT("부적절한 커뮤니티 행위", 1, 3, 30);

    private final String reason;
    private final int fir;
    private final int sec;
    private final int thr;

    BanReason(String reason, int fir, int sec, int thr) {
        this.reason = reason;
        this.fir = fir;
        this.sec = sec;
        this.thr = thr;
    }

    public static int getCount(BanReason reason, int count) {
        if (count > 3) {
            return 99999;
        }

        if (count == 0) {
            return reason.getFir();
        }

        if (count == 1) {
            return reason.getSec();
        }

        return reason.getThr();
    }
}
