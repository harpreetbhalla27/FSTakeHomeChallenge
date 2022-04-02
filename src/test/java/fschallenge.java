import com.google.gson.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.testng.annotations.*;
import java.util.Optional;

public class fschallenge {

    CommonActions commonActions;
    Utils utils;
    PageObjects pageObjects;

    private static ChromeDriver driver;
    private DevTools chromeDevTools;
    private JsonArray jsonArray;


    @BeforeTest
    public void initialiseClass(){
        driver = DriverFactory.getDriver();
        pageObjects = new PageObjects(driver);
        commonActions = new CommonActions(driver);
        utils = new Utils();
    }

    @BeforeTest
    public void setup() {

        // Using chromeDevTools to capture Network Traffic from Chrome Browser

        chromeDevTools = driver.getDevTools();
        chromeDevTools.createSession();
        chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        chromeDevTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    Request request = entry.getRequest();
                    Optional<String> postData = request.getPostData();
                    postData.ifPresent(p -> {
                        jsonArray = JsonParser.parseString(p).getAsJsonObject().getAsJsonArray("Evts");
                    });
                });
        driver.get(pageObjects.URL);
    }

    /* Scenario - Add 3 items and go to my Cart page - Verify the correct data is being captrured and sent to FS
            1. Add One first item from Home Page - Mangocadoes
            2. Verify that the request is made to FS server using bundle/ endpoint
            3. Verify that the request payload has correct data. For eg. - Mangocadoes added to cart,
            4. Verify that the next page's address is also captured and sent (if any on click action )
            5. Add Two From Market Page - Bananas & Bulebs
            6. Verify steps 2 to 4 for Bananas and Bulebs
            7. Go to Cart via clicking on My Cart Button
            8. Verify that the request is made to FS server using bundle/ endpoint
            9. Verify that the request payload has data captured for user being on Cart page, and the URL of Cart Page
     */

    @Test
    public void test() throws InterruptedException {

        pageObjects.addMangocados();
        commonActions.wait(5000);
        utils.validateRequestPayload(jsonArray,"Mangocados", Optional.of(pageObjects.MARKET));
        pageObjects.addBananas();
        commonActions.wait(5000);
        utils.validateRequestPayload(jsonArray,"Bananas", Optional.empty());
        pageObjects.addBluebs();
        commonActions.wait(5000);
        utils.validateRequestPayload(jsonArray,"Bluebs", Optional.empty());
        pageObjects.gotoMyCart();
        commonActions.wait(5000);
        utils.validateRequestPayload(jsonArray,"cart", Optional.of(pageObjects.CART));
        commonActions.wait(5000);
    }

    @AfterTest
    public void tearDown(){
        chromeDevTools.send(Network.disable());
        driver.close();
        driver.quit();
    }
}
