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
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class Support {
    WebDriver driver;
    private loginPage  LoginPage;

    //---------------------------SUPPORT SECTION XPATH-------------------------------------------
    private By SupportIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[2]");
    private By UserManual = By.xpath("/html/body/app-root/app-main-layout/support/section/div/div[2]/div/div/div/div/div[2]/a");

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
    //----------------------------------SUPPORT FLOW----------------------------------------

    public void supportSection() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(SupportIcon).click();
        boolean supMailVld = driver.getPageSource().contains("hello@velmeni.ai");
        if (supMailVld == true) {
            System.out.println("Support Mail ID is visible");
        }
        driver.findElement(UserManual).click();
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

    //----------------------------------SUPPORT SECTION TESTCASE----------------------------------------

    @Test(description = "Check support flow")
    public void supportFlow() throws InterruptedException {
        LoginPage.clickLogInButton();
        supportSection();
        LoginPage.clickLogOutButton();
    }

}
