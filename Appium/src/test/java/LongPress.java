
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends AppiumConfig {

    @Test
    public void longPressGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement peopleNamesTxt = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(peopleNamesTxt);

        String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());

    }

}
