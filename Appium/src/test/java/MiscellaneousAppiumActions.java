import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscellaneousAppiumActions extends AppiumConfig {

    @Test
    public void miscellaneous() {

        // Mac / Linux terminal = adb shell dumpsys window | grep -E 'mCurrentFocus'
        // Windows cmd          = adb shell dumpsys window | find "mCurrentFocus"

        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);

        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        driver.setClipboardText("Moon Knight");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());

        //driver.findElement(AppiumBy.id("android:id/button1")).click();
        //driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

}
