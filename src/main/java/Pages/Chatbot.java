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
public class Chatbot {
    WebDriver driver;
    private loginPage  LoginPage;

    //----------------------------------CHAT BOT XPATHS--------------------------------------
    private By ChatbotIcon = By.xpath("//*[contains(@class,'minimized')][2]");
    private By PatientRetBtn = By.xpath("//*[@id=\"ms-28e1fd99-0d2e-5389-8b21-a9b851768f57\"]/div/ul/a[1]/li");
    private By ChatBotValidation = By.xpath("//*[@id=\"botHeaderTitle\"]");
    private By ChatBotCloseBtn = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[5]");


    //----------------------------------CHATBOT FLOW--------------------------------------

    public void ChatbotFlow() throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('minimized')[0].click();");
        Thread.sleep(5000);
        WebElement element2 = driver.findElement(ChatBotValidation);
        if (element2.isDisplayed()){
            System.out.println("ChatBot Popup opened");
        }
        else {
            System.out.println("ChatBot popup did not open");
        }
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[0].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[1].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[2].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[3].click();");
        Thread.sleep(10000);
        js.executeScript("document.getElementsByClassName('buttonTmplContentChild')[4].click();");
        driver.findElement(ChatBotCloseBtn).click();

    }

    //----------------------------------CHATBOT TESTCASE--------------------------------------

    @Test(description = "Check ChatBot flow")
    public void ChatBot() throws InterruptedException {
        LoginPage.clickLogInButton();
        ChatbotFlow();
        LoginPage.clickLogOutButton();
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
