package Tests;
import Constants.SecondDentistXpaths;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class UploadAndAnalyse extends BaseTest{
    WebDriver driver;
    SecondDentistUtils sdUtils;
    SecondDentistXpaths sdXpaths;
    //----------------------------------BEFORE CLASS--------------------------------------
    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sdUtils= new SecondDentistUtils();
        sdXpaths = new SecondDentistXpaths();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(BaseTest.url);
        sdUtils.clickLogInButton(driver);
        Assert.assertTrue(driver.getCurrentUrl().endsWith("seconddentist.ai/#/doctor/all-patients"), "Login unsuccessfull.");
        driver.navigate().refresh();
    }
    //----------------------------------Upload and Analyze Section Testcase----------------------------------------
    @Test(description = "Check Upload and Analyze flow")
    public void UploadAndAnalyze() throws InterruptedException, IOException {
        sdUtils.uploadAndAnalyzeFlow(driver);
    }
    @Test(description = "Check U&A flow for periapical image")
    public void periapicalImage() throws InterruptedException {
        driver.findElement(sdXpaths.PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(3000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalRadioBtn).click();
        Thread.sleep(4000);
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys("R:/Velmeni_Automation/resources/periapical1.png");
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn).click();
        driver.findElement(sdXpaths.Analyze2).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.Accept2).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.DownloadReportBtn).click();
    }
    //-----------------------------------AFTER CLASS--------------------------------
    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }
}
