
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends AppiumConfig {

    @Test
    public void dragAndDrop(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        dragAndDropAction(source,617,555);

        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result,"Dropped!");
    }
}
