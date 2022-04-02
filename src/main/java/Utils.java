import com.google.gson.*;
import org.testng.Assert;
import java.util.*;

public class Utils {

    public void validateRequestPayload(JsonArray jsonArray, String product, Optional<String> expectedURL) {
        for (JsonElement je : jsonArray) {
            int kind = je.getAsJsonObject().get("Kind").getAsInt();
            Gson gson = new Gson();
            ArrayList args = gson.fromJson(je.getAsJsonObject().get("Args").getAsJsonArray(), ArrayList.class);
            switch (kind) {
                case 63: {
                    if(args.get(0).toString().equalsIgnoreCase("POST"))
                        Assert.assertTrue(args.get(1).toString().contains("rs.fullstory.com/rec/bundle?OrgId"));
                    break;
                }
                case 48: {
                    if(args.get(0).toString().equalsIgnoreCase("console")){
                        Assert.assertEquals(args.get(1).toString(), "log");
                        System.out.println(args.get(2).toString());
                        if(expectedURL.isPresent() && !args.get(2).toString().contains(product)){
                           String [] str = expectedURL.get().split("/");
                           Assert.assertTrue(args.get(2).toString().contains(str[str.length - 1]));
                        }
                        else
                            Assert.assertTrue(args.get(2).toString().contains(product));
                    }
                    break;
                }
                case 37: {
                    if(args.get(0).toString().contains("https://fruitshoppe") && expectedURL.isPresent())
                        Assert.assertEquals(args.get(0).toString(), expectedURL.get());
                    break;
                }
                case 8197: {
                    if(args.get(0).toString().equalsIgnoreCase("Product Added"))
                        Assert.assertTrue(args.get(1).toString().contains(product.toLowerCase()));
                    break;
                }
            }
        }
    }
}
