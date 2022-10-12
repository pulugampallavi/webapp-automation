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
public class AddPatient {
    WebDriver driver;
    private loginPage  LoginPage;

    //----------------------------------ADD PATIENTS XPATHS--------------------------------------
    private By PatientSection = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[1]/a");
    private By AddPatientBtn = By.xpath("//div/button/span[text()=' Add Patient ']");
    private By AddPatFirstName = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[1]/div/div[1]/div");
    private By AddPatLastName = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[2]/div/div[1]/div");
    private By AddPatDOB = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[3]/div/div[1]/div[2]/mat-datepicker-toggle/button/span[1]");
    private By AddPAtSelectDate = By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[2]/td[7]/div[1]");
    private By AddPatGender = By.xpath("//*[@id=\"female\"]");
    private By SaveBtn = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/div[2]/button[1]");


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
    //----------------------------------ADD PATIENTS FLOW--------------------------------------
    public void addPatientFlow() throws InterruptedException {
        driver.findElement(PatientSection).click();
        Thread.sleep(2000);
        driver.findElement(AddPatientBtn).click();
        Actions element1 = new Actions(driver);
        WebElement fname = driver.findElement(AddPatFirstName);
        element1.doubleClick(fname).perform();
        Thread.sleep(4000);
        Actions newaction = new Actions(driver);
        newaction.sendKeys("Cinderella").build().perform();
        driver.findElement(AddPatLastName).click();
        Thread.sleep(4000);
        Actions newaction2 = new Actions(driver);
        newaction2.sendKeys("Thomas").build().perform();
        driver.findElement(AddPatDOB).click();
        Thread.sleep(2000);
        driver.findElement(AddPAtSelectDate).click();
        driver.findElement(AddPatGender).click();
        driver.findElement(SaveBtn).click();
    }

    //----------------------------------ADD PATIENTS TESTCASE--------------------------------------

    @Test(description = "Check Add Patient flow")
    public void AddPatient() throws InterruptedException {
        LoginPage.clickLogInButton();
        addPatientFlow();
        LoginPage.clickLogOutButton();
    }
}
