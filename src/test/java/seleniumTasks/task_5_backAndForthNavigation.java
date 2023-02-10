package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_5_backAndForthNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2- Go to https://www.google.com
         *3- Click to Gmail from top right
         *4- Verify title contains:
         * Expected: Gmail
         * */

        driver.get("https://www.google.com");

        //  <a class="gb_p" aria-label="Gmail" data-pid="23"
        //  href="https://mail.google.com/mail/&amp;ogbl" target="_top">Gmail</a>
        WebElement gmailButton = driver.findElement(By.className("gb_p"));
        gmailButton.click();
        if (driver.getTitle().contains("Gmail")){
            System.out.println("Title contains: Gmail");
        }
        driver.navigate().back();
        if (driver.getTitle().equals("Google"));
        System.out.println("Title equals: Google");

        Thread.sleep(2000);
        driver.quit();
    }
}
