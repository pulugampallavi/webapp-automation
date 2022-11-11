package Pages;
import Constants.SecondDentistXpaths;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class Images extends BaseTest{
    WebDriver driver;
    SecondDentistUtils sdUtils;
    SecondDentistXpaths sdXpaths;

    //----------------------------------IMAGES XPATHS-------------------------------------

    private By ImagesSecBtn = By.xpath("//*[@id=\"mat-tab-label-0-1\"]");
    private By XrayImage = By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/app-list-images/div/div[2]/div/img");


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
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
        driver.get(BaseTest.url);
        Thread.sleep(2000);
        sdUtils.clickLogInButton(driver);
    }
    @Test(description = "Check Images flow")
    public void ImagesFlow() throws InterruptedException {
        sdUtils.ImagesSection(driver);
    }

    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }
}

