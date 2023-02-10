package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_2_facebookIncorrectLoginTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2- Go to https://www.facebook.com
         *3- Enter incorrect username
         *4- Enter incorrect password
         *5- Verify title changed to: "Log into Facebook"
         * */

        driver.get("https://www.facebook.com");
        //<input type="text" class="inputtext _55r1 _6luy" name="email" id="email"
        // data-testid="royal_email" placeholder="Email or phone number" autofocus="1"
        // aria-label="Email or phone number">
        WebElement userNameBox = driver.findElement(By.cssSelector("input[type='text']"));
        userNameBox.sendKeys("randomuserrr");

        //<input type="password" class="inputtext _55r1 _6luy _9npi" name="pass"
        // id="pass" data-testid="royal_pass" placeholder="Password" aria-label="Password">
        WebElement passwordBox = driver.findElement(By.cssSelector("input[type='password']"));
        passwordBox.sendKeys("incorrectPassword" + Keys.ENTER);

        Thread.sleep(3000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Log into Facebook";

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
