package Tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    public static String environment = null;
    public static String url = null;
    public static String username = null;
    public static String password = null;

    @Parameters({"environment", "url", "username", "password"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String env, String weburl, String usrname, String pwd) {
        System.setProperty("webdriver.chrome.driver", "/path/to/driver");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        environment = env;
        url = weburl;
        username = usrname;
        password = pwd;
    }
}
