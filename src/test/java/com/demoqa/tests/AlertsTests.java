package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(wd).getAlertsFrameWindows();
    new SidePanel(wd).selectAlerts();
  }

  @Test
  public void sendMessageToAlertTest() {
    new AlertsPage(wd).sendMessageToAlert("Hello word!").assertMessage("Hello word!");
  }

  @Test
  public void alertButtonTest() {
    new AlertsPage(wd).alertButton();
  }

  @Test  // 1 variant
  public void timeAlertButtonTest() {
    new AlertsPage(wd).timerAlertButton();
  }

  @Test  // 2 variant
  public void waitOfAlertTest(){
    new AlertsPage(wd).acceptTimerAlert();
  }

  @Test // 1 variant
  public void confirmAlertButtonOkTest() {
    new AlertsPage(wd).confirmAlertButton().assertOkMessage();
  }

  @Test
  public void confirmAlertTest(){
    new AlertsPage(wd).selectAlertConfirm("Cancel").assertConfirm("You selected Cancel");
  }
}
