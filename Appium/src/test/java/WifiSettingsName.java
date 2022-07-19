import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WifiSettingsName extends AppiumConfig {

    @Test
    public void wifiSettings() {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Moon Knight");
        //driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
