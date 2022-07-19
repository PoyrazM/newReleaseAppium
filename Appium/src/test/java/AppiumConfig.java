import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumConfig {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeSuite
    public void configureAppium() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//mertc//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .build();
        service.start();

        File appDir = new File("src/test/resources");

        File app = new File(appDir,"ApiDemos-debug.apk");


        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 API 31");
        options.setPlatformName("ANDROID");
        options.setApp(app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId()
                        ,"duration",2000));
    }

    public void scrollToEnd(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left" , 100, "top",100, "width",200,"height",200,
                    "direction","down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }

    public void swipeAction(WebElement element,String direction){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId" , ((RemoteWebElement)element).getId(),

                "direction",direction,
                "percent",0.75
        ));
    }

    public void dragAndDropAction(WebElement element,int x,int y){
            ((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                    "elementId" , ((RemoteWebElement)element).getId(),
                    "endX" , x,
                    "endY" , y
            ));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
