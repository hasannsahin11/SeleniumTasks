package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_1_facebookTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2- Go to https://www.facebook.com
         *3- Verify Title
         * */

        driver.get("https://www.facebook.com");

        //        <title id="pageTitle">Facebook - log in or sign up</title>
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
