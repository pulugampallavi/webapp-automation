package Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadFileRobot {

    WebDriver driver;

    //-------------------------------------LOGIN LOGOUT XPATHS-------------------------------------
    private By username = By.xpath("//*[@id=\"mat-input-0\"]");
    private By Password = By.xpath("//*[@id=\"mat-input-1\"]");
    private By SignIn = By.xpath("//button[@type='submit']");
    private By SignOut = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/a");

    //----------------------------------UPLOAD AND ANALYZE XPATHS--------------------------------------

    private By SelectPatient = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[6]");
    private By UploadAnalyzeButton = By.xpath("//*[@id=\"mat-tab-label-0-2\"]");
    private By BitewingRadioBtn = By.xpath("//*[@id=\"mat-radio-4\"]/label/span[1]");

    private By UploadImageBtn = By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div/ngx-dropzone/ngx-dropzone-label");
    private By AnalyzeBtn = By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div/div[2]/div/button[2]");


    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
//    String URL = "https://app.seconddentist.ai/#/authentication/signin";
//    @Test
//    public void testUpload() throws InterruptedException
//    {
//        WebDriver  driver = new FirefoxDriver();
//        driver.get(URL);
//        WebElement element = driver.findElement(By.name("uploadfile"));
//        element.click();
//        uploadFile("R:\\Velmeni\\webapp-automation\\resources\\bitewing1.jpeg");
//        Thread.sleep(2000);
//    }

    /**
     * This method will set any parameter string to the system's clipboard.
     */
    public static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static void uploadFile(String fileLocation) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
         }
    }


    public void clickLogInButton() {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys("pallavi@frugaltesting.com");

        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys("Test@12345");

        driver.findElement(SignIn).click();
    }

//----------------------------------Upload and Analyze Section Flow----------------------------------------

    public void uploadAndAnalyzeFlow() throws InterruptedException, IOException {
        driver.findElement(SelectPatient).click();
        Thread.sleep(3000);
        driver.findElement(UploadAnalyzeButton).click();
        Thread.sleep(2000);
        driver.findElement(BitewingRadioBtn).click();
        Thread.sleep(4000);
        driver.findElement(UploadImageBtn);
        uploadFile("R:\\Velmeni\\webapp-automation\\resources\\periapical1.png");
   //     driver.findElement(AnalyzeBtn).click();
    }
    public void clickLogOutButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(SignOut).click();
    }

    //----------------------------------Upload and Analyze Section Testcase----------------------------------------
    @Test(description = "Check Upload and Analyze flow")
    public void UploadAndAnalyze() throws InterruptedException, IOException {
        clickLogInButton();
        uploadAndAnalyzeFlow();
        clickLogOutButton();
    }

//-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}