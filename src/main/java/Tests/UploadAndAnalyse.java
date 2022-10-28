package Tests;
import Constants.SecondDentistXpaths;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
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
        driver.findElement(sdXpaths.Accept2).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.DownloadReportBtn).click();
    }
    @Test(description = "Upload and analyze Regression flow")
    public void UandARegession() throws InterruptedException {
        driver.navigate().refresh();
        driver.findElement(sdXpaths.PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(3000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys("R:/Velmeni_Automation/resources/periapical1.png");
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElement(sdXpaths.BrightnessSlider).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(sdXpaths.ContrastSlider).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(sdXpaths.magnifierIcon).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(sdXpaths.AntiClockwiseRotate).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(sdXpaths.ClockwiseRotate).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(sdXpaths.InvertImage).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(sdXpaths.RefreshBtn).isDisplayed());
        driver.findElement(sdXpaths.FindingsIcon).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("Supported Findings"));
        driver.findElement(sdXpaths.CLoseFindingPopup).click();
        Assert.assertTrue(driver.findElement(sdXpaths.HideFindings).isDisplayed());
        Assert.assertTrue(driver.findElement(sdXpaths.RefreshSmlBtn).isDisplayed());
        Assert.assertTrue(driver.findElement(sdXpaths.PrintBtn).isDisplayed());
        driver.findElement(sdXpaths.UploadImageSmlBtn).click();
        Thread.sleep(5000);
        //driver.navigate().refresh();
        Assert.assertTrue(driver.getPageSource().contains("Select Image Type:"));
    }
    @Test(description = "Teeth Numbering Flow")
    public void TeethNumbering() throws InterruptedException {
        driver.navigate().refresh();
        driver.findElement(sdXpaths.PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(3000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys("R:/Velmeni_Automation/resources/periapical1.png");
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(4000);

        String T1 = driver.findElement(By.xpath("//div//child::div[text()='31']")).getText();
        String T2 = driver.findElement(By.xpath("//div//child::div[text()='30']")).getText();
        String T3 = driver.findElement(By.xpath("//div//child::div[text()='29']")).getText();
        String T4 = driver.findElement(By.xpath("//div//child::div[text()='28']")).getText();
        Reporter.log("Teeth numbers are : "+T1+","+T2+","+T3+","+T4);
        String TN1 = driver.findElement(By.xpath("//select//child::option[text()='UNIVERSAL']")).getText();
        if (TN1=="UNIVERSAL"){
            Reporter.log("Teeth numbers are : "+T1+","+T2+","+T3+","+T4);
        }
        else {
            Reporter.log("Teeth Number Format is In ISO");
        }
    }
    //-----------------------------------AFTER CLASS--------------------------------
    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }
}
