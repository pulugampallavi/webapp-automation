package Pages;
import Constants.SecondDentistXpaths;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class UploadAndAnalyse extends BaseTest{
    WebDriver driver;
    SecondDentistUtils sdUtils;
    SecondDentistXpaths sdXpaths;
    //----------------------------------BEFORE CLASS--------------------------------------
    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
        sdUtils= new SecondDentistUtils();
        sdXpaths = new SecondDentistXpaths();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(BaseTest.url);
        Thread.sleep(2000);
        sdUtils.clickLogInButton(driver);
        Assert.assertTrue(driver.getCurrentUrl().endsWith("seconddentist.ai/#/doctor/all-patients"), "Login unsuccessfull.");
    }
    //----------------------------------Upload and Analyze Section Testcase----------------------------------------
    @Test(description = "Check U&A flow for bitewing image", priority = 1)
    public void uploadAndAnalyze() throws InterruptedException, IOException {
        sdUtils.bitewingImage(driver);
    }
    @Test(description = "Check U&A flow for periapical image",priority = 2)
    public void periapicalImage() throws InterruptedException {
        driver.navigate().refresh();
        //driver.findElement(sdXpaths.PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalRadioBtn).click();
        Thread.sleep(4000);
        String filePath1 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath1);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(5000);
        Thread.sleep(3000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
      //  driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.DownloadReportBtn).click();
    }
    @Test(description = "Upload and analyze Regression flow",priority = 3)
    public void uAndARegession() throws InterruptedException {
        driver.navigate().refresh();
        //driver.findElement(sdXpaths.PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        String filePath2 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath2);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElement(sdXpaths.BrightnessSlider).isDisplayed());
        Thread.sleep(10000);
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
        Assert.assertTrue(driver.getPageSource().contains("Select Image Type:"));
    }
    @Test(description = "Teeth Numbering Flow",priority = 4)
    public void teethNumbering() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(7000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        String filePath3 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath3);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(4000);
        WebElement testDropDown = driver.findElement(By.xpath("//option[@value='UNIVERSAL']//parent::select"));
        testDropDown.click();
        driver.findElement(By.xpath("//option[@value='UNIVERSAL']")).click();
        WebElement new1 = driver.findElement(By.xpath("//option[@value='UNIVERSAL']"));
        String teethFormat = new1.getAttribute("value");
        Reporter.log(teethFormat);
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'col-xl-8 col-lg-8 col-md-8 col-sm-8 col-xs-6')]"));
        for (WebElement webElement:list){
           Reporter.log(webElement.getText());
        }

        Thread.sleep(2000);

        testDropDown.click();
        driver.findElement(By.xpath("//option[@value='ISO']")).click();
        WebElement new2 = driver.findElement(By.xpath("//option[@value='ISO']"));
        String teethFormat2 = new2.getAttribute("value");
        Reporter.log(teethFormat2);
        List<WebElement> list2 = driver.findElements(By.xpath("//*[contains(@class,'col-xl-8 col-lg-8 col-md-8 col-sm-8 col-xs-6')]"));
        for (WebElement webElement:list2){
            Reporter.log(webElement.getText());
        }
        Thread.sleep(2000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
    }

    @Test(description = "Add Notes Flow",priority = 5)
    public void addNotes() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        String filePath4 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath4);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.AddNotes).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.AddNotesTextField).sendKeys("jkabisvjhijfhvowfgwfkjsbfjkfblkwh");
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.DownloadReportBtn).click();
    }
    @Test(description = "Doctors Notes Flow",priority = 6)
    public void doctorsNotes() throws InterruptedException {
        driver.navigate().refresh();
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        String filePath5 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath5);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.AddNotes).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.DoctorsNotes).sendKeys("jkabisvjhijfhvowfgwfkjsbfjkfblkwh");
        driver.findElement(sdXpaths.SaveFindingsBtn).click();

        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.DownloadReportBtn).click();
    }
    @Test(description = "Edit teeth numbers Flow",priority = 7)
    public void editTeethNumber() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        String filePath6 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath6);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.ThreeDots).click();
        driver.findElement(sdXpaths.newTeethNo).click();
        driver.findElement(sdXpaths.SaveTeethNumber).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
    }
    @Test(description = "Add findings Flow",priority = 8)
    public void addFindingsFlow() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        String filePath7 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath7);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn2).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.addFindings).click();
        driver.findElement(sdXpaths.RestorativeDefect).click();
        driver.findElement(sdXpaths.CariesDefect).click();
        driver.findElement(sdXpaths.SaveDefect).click();
        driver.findElement(sdXpaths.rejectFindings).click();
        driver.findElement(sdXpaths.saveRejectReason).click();
        driver.findElement(sdXpaths.acceptFindings).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
    }
   /* @Test(description = "Invalid File format flow")
    public void invalidFileFormat() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalBtn2).click();
        Thread.sleep(4000);
        String filePath7 = System.getProperty("user.dir") + "/resources/periapical1.png";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath7);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
    }*/
    //-----------------------------------AFTER CLASS--------------------------------
    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }
}
