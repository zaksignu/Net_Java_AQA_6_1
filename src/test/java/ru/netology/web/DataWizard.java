package ru.netology.web;


import lombok.Value;

public class DataWizard {
    public DataWizard() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class Cards {
        private String firstCard;
        private String secondCard;

    }

    public static Cards getCardsInfo() {

        return new Cards("5559000000000001", "5559000000000002");
    }

}




