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

    static int transferAmount = 10000;
    static int cardOne = 0;
    static int cardTwo = 1;

    @BeforeAll
    public static void startUp() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataWizard.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataWizard.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    public void shouldTransferMoneyFromTwoToOne() {

        var dashBoard = new DashBoardPage();

        int expectedOne = dashBoard.getCardBalance(cardOne) + transferAmount;
        int expectedTwo = dashBoard.getCardBalance(cardTwo) - transferAmount;

        var cashTr = dashBoard.cardsTransferFromFirst();
        var transferFinish = cashTr.transition(transferAmount);


        int actualOne = transferFinish.getCardBalance(cardOne);
        int actualTwo = transferFinish.getCardBalance(cardTwo);

        Assertions.assertEquals(expectedOne, actualOne);
        Assertions.assertEquals(expectedTwo, actualTwo);
    }

    @Test
    void shouldTransferMoneyFromOneToTwo() {

        var dashBoard = new DashBoardPage();
        int bal1 = dashBoard.getCardBalance(cardOne);
        int bal2 = dashBoard.getCardBalance(cardTwo);

        int expectedOne = dashBoard.getCardBalance(cardOne) - transferAmount;
        int expectedTwo = dashBoard.getCardBalance(cardTwo) + transferAmount;

        var cashTr = dashBoard.cardsTransferFromSecond();
        var transferFinish = cashTr.transition(transferAmount);

        int actualOne = transferFinish.getCardBalance(cardOne);
        int actualTwo = transferFinish.getCardBalance(cardTwo);

        Assertions.assertEquals(expectedOne, actualOne);
        Assertions.assertEquals(expectedTwo, actualTwo);


    }

}
