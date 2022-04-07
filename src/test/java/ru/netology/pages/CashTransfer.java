package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CashTransfer {
    private String cardNumber;
    private SelenideElement cardNumbers = $("[data-test-id=\"from\"] .input__control");
    private SelenideElement inputSumm  =$("[data-test-id=\"amount\"] .input__control");
    private SelenideElement submitButton  =$("[data-test-id=\"action-transfer\"]");


   public CashTransfer(String card){
        this.cardNumber = card;
    }



   public DashBoardPage transition (int money){
       inputSumm.setValue(Integer.toString(money));
       //cardNumbers.click();
    //   cardNumbers.setValue(cardNumber.toString());
       cardNumbers.sendKeys(cardNumber);
       submitButton.click();
      return new DashBoardPage();
    }

}
