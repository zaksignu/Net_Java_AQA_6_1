package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

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

       inputSumm.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
       inputSumm.setValue(Integer.toString(money));

       cardNumbers.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
       cardNumbers.sendKeys(cardNumber);

       submitButton.click();
      return new DashBoardPage();
    }

}
