package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.pages.CardsAndTransfers;
import ru.netology.pages.CashTransfer;
import ru.netology.pages.DashBoardPage;
import ru.netology.pages.LoginPage;
import ru.netology.web.DataWizard;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransfer {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {

        open("http://localhost:9999");
        var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataWizard.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataWizard.getVerificationCodeFor(authInfo);

        var  dashBoard = verificationPage.validVerify(verificationCode);
        dashBoard.getCardBalance(1);
        var cashTr = dashBoard.cardsTransferАFromFirst(DataWizard.getCardsInfo());
        var dash = cashTr.transition("10000");

    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {

        open("http://localhost:9999");
        var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataWizard.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataWizard.getVerificationCodeFor(authInfo);

        var  dashBoard = verificationPage.validVerify(verificationCode);
        var cashTr = dashBoard.cardsTransferАFromSecond(DataWizard.getCardsInfo());
        var dash = cashTr.transition("10000");

    }
}
