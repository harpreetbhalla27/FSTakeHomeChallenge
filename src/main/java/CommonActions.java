import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonActions {
    private final WebDriver localWebDriver;

    public CommonActions(WebDriver localWebDriver) {
        this.localWebDriver = localWebDriver;
    }

    public void waitForElementToBeClickable(WebElement myElement) {
        WebDriverWait wait = new WebDriverWait(localWebDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(myElement));
    }

    public void waitForElementVisibility(WebElement myElement) {
        WebDriverWait wait = new WebDriverWait(localWebDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(myElement));
    }

    public void clickElement(WebElement myElement) {
        waitForElementToBeClickable(myElement);
        myElement.click();
    }

    public void wait(int milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
