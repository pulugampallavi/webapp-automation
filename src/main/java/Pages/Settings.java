package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class Settings {
    WebDriver driver;
    private loginPage  LoginPage;

    //---------------------------SETTINGS SECTION XPATH-------------------------------------------
    private By settingsIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/a");
    private By UserNameField = By.xpath("//*[@id=\"mat-input-2\"]");
    private By CurrentPassword = By.xpath("//*[@id=\"mat-input-3\"]");
    private By NewPasswordField = By.xpath("//*[@id=\"mat-input-4\"]");
    private By ConfirmPasswordField = By.xpath("//*[@id=\"mat-input-5\"]");
    private By ShowPassword = By.xpath("/html/body/app-root/app-main-layout/app-settings/section/div/mat-tab-group/div/mat-tab-body/div/div/div/div/form/mat-form-field[3]/div/div[1]/div[2]/a");


    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
    }
    //----------------------------------SETTINGS SECTION FLOW----------------------------------------

    public void SettingsSection() throws InterruptedException {
        driver.findElement(settingsIcon).click();
        WebElement userField = driver.findElement(UserNameField);
        //String val = userField.getAttribute("value");
        String val = userField.getText();
        System.out.println("Entered text is: " + val);

        WebElement passField = driver.findElement(CurrentPassword);
        passField.sendKeys("Test@12345");
        String value = passField.getText();

        driver.findElement(NewPasswordField).click();
        Thread.sleep(4000);
        WebElement newele =  driver.findElement(NewPasswordField);
        newele.sendKeys("Test@123456");
        Thread.sleep(4000);
        driver.findElement(ShowPassword).click();

        driver.findElement(ConfirmPasswordField).click();
        Thread.sleep(4000);
        driver.findElement(ConfirmPasswordField).click();
        WebElement newele2 =  driver.findElement(ConfirmPasswordField);
        newele2.sendKeys("Test@123456");
    }


    //----------------------------------SETTINGS SECTION FLOW----------------------------------------

    @Test(description = "Check settings flow")
    public void settingsFlow() throws InterruptedException {
        LoginPage.clickLogInButton();
        SettingsSection();
        LoginPage.clickLogOutButton();
    }

}
