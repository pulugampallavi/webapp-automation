package Utils;

import Constants.SecondDentistXpaths;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SecondDentistUtils extends SecondDentistXpaths {

    //----------------------------------LOGIN LOGOUT FLOW--------------------------------------
    public void clickLogInButton(WebDriver driver) {
        driver.findElement(usernameXpath).clear();
        driver.findElement(usernameXpath).sendKeys(BaseTest.username);

        driver.findElement(PasswordXpath).clear();
        driver.findElement(PasswordXpath).sendKeys(BaseTest.password);

        driver.findElement(SignIn).click();
    }
    public void clickLogOutButton(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(SignOut).click();
    }

    //----------------------------------ADD PATIENTS FLOW--------------------------------------
    public void addPatientFlow(WebDriver driver) throws InterruptedException {
        driver.findElement(PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(AddPatientBtn).click();
        Actions element1 = new Actions(driver);
        WebElement fname = driver.findElement(AddPatFirstName);
        element1.doubleClick(fname).perform();
        Thread.sleep(4000);
        Actions newaction = new Actions(driver);
        newaction.sendKeys("Cinder").build().perform();
        driver.findElement(AddPatLastName).click();
        Thread.sleep(4000);
        Actions newaction2 = new Actions(driver);
        newaction2.sendKeys("ella").build().perform();
        driver.findElement(AddPatDOB).click();
        Thread.sleep(2000);
        driver.findElement(AddPAtSelectDate).click();
        driver.findElement(AddPatGender).click();
        driver.findElement(SaveBtn).click();
    }

    public void addPatientbtn(WebDriver driver){
        Assert.assertTrue(driver.findElement(AddPatientBtn).isEnabled(), "Save btn not disabled");


    }
    //----------------------------------CHATBOT FLOW--------------------------------------
    public void ChatbotFlow(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('minimized')[0].click();");
        Thread.sleep(5000);
        WebElement element2 = driver.findElement(ChatBotValidation);
        if (element2.isDisplayed()){
            System.out.println("ChatBot Popup opened");
        }
        else {
            System.out.println("ChatBot popup did not open");
        }
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[0].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[1].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[2].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[3].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[4].click();");
        driver.findElement(ChatBotCloseBtn).click();
    }
    //----------------------------------Upload and Analyze Section Flow----------------------------------------

    public void uploadAndAnalyzeFlow(WebDriver driver) throws InterruptedException, IOException {
        driver.findElement(SelectPatient).click();
        Thread.sleep(3000);
        driver.findElement(UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(BitewingRadioBtn).click();
        Thread.sleep(4000);
        driver.findElement(UploadImageBtn).sendKeys("R:/Velmeni/Proofs & Files/bitewingimage/200-4.1.jpeg");
        driver.findElement(UploadImageBtn).submit();
        driver.findElement(ProceedBtn).click();
        driver.findElement(AnalyzeBtnPopup).click();
        Thread.sleep(2000);
        driver.findElement(AcceptBtn).click();
        Thread.sleep(2000);
        driver.findElement(SaveFindingsBtn).click();
        Thread.sleep(2000);
        driver.findElement(DownloadReportBtn).click();
    }
    //----------------------------------SUPPORT FLOW----------------------------------------
    public void supportSection(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(SupportIcon).click();
        boolean supMailVld = driver.getPageSource().contains("hello@velmeni.ai");
        if (supMailVld == true) {
            System.out.println("Support Mail ID is visible");
        }
        driver.findElement(UserManual).click();
        String parent = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> I1 = allWindowHandles.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
            }
        }
        Thread.sleep(3000);
        driver.switchTo().window(parent);
    }
    //----------------------------------SETTINGS SECTION FLOW----------------------------------------
    public void SettingsSection(WebDriver driver) throws InterruptedException {
        driver.findElement(settingsIcon).click();
        WebElement userField = driver.findElement(UserNameField);
        //String val = userField.getAttribute("value");
        String val = userField.getText();
        System.out.println("Entered text is: " + val);

        WebElement passField = driver.findElement(CurrentPassword);
        passField.sendKeys("Test@12345");
        String value = passField.getText();

        driver.findElement(NewPasswordField).click();
        Thread.sleep(2000);
        WebElement newele =  driver.findElement(NewPasswordField);
        newele.sendKeys("Test@123456");
        Thread.sleep(2000);
        driver.findElement(ShowPassword).click();

        driver.findElement(ConfirmPasswordField).click();
        Thread.sleep(2000);
        driver.findElement(ConfirmPasswordField).click();
        WebElement newele2 =  driver.findElement(ConfirmPasswordField);
        newele2.sendKeys("Test@123456");
    }

    public void SettingsSection2(WebDriver driver) throws InterruptedException {
        driver.findElement(settingsIcon).click();
        WebElement userField = driver.findElement(UserNameField);
        String val = userField.getText();
        //System.out.println("Entered text is: " + val);

        driver.findElement(NewPasswordField).click();
        Thread.sleep(2000);
        WebElement newele =  driver.findElement(NewPasswordField);
        newele.sendKeys("Test@123456");
        Thread.sleep(2000);
        driver.findElement(ShowPassword).click();

        driver.findElement(ConfirmPasswordField).click();
        Thread.sleep(2000);
        driver.findElement(ConfirmPasswordField).click();
        WebElement newele2 =  driver.findElement(ConfirmPasswordField);
        newele2.sendKeys("Test@123456");
//        boolean vld = driver.findElement(SaveBtnSettings).isDisplayed();
//        if (vld == false){System.out.println("Save btn disabled");}
        Assert.assertFalse(driver.findElement(SaveBtnSettings).isEnabled(), "Save btn disabled");
    }
    public void SettingsSection3(WebDriver driver) throws InterruptedException {
        driver.findElement(settingsIcon).click();
        WebElement userField = driver.findElement(UserNameField);
        String val = userField.getText();
        //System.out.println("Entered text is: " + val);

        WebElement passField = driver.findElement(CurrentPassword);
        passField.sendKeys("Test@12345");
        String value = passField.getText();

        driver.findElement(ConfirmPasswordField).click();
        Thread.sleep(2000);
        driver.findElement(ConfirmPasswordField).click();
        WebElement newele2 =  driver.findElement(ConfirmPasswordField);
        newele2.sendKeys("Test@123456");
//        boolean vld = driver.findElement(SaveBtnSettings).isDisplayed();
//        if (vld == false){System.out.println("Save btn disabled");}
        Assert.assertFalse(driver.findElement(SaveBtnSettings).isEnabled(), "Save btn disabled");
    }
    public void SettingsSection4(WebDriver driver) throws InterruptedException {
        driver.findElement(settingsIcon).click();
        WebElement userField = driver.findElement(UserNameField);
        String val = userField.getText();
        //System.out.println("Entered text is: " + val);

        WebElement passField = driver.findElement(CurrentPassword);
        passField.sendKeys("Test@12345");
        String value = passField.getText();

        Assert.assertFalse(driver.findElement(SaveBtnSettings).isEnabled(), "Save btn disabled");
    }
    public void SettingsSection5(WebDriver driver) throws InterruptedException {
        driver.findElement(settingsIcon).click();
        WebElement userField = driver.findElement(UserNameField);
        String val = userField.getText();
        //System.out.println("Entered text is: " + val);

        WebElement passField = driver.findElement(CurrentPassword);
        passField.sendKeys("Test@12345");
        String value = passField.getText();

        driver.findElement(NewPasswordField).click();
        Thread.sleep(2000);
        WebElement newele =  driver.findElement(NewPasswordField);
        newele.sendKeys("Test@123456");
        Thread.sleep(2000);
        driver.findElement(ShowPassword).click();

        Assert.assertFalse(driver.findElement(SaveBtnSettings).isEnabled(), "Save btn disabled");
    }
    //----------------------------------SEARCH PATIENT FLOW----------------------------------------
    public void searchPatient(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(FullScreenBtn).click();
        driver.findElement(SearchButton).click();
        driver.findElement(SearchButton).sendKeys("Bitewing");
        driver.findElement(By.xpath("//div/mat-table/mat-row[@class='mat-row cdk-row ng-star-inserted']")).click();
        Thread.sleep(4000);
        boolean vld = driver.getPageSource().contains(" Bitewing Cases");
        if (vld == true) {
            System.out.println("Redirected to correct user");
        }
    }

    public void searchPatient2(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(FullScreenBtn).click();
        driver.findElement(SearchButton).click();
        driver.findElement(SearchButton).sendKeys("Znto");
        boolean vld = driver.getPageSource().contains("No results");
        if (vld == true) {
            System.out.println("Results not visible");
        }
    }
    //----------------------------------PATIENT VISITS FLOW----------------------------------------
    public void patientVisitsflow(WebDriver driver){
        boolean vld = driver.findElement(PVHeader).isDisplayed();
        if (vld == true){
            System.out.println("On Patient Visits Page");
        }
        driver.findElement(SelectPatient2).click();
        driver.findElement(ImageIconSmall).click();
        driver.findElement(PatientVisitsSection).click();
        driver.findElement(ReportIconSmall).click();
    }
}
