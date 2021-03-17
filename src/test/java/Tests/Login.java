package Tests;

import Base.TestBase;
import Utils.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    @Parameters({"username", "password"})
    public void login(String username, String password){

        wait.until(ExpectedConditions.elementToBeClickable(Constants.USERNAME)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(Constants.PASSWORD)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Constants.LOGIN_BTN)).click();
    }
}
