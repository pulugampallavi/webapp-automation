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

public class dashboard {

    WebDriver driver;
    protected String userEmail = "pallavi@frugaltesting.com";
    protected String userPassword = "Test@12345";

    //-------------------------------------LOGIN LOGOUT XPATHS-------------------------------------
    private By username = By.xpath("//*[@id=\"mat-input-0\"]");
    private By Password = By.xpath("//*[@id=\"mat-input-1\"]");
    private By SignIn = By.xpath("//button[@type='submit']");
    private By SignOut = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/a");

    //---------------------------SEARCH PATIENT XPATH-------------------------------------------
    private By SearchButton = By.xpath("//*[@id=\"search-input\"]");
    private By FirstSearchResults = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[1]");

    //---------------------------SUPPORT SECTION XPATH-------------------------------------------
    private By SupportIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[2]");
    private By UserManual = By.xpath("/html/body/app-root/app-main-layout/support/section/div/div[2]/div/div/div/div/div[2]/a");
    //*[@id="mat-input-5"]
    //*[@id="mat-input-0"]
    //---------------------------SETTINGS SECTION XPATH-------------------------------------------
    private By settingsIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/a");
    private By UserNameField = By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/div/div/div/form/mat-form-field[1]/div/div[1]/div");
    private By CurrentPassword = By.xpath("//*[@id=\"mat-input-3\"]");
    private By NewPasswordField = By.xpath("//*[@id=\"mat-input-4\"]");
    private By ConfirmPasswordField = By.xpath("//*[@id=\"mat-input-5\"]");
    private By ShowPassword = By.xpath("/html/body/app-root/app-main-layout/app-settings/section/div/mat-tab-group/div/mat-tab-body/div/div/div/div/form/mat-form-field[3]/div/div[1]/div[2]/a");

    //----------------------------------UPLOAD AND ANALYZE XPATHS--------------------------------------
//*[@id="mat-input-6"]
    //html/body/app-root/app-auth-layout/app-signin/div/div/div/div/div/div[2]/form/div[4]/div/button
    private By SelectPatient = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[6]");
    private By UploadAnalyzeButton = By.xpath("//*[@id=\"mat-tab-label-0-2\"]");
    private By BitewingRadioBtn = By.xpath("//*[@id=\"mat-radio-4\"]/label/span[1]");

    private By UploadImageBtn = By.xpath("//*[@id=\"undefined\"]");
    private By AnalyzeBtn = By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div/div[2]/div/button[2]");

