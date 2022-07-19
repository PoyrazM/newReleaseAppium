
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Swipe extends AppiumConfig {

    @Test
    public void swipeGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"))
                .getAttribute("focusable"),"true");

        swipeAction(firstImage,"left");

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.Gallery/android.widget.ImageView)[1]"))
                .getAttribute("focusable"),"false");

    }
}
