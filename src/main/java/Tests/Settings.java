package Tests;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class Settings {
    WebDriver driver;
    SecondDentistUtils sdUtils;

    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sdUtils= new SecondDentistUtils();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
    }


    //----------------------------------SETTINGS SECTION FLOW----------------------------------------

    @Test(description = "Check settings flow")
    public void settingsFlow() throws InterruptedException {
        sdUtils.clickLogInButton(driver);
        sdUtils.SettingsSection(driver);
        sdUtils.clickLogOutButton(driver);
    }
    @Test(description = "Check negative settings flow")
    public void settingsFlow2() throws InterruptedException {
        sdUtils.clickLogInButton(driver);
        sdUtils.SettingsSection2(driver);
        sdUtils.clickLogOutButton(driver);
    }
    @Test(description = "Check negative settings flow")
    public void settingsFlow3() throws InterruptedException {
        sdUtils.clickLogInButton(driver);
        sdUtils.SettingsSection3(driver);
        sdUtils.clickLogOutButton(driver);
    }
    @Test(description = "Check negative settings flow")
    public void settingsFlow4() throws InterruptedException {
        sdUtils.clickLogInButton(driver);
        sdUtils.SettingsSection4(driver);
        sdUtils.clickLogOutButton(driver);
    }
    @Test(description = "Check negative settings flow")
    public void settingsFlow5() throws InterruptedException {
        sdUtils.clickLogInButton(driver);
        sdUtils.SettingsSection5(driver);
        sdUtils.clickLogOutButton(driver);
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
