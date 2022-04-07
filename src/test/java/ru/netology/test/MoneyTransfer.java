package ru.netology.test;

import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.netology.pages.DashBoardPage;
import ru.netology.pages.LoginPage;
import ru.netology.web.DataWizard;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransfer {

    public static void ups(){
        var loginPage = new LoginPage();
    }

    @BeforeAll
    public static DashBoardPage startUp(){
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataWizard.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataWizard.getVerificationCodeFor(authInfo);
        return verificationPage.validVerify(verificationCode);

    }

    @Test
    public void shouldTransferMoneyFromOneToTwo() {
        int transferAmount = 10000;
        int expected,actual;
        int card = 0;

        open("http://localhost:9999");
        var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataWizard.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataWizard.getVerificationCodeFor(authInfo);
        var  dashBoard = verificationPage.validVerify(verificationCode);

        expected = dashBoard.getCardBalance(card)+transferAmount;
        var cashTr = dashBoard.cardsTransferАFromFirst(DataWizard.getCardsInfo());
        var transferFinish = cashTr.transition(transferAmount);
        actual = transferFinish.getCardBalance(card);
        Assertions.assertEquals(expected,actual);
      //  dash.

    }

    @Test
    void shouldTransferMoneyFromTwoToOne() {
        int transferAmount = 10000;
        int expected,actual;
        int card = 1;

      //  open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataWizard.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataWizard.getVerificationCodeFor(authInfo);
        var  dashBoard = verificationPage.validVerify(verificationCode);

        expected = dashBoard.getCardBalance(card)+transferAmount;
        var cashTr = dashBoard.cardsTransferАFromSecond(DataWizard.getCardsInfo());
        var transferFinish = cashTr.transition(transferAmount);
        actual = transferFinish.getCardBalance(card);
        Assertions.assertEquals(expected,actual);
        //  dash.

    }

    @Test
    void shouldCheckBalance() {
        int transferAmount = 10000;
        int expected,actual;
        int card = 1;

        //  open("http://localhost:9999");
//        var loginPage = new LoginPage();
//        var authInfo = DataWizard.getAuthInfo();
//        var verificationPage = loginPage.validLogin(authInfo);
//        var verificationCode = DataWizard.getVerificationCodeFor(authInfo);
//        var  dashBoard = verificationPage.validVerify(verificationCode);
         DashBoardPage v = startUp();
        expected = v.getCardBalance(card)+transferAmount;
        var cashTr = dashBoard.cardsTransferАFromSecond(DataWizard.getCardsInfo());
        var transferFinish = cashTr.transition(transferAmount);
        actual = transferFinish.getCardBalance(card);
        Assertions.assertEquals(expected,actual);
        //  dash.
    }
}
