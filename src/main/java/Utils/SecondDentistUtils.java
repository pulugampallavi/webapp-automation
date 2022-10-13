package Utils;

import Constants.SecondDentistXpaths;
import org.openqa.selenium.WebDriver;

public class SecondDentistUtils extends SecondDentistXpaths {

    public void clickLogInButton(WebDriver driver) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys("pallavi@frugaltesting.com");

        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys("Test@12345");

        driver.findElement(SignIn).click();
    }

}