    //----------------------------------ADD PATIENTS XPATHS--------------------------------------
    private By AddPatientBtn = By.xpath("//div/button/span[text()=' Add Patient ']");
    private By AddPatFirstName = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[1]/div/div[1]/div");
    private By AddPatLastName = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[2]/div/div[1]/div");
    private By AddPatDOB = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[3]/div/div[1]/div[2]/mat-datepicker-toggle/button/span[1]");
    private By AddPAtSelectDate = By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[2]/td[7]/div[1]");
    private By AddPatGender = By.xpath("//*[@id=\"female\"]");
    private By SaveBtn = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/div[2]/button[1]");
    //----------------------------------OTHERS XPATHS--------------------------------------
    private By FullScreenBtn = By.xpath("/html/body/app-root/app-main-layout/app-header/nav/div/div[2]/ul[2]/li[1]/button");
    //----------------------------------CHAT BOT XPATHS--------------------------------------
    private By ChatbotIcon = By.xpath("//*[contains(@class,'minimized')][2]");
    private By PatientRetBtn = By.xpath("//*[@id=\"ms-28e1fd99-0d2e-5389-8b21-a9b851768f57\"]/div/ul/a[1]/li");
    private By ChatBotValidation = By.xpath("//*[@id=\"botHeaderTitle\"]");
    private By ChatBotCloseBtn = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[5]");
    //----------------------------------IMAGES XPATHS-------------------------------------
    private By ImagesSecBtn = By.xpath("//*[@id=\"mat-tab-label-0-1\"]");
    private By XrayImage = By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/app-list-images/div/div[2]/div/img");


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
    //----------------------------------LOGIN LOGOUT FLOW--------------------------------------
    public void clickLogInButton() {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys("pallavi@frugaltesting.com");

        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys("Test@12345");

        driver.findElement(SignIn).click();
    }
    public void clickLogOutButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(SignOut).click();
    }

    //-------------------------------LOGIN LOGOUT TESTCASE---------------------------------------

        @Test(description = "Check login flow")
        public void login() throws InterruptedException {
            clickLogInButton();
        }
    //-------------------------------LOGIN LOGOUT TESTCASE---------------------------------------
    @Test(description = "Check logout flow")
    public void logout() throws InterruptedException {
        clickLogOutButton();
    }


    //----------------------------------SEARCH PATIENT FLOW----------------------------------------

    public void searchPatient() throws InterruptedException {
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
            clickLogInButton();
            searchPatient();
            clickLogOutButton();
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
        clickLogInButton();
        supportSection();
        clickLogOutButton();
    }

    //----------------------------------SETTINGS SECTION FLOW----------------------------------------

    public void SettingsSection() throws InterruptedException {
            driver.findElement(settingsIcon).click();
            WebElement userField = driver.findElement(UserNameField);
            //String val = userField.getAttribute("value");
            String val = userField.getText();
            System.out.println("Entered text is: " + val);

            WebElement passField = driver.findElement(CurrentPassword);
            passField.sendKeys("Test@12345");
            String value = passField.getText();

            driver.findElement(NewPasswordField).click();
            Thread.sleep(4000);
            WebElement newele =  driver.findElement(NewPasswordField);
            newele.sendKeys("Test@123456");
            Thread.sleep(4000);
            driver.findElement(ShowPassword).click();

            driver.findElement(ConfirmPasswordField).click();
            Thread.sleep(4000);
            driver.findElement(ConfirmPasswordField).click();
            WebElement newele2 =  driver.findElement(ConfirmPasswordField);
            newele2.sendKeys("Test@123456");
    }


    //----------------------------------SETTINGS SECTION FLOW----------------------------------------

    @Test(description = "Check settings flow")
    public void settingsFlow() throws InterruptedException {
        clickLogInButton();
        SettingsSection();
        clickLogOutButton();
    }

    //----------------------------------Upload and Analyze Section Flow----------------------------------------

    public void uploadAndAnalyzeFlow() throws InterruptedException, IOException {
            driver.findElement(SelectPatient).click();
            Thread.sleep(3000);
            driver.findElement(UploadAnalyzeButton).click();
            Thread.sleep(2000);
            driver.findElement(BitewingRadioBtn).click();
            Thread.sleep(4000);
            driver.findElement(UploadImageBtn).click();
            Thread.sleep(3000);
            driver.findElement(UploadImageBtn).sendKeys("R:/Velmeni/webapp-automation/resources/bitewing1.jpeg");
            driver.findElement(UploadImageBtn).submit();
            driver.findElement(AnalyzeBtn).click();
    }

    //----------------------------------Upload and Analyze Section Testcase----------------------------------------
    @Test(description = "Check Upload and Analyze flow")
    public void UploadAndAnalyze() throws InterruptedException, IOException {
            clickLogInButton();
            uploadAndAnalyzeFlow();
            clickLogOutButton();

    }

    //----------------------------------ADD PATIENTS FLOW--------------------------------------
    public void addPatientFlow() throws InterruptedException {

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
            newaction2.sendKeys("Queen").build().perform();
            driver.findElement(AddPatDOB).click();
            Thread.sleep(2000);
            driver.findElement(AddPAtSelectDate).click();
            driver.findElement(AddPatGender).click();
            driver.findElement(SaveBtn).click();
    }

    //----------------------------------ADD PATIENTS TESTCASE--------------------------------------

    @Test(description = "Check Add Patient flow")
    public void AddPatient() throws InterruptedException {
            clickLogInButton();
            addPatientFlow();
            clickLogOutButton();
    }

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
            clickLogInButton();
            ChatbotFlow();
            clickLogOutButton();
    }

    //----------------------------------IMAGES SECTION--------------------------------------
    public void ImagesSection(){
            driver.findElement(SelectPatient).click();
            driver.findElement(ImagesSecBtn).click();
            driver.findElement(XrayImage).click();

    }

    @Test(description = "Check Images flow")
    //----------------------------------IMAGES TESTCASE-------------------------------------
    public void ImagesFlow() throws InterruptedException {
            clickLogInButton();
            ImagesSection();
            clickLogOutButton();
    }
    @Test(description = "Check Images flow")
    //----------------------------------IMAGES TESTCASE-------------------------------------
    public void EntireFlow() throws InterruptedException, IOException {
        clickLogInButton();
        searchPatient();
        supportSection();
        SettingsSection();
        //uploadAndAnalyzeFlow();
        addPatientFlow();
        ChatbotFlow();
        ImagesSection();
        clickLogOutButton();
    }

    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}