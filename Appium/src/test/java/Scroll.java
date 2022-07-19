
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Scroll extends AppiumConfig {

    @Test
    public void scrollGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();

        //scrollToEnd();






































    }

}
