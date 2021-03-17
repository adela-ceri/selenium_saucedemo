
package Tests;
import Base.TestBase;
import Tests.Login;
import Utils.Constants;
import Utils.Data;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Product extends TestBase {

    @Test
    @Parameters({"username", "password"})
    public void productsList(String username, String password){

        Login log = new Login();
        log.login(username, password);

        List<WebElement> title = driver.findElements(Constants.PRODUCTS_TITLE);

        for(int i=0; i<title.size(); i++) {
            Assert.assertEquals(title.get(i).getText(), Data.prodTitle.get(i));
        }

        List<WebElement> price = driver.findElements(Constants.PRODUCTS_PRICE);

        for(int i=0; i<price.size(); i++) {
            Assert.assertEquals(price.get(i).getText(), Data.prodPrice.get(i));
        }
    }
}
