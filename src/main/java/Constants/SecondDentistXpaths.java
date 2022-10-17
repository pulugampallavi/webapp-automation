package Constants;

import org.openqa.selenium.By;

public class SecondDentistXpaths {
    //-------------------------------------LOGIN LOGOUT XPATHS-------------------------------------
    public By username = By.xpath("//*[@id=\"mat-input-0\"]");
    public By Password = By.xpath("//*[@id=\"mat-input-1\"]");
    public By SignIn = By.xpath("//button[@type='submit']");
    public By SignOut = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/a");

    //----------------------------------ADD PATIENTS XPATHS--------------------------------------
    public By PatientSection = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[1]/a");
    public By AddPatientBtn = By.xpath("//div/button/span[text()=' Add Patient ']");
   // /html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[1]/div/div[2]/button
    public By AddPatFirstName = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[1]/div/div[1]/div");
    public By AddPatLastName = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[2]/div/div[1]/div");
    public By AddPatDOB = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[3]/div/div[1]/div[2]/mat-datepicker-toggle/button/span[1]");
    public By AddPAtSelectDate = By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[2]/td[7]/div[1]");
    public By AddPatGender = By.xpath("//*[@id=\"female\"]");
    public By SaveBtn = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/div[2]/button[1]");

    //----------------------------------CHAT BOT XPATHS--------------------------------------
    public By ChatBotValidation = By.xpath("//*[@id=\"botHeaderTitle\"]");
    public By ChatBotCloseBtn = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[5]");

    //----------------------------------UPLOAD AND ANALYZE XPATHS--------------------------------------
    public By SelectPatient = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[6]");
    public By UploadAnalyzeButton = By.xpath("//*[@id=\"mat-tab-label-0-2\"]");
    public By BitewingRadioBtn = By.xpath("//*[@id=\"mat-radio-4\"]/label/span[1]");
    public By UploadImageBtn = By.xpath("//*[@id=\"undefined\"]");
    public By ProceedBtn = By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div/div[2]/div/button[2]");
    public By AnalyzeBtnPopup = By.xpath("//*[@id=\"mat-dialog-0\"]/app-analyze-consent/div/div[2]/button[2]");
    public By AcceptBtn = By.xpath("//div/button[@class='mat-focus-indicator pull-right btn-report mat-raised-button mat-button-base']");

 //*[@id="cdk-step-content-0-1"]/form/div/div[4]/div[1]/div[3]/div/button[1]
 //*[@id="cdk-step-content-2-1"]/form/div/div[4]/div[1]/div[3]/div/button[1]
    public By SaveFindingsBtn = By.xpath("//div/button[@class='mat-focus-indicator btn-back btn-save mat-raised-button mat-button-base']");
    public By DownloadReportBtn = By.xpath("//div/button[@class='mat-focus-indicator btn-report mat-raised-button mat-button-base']");

    //---------------------------SUPPORT SECTION XPATH-------------------------------------------
    public By SupportIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[2]");
    public By UserManual = By.xpath("/html/body/app-root/app-main-layout/support/section/div/div[2]/div/div/div/div/div[2]/a");

    //---------------------------SETTINGS SECTION XPATH-------------------------------------------
    public By settingsIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/a");
    public By UserNameField = By.xpath("//*[@id=\"mat-input-2\"]");
    public By CurrentPassword = By.xpath("//*[@id=\"mat-input-3\"]");
    public By NewPasswordField = By.xpath("//*[@id=\"mat-input-4\"]");
    public By ConfirmPasswordField = By.xpath("//*[@id=\"mat-input-5\"]");
    public By ShowPassword = By.xpath("/html/body/app-root/app-main-layout/app-settings/section/div/mat-tab-group/div/mat-tab-body/div/div/div/div/form/mat-form-field[3]/div/div[1]/div[2]/a");

    //---------------------------SEARCH PATIENT XPATH-------------------------------------------
    public By SearchButton = By.xpath("//*[@id=\"search-input\"]");
    public By FirstSearchResults = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[1]");

    //----------------------------------OTHERS XPATHS--------------------------------------
    public By FullScreenBtn = By.xpath("/html/body/app-root/app-main-layout/app-header/nav/div/div[2]/ul[2]/li[1]/button");

    //----------------------------------PATIENT VISITS XPATHS--------------------------------------
    public By PVHeader = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-header-row");
    public By PatientVisitsSection = By.xpath("//*[@id=\"mat-tab-label-0-0\"]");
    public By SelectPatient2 = By.xpath("/html/body/app-root/app-main-layout/app-allpatients/section/div/div[2]/div/div/div/div[2]/mat-table/mat-row[1]");
    public By ImageIconSmall = By.xpath("//div/mat-table/mat-row/mat-cell/mat-icon[@title='View Images']");
    public By ReportIconSmall = By.xpath("//div/mat-table/mat-row/mat-cell/mat-icon[@aria-label='Report']");

}
