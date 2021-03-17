package Utils;

import org.openqa.selenium.By;

public class Constants {

    public static By USERNAME = By.id("user-name");
    public static By PASSWORD = By.id("password");
    public static By LOGIN_BTN = By.id("login-button");
    public static By PRODUCTS_TITLE = By.xpath("//div[@class='inventory_item_name']");
    public static By PRODUCTS_PRICE= By.xpath("//div[@class='inventory_item_price']");
    public static By ADD_TO_CART_BTN = By.xpath("//*[@id=\"inventory_container\"]//button");
    public static By CART_BADGE = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    public static By SHOPPING_CART = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    public static By SHOPPING_CART_TITLE = By.xpath("//*[@id=\"contents_wrapper\"]/div[@class=\"subheader\"]");
    public static By CART_QUANTITY= By.xpath("//div[@class='cart_quantity']");
    public static By CHECKOUT_BTN= By.xpath("//a[@class='btn_action checkout_button']");

    public static By FIRST_NAME = By.id("first-name");
    public static By LAST_NAME = By.id("last-name");
    public static By ZIP_CODE = By.id("postal-code");
    public static By CONTINUE_BTN  = By.xpath("//input[@class='btn_primary cart_button']");

    public static By TOTAL_LABEL = By.xpath("//*[@class='summary_subtotal_label']");
    public static By TAX = By.xpath("//*[@class='summary_tax_label']");
    public static By TOTAL = By.xpath("//*[@class='summary_total_label']");
    public static By FINISH_BTN = By.xpath("//*[@class=\"btn_action cart_button\"]");

}