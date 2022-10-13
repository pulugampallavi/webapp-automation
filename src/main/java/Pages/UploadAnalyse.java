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
import java.nio.file.LinkOption;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class UploadAnalyse {
    WebDriver driver;
    private loginPage  LoginPage;

    //----------------------------------UPLOAD AND ANALYZE XPATHS--------------------------------------
    private By SelectPatient = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[6]");
    private By UploadAnalyzeButton = By.xpath("//*[@id=\"mat-tab-label-0-2\"]");
    private By BitewingRadioBtn = By.xpath("//*[@id=\"mat-radio-4\"]/label/span[1]");

    private By UploadImageBtn = By.xpath("//*[@id=\"undefined\"]");
    private By AnalyzeBtn = By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div/div[2]/div/button[2]");

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
    //----------------------------------Upload and Analyze Section Flow----------------------------------------

    public void uploadAndAnalyzeFlow() throws InterruptedException, IOException {
        driver.findElement(SelectPatient).click();
        Thread.sleep(3000);
        driver.findElement(UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(BitewingRadioBtn).click();
        Thread.sleep(4000);
        driver.findElement(UploadImageBtn).click();
        Thread.sleep(3000);
        driver.findElement(UploadImageBtn).sendKeys("R:/Velmeni/webapp-automation/resources/bitewing1.jpeg");
        driver.findElement(UploadImageBtn).submit();
        driver.findElement(AnalyzeBtn).click();
    }

    //----------------------------------Upload and Analyze Section Testcase----------------------------------------
    @Test(description = "Check Upload and Analyze flow")
    public void UploadAndAnalyze() throws InterruptedException, IOException {
        LoginPage.clickLogInButton();
        uploadAndAnalyzeFlow();
        LoginPage.clickLogOutButton();

    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
