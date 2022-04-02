import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private DriverFactory(){};

    public static ChromeDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
