package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
public class Others extends BaseTest{
    WebDriver driver;
    private LoginLogout LoginPage;

    //----------------------------------OTHERS XPATHS--------------------------------------
    private By FullScreenBtn = By.xpath("/html/body/app-root/app-main-layout/app-header/nav/div/div[2]/ul[2]/li[1]/button");
    //----------------------------------CHAT BOT XPATHS--------------------------------------
    private By ChatbotIcon = By.xpath("//*[contains(@class,'minimized')][2]");
    private By PatientRetBtn = By.xpath("//*[@id=\"ms-28e1fd99-0d2e-5389-8b21-a9b851768f57\"]/div/ul/a[1]/li");
    private By ChatBotValidation = By.xpath("//*[@id=\"botHeaderTitle\"]");
    private By ChatBotCloseBtn = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[5]");


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
