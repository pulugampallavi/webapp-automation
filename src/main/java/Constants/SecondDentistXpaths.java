package Constants;

import org.openqa.selenium.By;

public class SecondDentistXpaths {
    //-------------------------------------LOGIN LOGOUT XPATHS-------------------------------------
    public By usernameXpath = By.xpath("//*[@id=\"mat-input-0\"]");
    //div/input[@formcontrolname='email']
    public By PasswordXpath = By.xpath("//*[@id=\"mat-input-1\"]");
    //div/input[@formcontrolname='password']
    public By SignIn = By.xpath("//button[@type='submit']");
    public By SignOut = By.xpath("//a/i[text()='power_settings_new']");
    //*[@id="leftsidebar"]/div/ul/li[4]/a/i
    public By RememberMeCheckbox = By.xpath("/html/body/app-root/app-auth-layout/app-signin/div/div/div/div/div/div[2]/form/div[3]/div/label/span/span");
    public By RememberMe = By.xpath("/html/body/app-root/app-auth-layout/app-signin/div/div/div/div/div/div[2]/form/div[3]/div/label");
    public By ForgotPassword = By.xpath("//a[text()='Forgot Password?']");
    public By ShowPasswordLogin = By.xpath("/html/body/app-root/app-auth-layout/app-signin/div/div/div/div/div/div[2]/form/div[2]/div/mat-form-field/div/div[1]/div[4]/a/mat-icon");
    //----------------------------------ADD PATIENTS XPATHS--------------------------------------
    public By PatientSection = By.xpath("//a/i[text()='person']");
    public By AddPatientBtn = By.xpath("//div/button/span[text()=' Add Patient ']");
    public By AddPatFirstName = By.xpath("//div/input[@data-placeholder='First name']");
    public By AddPatLastName = By.xpath("//div/input[@data-placeholder='Last name']");
    public By DOBField = By.xpath("//*[@id=\"mat-dialog-1\"]/app-add-patient/div/div/div[2]/div/form/mat-form-field[3]/div/div[1]/div[1]");
    public By AddPatDOB = By.xpath("//div//child::input[@data-placeholder='Date of Birth (We are accepting only patient having age 14 or above)']");
  //  public By AddPAtSelectDate = By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[2]/td[7]/div[1]");
    public By AddPatGender = By.xpath("//*[@id=\"female\"]");
    public By SaveBtn = By.xpath("//*[@id=\"mat-dialog-0\"]/app-add-patient/div/div/div[2]/div/form/div[2]/button[1]");
    public By SaveBtnDisabled = By.xpath("//*[@id=\"mat-dialog-1\"]/app-add-patient/div/div/div[2]/div/form/div[2]/button[1]/span[1]");
    public By CrossAddPopUp = By.xpath("//*[@id=\"mat-dialog-1\"]/app-add-patient/div/div/div[1]/button/span[1]/mat-icon");
    //----------------------------------CHAT BOT XPATHS--------------------------------------
    public By ChatBotValidation = By.xpath("//*[@id=\"botHeaderTitle\"]");
    public By ChatBotCloseBtn = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[5]");
    public By ChatBotReconnect = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[2]");
    public By ChatBotMinimize = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[3]");
    public By ChatBotExpand = By.xpath("//*[@id=\"KORE_BOT\"]/div[4]/div[3]/button[4]");
    public By ChatBotIcon = By.xpath("//*[@id=\"KORE_BOT\"]/div[3]/span");

