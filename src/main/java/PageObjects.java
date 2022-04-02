import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {

    private WebDriver localWebDriver;
    private CommonActions commonActions;

    public PageObjects(WebDriver webDriver) {
        localWebDriver = webDriver;
        commonActions = new CommonActions(localWebDriver);
        PageFactory.initElements(localWebDriver, this);
    }


    final String URL = "https://fruitshoppe.firebaseapp.com";
    final String MARKET = "https://fruitshoppe.firebaseapp.com/#/market";
    final String CART = "https://fruitshoppe.firebaseapp.com/#/cart";


    @FindBy(xpath = "//a[contains(text(),'Mangocados')]")
    private WebElement mangocados;

    @FindBy(xpath = "//div[@class='fruit-box fruit-banans']//child::a[text()='Add to cart']")
    private WebElement bananas;

    @FindBy(xpath = "//div[@class='fruit-box fruit-bluebs']//child::a[text()='Add to cart']")
    private WebElement bluebs;

    @FindBy(xpath = "//*[text()='My Cart']")
    private WebElement myCart;

    public PageObjects addMangocados() {
        commonActions.waitForElementToBeClickable(mangocados);
        commonActions.clickElement(mangocados);
        return this;
    }
    public PageObjects addBananas() {
        commonActions.waitForElementToBeClickable(bananas);
        commonActions.clickElement(bananas);
        return this;
    }
    public PageObjects addBluebs() {
        commonActions.waitForElementToBeClickable(bluebs);
        commonActions.clickElement(bluebs);
        return this;
    }
    public PageObjects gotoMyCart() {
        commonActions.waitForElementToBeClickable(myCart);
        commonActions.clickElement(myCart);
        return this;
    }
}
