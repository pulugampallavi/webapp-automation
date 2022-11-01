package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
public class Images extends BaseTest{
    WebDriver driver;


    //----------------------------------IMAGES XPATHS-------------------------------------
    //*[@id="mat-tab-label-2-1"]
    //*[@id="mat-tab-label-2-1"]/div
    //*[@id="mat-tab-label-0-1"]
    private By ImagesSecBtn = By.xpath("//*[@id=\"mat-tab-label-0-1\"]");
    private By XrayImage = By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/app-list-images/div/div[2]/div/img");


    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
    }

    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