    //----------------------------------UPLOAD AND ANALYZE XPATHS--------------------------------------
    public By SelectPatient = By.xpath("//div/mat-table/mat-row[@class='mat-row cdk-row ng-star-inserted']");
    public By UploadAnalyzeButton = By.xpath("//div[text()='UPLOAD & ANALYZE']");
    public By PeriapicalRadioBtn = By.xpath("//div//child::span[text()='Periapical']");
    public By BitewingRadioBtn = By.xpath("//div//child::span[text()='Bitewing']");
    public By UploadImageBtn = By.xpath("//*[@id=\"undefined\"]");
    public By ProceedBitewing = By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div/div[2]/div/button[2]");
    public By ProceedBtn = By.xpath("//div//child::span[text()='Proceed']");
    public By AnalyzeBtnPopup = By.xpath("//div//child::span[text()='Analyze']");
    public By AcceptBtn = By.xpath("//div//child::span[text()='Accept']");
    public By SaveFindingsBtn = By.xpath("//div//child::mat-icon[text()='save']");
    public By DownloadReportBtn = By.xpath("//button//child::mat-icon[text()='download']");
    public By AddNotes = By.xpath("//*[@id=\"cdk-step-content-0-1\"]/form/div/div[4]/div[4]/div/div[4]/label");
    public By AddNotesTextField = By.xpath("//*[@id=\"cdk-step-content-0-1\"]/form/div/div[4]/div[4]/div/div[4]/textarea");
    public By DoctorsNotes = By.xpath("//*[@id=\"doc_notes\"]");
    //-------------------------------------------------------------------
    public By BrightnessSlider = By.xpath("//mat-label[text()='Brightness']//parent::div");
    public By ContrastSlider = By.xpath("//mat-label[text()='Contrast']//parent::div");
    public By PeriapicalBtn2 = By.xpath("//div//child::span[text()='Periapical']");
    public By ProceedBtn2 = By.xpath("//div//child::span[text()='Proceed']");
    public By magnifierIcon = By.xpath("//*[@id=\"cdk-step-content-0-1\"]/form/div/div[1]/div[3]/span[1]");
    public By AntiClockwiseRotate = By.xpath("//div//child::span[text()='rotate_90_degrees_ccw']");
    public By ClockwiseRotate = By.xpath("//div//child::span[text()='rotate_90_degrees_cw']");
    public By InvertImage = By.xpath("//div//child::span[text()='invert_colors']");
    public By RefreshBtn = By.xpath("//div//child::span[text()='refresh']");
    public By FindingsIcon = By.xpath("//div//child::button[@title='Click to view all supported findings.']");
    public By CLoseFindingPopup = By.xpath("//div//child::mat-icon[text()='close']");
    public By HideFindings = By.xpath("//div//child::button[@title='Click to hide findings from image.']");
    public By UploadImageSmlBtn = By.xpath("//div//child::button[@title='Click to upload new image.']");
    public By RefreshSmlBtn = By.xpath("//div//child::button[@title='Click to reload current image with predictions.']");
    public By PrintBtn = By.xpath("//div//child::mat-icon[text()='print']");
    public By ThreeDots = By.xpath("//div//child::span[text()='more_vert']");
    public By newTeethNo = By.xpath("//div//child::div[text()='34']");
    public By SaveTeethNumber = By.xpath("//button//child::span[text()='Save']");
    public By addFindings = By.xpath("//div//child::span[text()='add_circle_outline']");
    public By RestorativeDefect = By.xpath("//span//child::mat-panel-title[text()=' Restorative ']");
    public By CariesDefect = By.xpath("//div[text()=' Caries ']");
    public By SaveDefect = By.xpath("//button/span[text()='Save']");
    public By acceptFindings = By.xpath("//div//child::span[text()='check_circle_outline']");
    public By rejectFindings = By.xpath("//div//child::span[text()='highlight_off']");
    public By saveRejectReason = By.xpath("//button/span[text()='Save']");
    public By hereBtnUA = By.xpath("//span/a[text()='here.']");
    //---------------------------SUPPORT SECTION XPATH-------------------------------------------
    public By SupportIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[2]");
    public By UserManual = By.xpath("/html/body/app-root/app-main-layout/support/section/div/div[2]/div/div/div/div/div[2]/a");

    //---------------------------SETTINGS SECTION XPATH-------------------------------------------
    public By settingsIcon = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/a/i");
    public By UserNameField = By.xpath("//div/input[@formcontrolname='email']");
    public By CurrentPassword = By.xpath("//div/input[@formcontrolname='old_pwd']");
    public By CurrPassword2 = By.xpath("//div/input[@formcontrolname='old_pwd']");
    public By NewPasswordField = By.xpath("//div/input[@formcontrolname='new_pwd']");
    public By ConfirmPasswordField = By.xpath("//div/input[@formcontrolname='confirm_pwd']");
    public By ShowPassword = By.xpath("/html/body/app-root/app-main-layout/app-settings/section/div/mat-tab-group/div/mat-tab-body/div/div/div/div/form/mat-form-field[3]/div/div[1]/div[2]/a");
    public By SaveBtnSettings = By.xpath("//div/button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary mat-button-disabled']");
    public By SaveSettings2 = By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/div/div/button");
    //---------------------------SEARCH PATIENT XPATH-------------------------------------------
    public By SearchButton = By.xpath("//*[@id=\"search-input\"]");
    //----------------------------------OTHERS XPATHS--------------------------------------
    public By FullScreenBtn = By.xpath("/html/body/app-root/app-main-layout/app-header/nav/div/div[2]/ul[2]/li[1]/button");
    //----------------------------------PATIENT VISITS XPATHS--------------------------------------
    public By PVHeader = By.xpath("//li[text()=' Akash Jaiswal']");
    public By PatientVisitsSection = By.xpath("//*[@id=\"mat-tab-label-0-0\"]");
    public By SelectPatient2 = By.xpath("//mat-table/mat-row[1]");
    public By ImageIconSmall = By.xpath("(//mat-cell/mat-icon[@title='View Images'])[1]");
    public By ScanDetails = By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/app-list-images/div");
    public By ReportIconSmall = By.xpath("(//mat-cell//child::mat-icon[text()='description '])[1]");

    //----------------------------------PATIENTS XPATHS--------------------------------------
    public By EditPatient = By.xpath("(//mat-cell/mat-icon[text()='edit'])[1]");
    public By PatientDetails = By.xpath("(//mat-cell/mat-icon[text()='info'])[1]");

    //----------------------------------IMAGES XPATHS--------------------------------------
    public By ImagesSecBtn = By.xpath("//div[text()='IMAGES']");
    public By XrayImage = By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/app-list-images/div/div[2]/div/img");
}
