package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_8_zeroBankHeaderVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2-Go to http://zero.webappsecurity.com/login.html
         *3-Verify header text: "Log in to ZeroBank"
         * */

        driver.get("http://zero.webappsecurity.com/login.html");

        // <h3>Log in to ZeroBank</h3>
        WebElement actualHeader = driver.findElement(By.tagName("h3"));
        String expectedHeader = "Log in to ZeroBank";

        if (expectedHeader.equals(actualHeader.getText())) {
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
