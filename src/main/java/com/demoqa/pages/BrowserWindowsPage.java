package com.demoqa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BrowserWindowsPage extends BasePage {

  public BrowserWindowsPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id = "windowButton")
  WebElement windowButton;

  public BrowserWindowsPage switchToNewWindow(int index) {
    click(windowButton);
    List<String> windows = new ArrayList<>(wd.getWindowHandles());
    wd.switchTo().window(windows.get(index));
    return this;
  }

  @FindBy(id = "sampleHeading")
  WebElement sampleHeading;

  public BrowserWindowsPage assertNewWindowMessage(String text) {
    Assert.assertTrue(shouldHaveText(sampleHeading, text, 15));
    return this;
  }

  @FindBy(id = "tabButton")
  WebElement tabButton;

  public BrowserWindowsPage switchToNewTab(int index) {
    click(tabButton);
    List<String> tabs = new ArrayList<>(wd.getWindowHandles()); //???
    wd.switchTo().window(tabs.get(index));
    return this;
  }

  @FindBy(id = "sampleHeading")
  WebElement sampleHeadingTab;

  public BrowserWindowsPage assertNewTabMessage(String text) {
    Assert.assertTrue(shouldHaveText(sampleHeadingTab, text, 15));
    return this;
  }
}
