import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Rail_Sheba_App {

    static AppiumDriver driver;

    public static void openMobileApp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Nova 2i");
        cap.setCapability("udid", "8UEDU17B27010268");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.0.0");
        cap.setCapability("automationName", "uiAutomator2");
        cap.setCapability("appPackage", "com.shohoz.dtrainpwa");
        cap.setCapability("appActivity", "com.shohoz.dtrainpwa.LauncherActivity");
        //cap.setCapability("noReset", true); // Prevents clearing of app data
        //cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //login
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"LOGIN\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")).sendKeys("01725028366");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")).sendKeys("valid_password");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"LOGIN\")")).click();

         /* //validation
            WebElement successElement = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Rail Sheba\")"));
            if (successElement.isDisplayed()) {
                System.out.println("Login successful.");
            }
          */

        //Search Train
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"I AGREE\")")).click();
        //From station
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Select Station\").instance(0)")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")")).sendKeys("Dhaka");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(23)")).click();
        //To station
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Select Station\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")")).sendKeys("Rajshahi");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(23)")).click();
        //select class
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Select Class\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"S_CHAIR\")")).click();
        //select date
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Select Date\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(5)")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"4\")")).click();
        //click search
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"SEARCH TRAINS\")")).click();

        //Scroll and Select Train
        Thread.sleep(3000);
        WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"BOOK NOW\").instance(3))"));
        element.click();
        //Scroll and Select Seat & Continue
        Thread.sleep(3000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"KA-51\"))")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"CONTINUE PURCHASE\")")).click();


        System.out.println("Application Started");
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        openMobileApp();
    }
}
