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
public class SearchPatient {
    WebDriver driver;

    //---------------------------SEARCH PATIENT XPATH-------------------------------------------
    private By SearchButton = By.xpath("//*[@id=\"search-input\"]");
    private By FirstSearchResults = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[1]");

    //----------------------------------OTHERS XPATHS--------------------------------------
    private By FullScreenBtn = By.xpath("/html/body/app-root/app-main-layout/app-header/nav/div/div[2]/ul[2]/li[1]/button");

    private loginPage  LoginPage;
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

    //----------------------------------SEARCH PATIENT FLOW----------------------------------------

    public void searchPatient() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(FullScreenBtn).click();
        driver.findElement(SearchButton).click();
        driver.findElement(SearchButton).sendKeys("Bitewing");
        driver.findElement(By.xpath("//div/mat-table/mat-row[@class='mat-row cdk-row ng-star-inserted']")).click();
        Thread.sleep(4000);
        boolean vld = driver.getPageSource().contains(" Bitewing Cases");
        if (vld == true) {
            System.out.println("Redirected to correct user");
        }
    }

    //----------------------------------SEARCH PATIENT TESTCASE----------------------------------------

    @Test(description = "Check search patient flow")
    public void searchPatientFlow() throws InterruptedException {
        LoginPage.clickLogInButton();
        searchPatient();
        LoginPage.clickLogOutButton();

    }

}
