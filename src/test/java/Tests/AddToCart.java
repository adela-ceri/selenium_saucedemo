package Tests;

import Base.TestBase;
import Utils.Constants;
import Utils.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCart extends TestBase {

    @Test
    @Parameters({"username", "password"})
    public void cart(String username, String password){

        Login log = new Login();
        log.login(username, password);

        wait.until(ExpectedConditions.numberOfElementsToBe(Constants.ADD_TO_CART_BTN, Data.ProdNr));

        List<WebElement> addToCardBtn = driver.findElements(Constants.ADD_TO_CART_BTN);
        addToCardBtn.get(0).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Constants.CART_BADGE))).isDisplayed();

        Assert.assertEquals(driver.findElement(Constants.CART_BADGE).getText(),Data.cartBadge);

        driver.findElement(Constants.SHOPPING_CART).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Constants.SHOPPING_CART_TITLE)));
        Assert.assertEquals(driver.findElement(Constants.SHOPPING_CART_TITLE).getText(),Data.cartTitle.get(0));

        Assert.assertEquals(driver.findElement(Constants.CART_QUANTITY).getText(),Data.cartBadge);

        driver.findElement(Constants.CHECKOUT_BTN).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Constants.SHOPPING_CART_TITLE)));
        Assert.assertEquals(driver.findElement(Constants.SHOPPING_CART_TITLE).getText(),Data.cartTitle.get(1));

        wait.until(ExpectedConditions.elementToBeClickable(Constants.FIRST_NAME)).sendKeys(Data.checkoutInformation.get(0));
        wait.until(ExpectedConditions.elementToBeClickable(Constants.LAST_NAME)).sendKeys(Data.checkoutInformation.get(1));
        wait.until(ExpectedConditions.elementToBeClickable(Constants.ZIP_CODE)).sendKeys(Data.checkoutInformation.get(2));

        driver.findElement(Constants.CONTINUE_BTN).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Constants.SHOPPING_CART_TITLE)));
        Assert.assertEquals(driver.findElement(Constants.SHOPPING_CART_TITLE).getText(),Data.cartTitle.get(2));

        Assert.assertEquals(driver.findElement(Constants.TOTAL_LABEL).getText(), "Item total: "+Data.prodPrice.get(0));
        Assert.assertEquals(driver.findElement(Constants.TAX).getText(), "Tax: "+Data.tax);

        String subTotal = Data.prodPrice.get(0).substring(1);
        String tax = Data.tax.substring(1);
        Assert.assertEquals(driver.findElement(Constants.TOTAL).getText(), "Total: $"+(Double.parseDouble(subTotal) + Double.parseDouble(tax)));

        driver.findElement(Constants.FINISH_BTN).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Constants.SHOPPING_CART_TITLE)));
        Assert.assertEquals(driver.findElement(Constants.SHOPPING_CART_TITLE).getText(),Data.cartTitle.get(3));

    }
}