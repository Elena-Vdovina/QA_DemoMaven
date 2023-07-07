package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(wd).getForms();
    new SidePanel(wd).selectPracticeForm().hideIframes();
  }

  @Test
  public void fillPracticeFormTest() {
    new PracticeFormPage(wd)
        .enterPersonalData("Ivan", "Ivanov", "ii@gmail.com", "1234567890")
        .selectGender("Male")
        //.typeData("07 July 2000")
        .selectDate("August", "2000", "14")
        .addSubject(new String[]{"Maths", "English", "Chemistry"})
        .selectHobby(new String[]{"Sports", "Reading", "Music"})
        .uploadFile("C:/Tools/logo192.png")
        .enterAddress("India")
        .selectState("NCR")
        .selectCity("Delhi")
        .submit();
  }

  @Test
  public void fillPracticeFormTestWithFinalData() {
    new PracticeFormPage(wd).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
            StudentData.EMAIL, StudentData.PHONE_NUMBER)
        .selectGender(StudentData.GENDER)
        .typeData(StudentData.B_DAY)
        .addSubject(StudentData.SUBJECTS)
        .selectHobby(StudentData.HOBBIES)
        .uploadFile(StudentData.PHOTO_PATH)
        .enterAddress(StudentData.ADDRESS)
        .selectState(StudentData.STATE)
        .selectCity(StudentData.CITY)
        .submit()
        .assertForm();
  }

}
