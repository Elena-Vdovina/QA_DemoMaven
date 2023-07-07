package com.demoqa.pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertsPage extends BasePage {


  public AlertsPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id = "promtButton")
  WebElement promtButton;

  public AlertsPage sendMessageToAlert(String message) {
    clickWithJSExecutor(promtButton, 0, 300);
    if (message != null) {
      wd.switchTo().alert().sendKeys(message);
      wd.switchTo().alert().accept();
    }
    return this;
  }

  @FindBy(id = "promptResult")
  WebElement promptResult;

  public AlertsPage assertMessage(String message) {
    Assert.assertTrue(promptResult.getText().contains((message)));
    return this;
  }

  @FindBy(id = "alertButton")
  WebElement firstAlertButton;

  public AlertsPage alertButton() {
    clickWithJSExecutor(firstAlertButton, 0, 300);
    return this;
  }

  @FindBy(id = "timerAlertButton")
  WebElement timerButton;

  public AlertsPage timerAlertButton() {
    clickWithJSExecutor(timerButton, 0, 300);
    return this;
  }

  @FindBy(id = "timerAlertButton")
  WebElement timerAlertButton;

  public AlertsPage acceptTimerAlert() {
    click(timerAlertButton);
    new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent())
        .accept();
    return this;
  }

  @FindBy(id = "confirmButton")
  WebElement confirmButton;

  public AlertsPage confirmAlertButton() {
    clickWithJSExecutor(confirmButton, 0, 300);
    wd.switchTo().alert().dismiss();
    return this;
  }

  @FindBy(id = "confirmResult")
  WebElement confirmResult;

  public AlertsPage assertOkMessage() {
    Assert.assertTrue(confirmResult.getText().contains("You selected Ok"));
    return this;
  }

  @FindBy(id = "confirmButton")
  WebElement confirmButton1;

  public AlertsPage selectAlertConfirm(String text) {
    clickWithJSExecutor(confirmButton1,0,100);
    if (text != null && text.equalsIgnoreCase("OK")) {
      wd.switchTo().alert().accept();
    } else if (text != null && text.equalsIgnoreCase("Cancel")) {
      wd.switchTo().alert().dismiss();
    }
    return this;
  }

  @FindBy(id = "confirmResult")
  WebElement confirmResult1;

  public AlertsPage assertConfirm(String message) {
    pause(1000);
    Assert.assertTrue(confirmResult1.getText().contains(message));
    return this;
  }
}
