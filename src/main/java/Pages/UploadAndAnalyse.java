package Pages;
import Constants.SecondDentistXpaths;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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

    public void defaultCode() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.PeriapicalRadioBtn).click();
        Thread.sleep(4000);
        String filePath1 = System.getProperty("user.dir") + "/resources/periapical1.JPG";
        driver.findElement(sdXpaths.UploadImageBtn).sendKeys(filePath1);
        driver.findElement(sdXpaths.UploadImageBtn).submit();
        driver.findElement(sdXpaths.ProceedBtn).click();
        driver.findElement(sdXpaths.AnalyzeBtnPopup).click();
    }

    //----------------------------------Upload and Analyze Section Testcase----------------------------------------
    @Test(description = "Check U&A flow for bitewing image", priority = 1)
    public void uploadAndAnalyze() throws InterruptedException, IOException {
        sdUtils.bitewingImage(driver);
    }
    @Test(description = "Check U&A flow for periapical image",priority = 2)
    public void periapicalImage() throws InterruptedException {
        defaultCode();
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
    public void uAndARegBrightSlider() throws InterruptedException {
        defaultCode();
        //Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.BrightnessSlider));
        Assert.assertTrue(driver.findElement(sdXpaths.BrightnessSlider).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 4)
    public void uAndARegContrastSlider() throws InterruptedException {
        defaultCode();
        //Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.ContrastSlider));
        Assert.assertTrue(driver.findElement(sdXpaths.ContrastSlider).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 5)
    public void uAndARegMagnifierIcon() throws InterruptedException {
        defaultCode();
        //Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.magnifierIcon));
        Assert.assertTrue(driver.findElement(sdXpaths.magnifierIcon).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 6)
    public void uAndARegAntiClkRotate() throws InterruptedException {
        defaultCode();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.AntiClockwiseRotate));
        Assert.assertTrue(driver.findElement(sdXpaths.AntiClockwiseRotate).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 7)
    public void uAndARegClockwiseRotate() throws InterruptedException {
        defaultCode();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.ClockwiseRotate));
        Assert.assertTrue(driver.findElement(sdXpaths.ClockwiseRotate).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 8)
    public void uAndARegInvertImage() throws InterruptedException {
        defaultCode();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.InvertImage));
        Assert.assertTrue(driver.findElement(sdXpaths.InvertImage).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 9)
    public void uAndARegRefreshBtn() throws InterruptedException {
        defaultCode();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.RefreshBtn));
        Assert.assertTrue(driver.findElement(sdXpaths.RefreshBtn).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 10)
    public void uAndARegSuppotedFindings() throws InterruptedException {
        defaultCode();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.FindingsIcon));
        driver.findElement(sdXpaths.FindingsIcon).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("Supported Findings"));
        driver.findElement(sdXpaths.CLoseFindingPopup).click();
    }
    @Test(description = "Upload and analyze Regression flow",priority = 11)
    public void uAndARegHideFindings() throws InterruptedException {
        defaultCode();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.HideFindings));
        Assert.assertTrue(driver.findElement(sdXpaths.HideFindings).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 12)
    public void uAndARegReloadImgBtn() throws InterruptedException {
        defaultCode();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.RefreshSmlBtn));
        Assert.assertTrue(driver.findElement(sdXpaths.RefreshSmlBtn).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 13)
    public void uAndARegPrintReportBtn() throws InterruptedException {
        defaultCode();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.PrintBtn));
        Assert.assertTrue(driver.findElement(sdXpaths.PrintBtn).isDisplayed());
    }
    @Test(description = "Upload and analyze Regression flow",priority = 14)
    public void uAndARegUploadImgBtn() throws InterruptedException {
        defaultCode();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sdXpaths.UploadImageSmlBtn));
        driver.findElement(sdXpaths.UploadImageSmlBtn).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("Select Image Type:"));
    }
    @Test(description = "Teeth Numbering Flow Universal",priority = 15)
    public void teethNumberingUni() throws InterruptedException {
        defaultCode();
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
        }}
    @Test(description = "Teeth Numbering Flow ISO",priority = 16)
    public void teethNumberingISO() throws InterruptedException {
        defaultCode();
        Thread.sleep(2000);
        WebElement testDropDown = driver.findElement(By.xpath("//option[@value='UNIVERSAL']//parent::select"));
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

    @Test(description = "Add Notes Flow",priority = 17)
    public void addNotes() throws InterruptedException {
        defaultCode();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.AddNotes).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.AddNotesTextField).sendKeys("jkabisvjhijfhvowfgwfkjsbfjkfblkwh");
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.DownloadReportBtn).click();
    }
    @Test(description = "Doctors Notes Flow",priority = 18)
    public void doctorsNotes() throws InterruptedException {
        defaultCode();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.AddNotes).click();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.DoctorsNotes).sendKeys("jkabisvjhijfhvowfgwfkjsbfjkfblkwh");
        driver.findElement(sdXpaths.SaveFindingsBtn).click();

        driver.findElement(sdXpaths.SaveFindingsBtn).click();
        driver.findElement(sdXpaths.DownloadReportBtn).click();
    }
    @Test(description = "Edit teeth numbers Flow",priority = 19)
    public void editTeethNumber() throws InterruptedException {
        defaultCode();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.AcceptBtn).click();
        driver.findElement(sdXpaths.ThreeDots).click();
        driver.findElement(sdXpaths.newTeethNo).click();
        driver.findElement(sdXpaths.SaveTeethNumber).click();
        driver.findElement(sdXpaths.SaveFindingsBtn).click();
    }
    @Test(description = "Add findings Flow",priority = 20)
    public void addFindingsFlow() throws InterruptedException {
        defaultCode();
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
    @Test(description = "User Manual in U and A Flow",priority = 21)
    public void userManualHyperlinkUandAFlow() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(sdXpaths.SelectPatient).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.UploadAnalyzeButton).click();
        Thread.sleep(5000);
        driver.findElement(sdXpaths.hereBtnUA).click();
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
        String filePath7 = System.getProperty("user.dir") + "/resources/periapical1.zip";
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
