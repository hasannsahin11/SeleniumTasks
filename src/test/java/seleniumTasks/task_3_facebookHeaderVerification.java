package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_3_facebookHeaderVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2- Go to https://www.facebook.com
         *3- Verify header text is as expected;
         * Expected: “Connect with friends and the world around you on Facebook.”
         * */

        driver.get("https://www.facebook.com");

        // <h2 class="_8eso">Connect with friends and the world around you on Facebook.</h2>
        WebElement actualHeader = driver.findElement(By.className("_8eso"));
        String actualHeader1 =  actualHeader.getText();
        String expectedHeader = "Connect with friends and the world around you on Facebook.";

        if (actualHeader1.equals(expectedHeader)) {
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}

