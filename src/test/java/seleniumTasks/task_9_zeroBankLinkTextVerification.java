package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_9_zeroBankLinkTextVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2-Go to http://zero.webappsecurity.com/login.html
         *3-Verify link text from top left: "Zero Bank"
         *4-Verify link href attribute value contains: "index.html"
         * */

        driver.get("http://zero.webappsecurity.com/login.html");

        //<a href="/index.html" class="brand">Zero Bank</a>
        WebElement link = driver.findElement(By.linkText("Zero Bank"));
        String actualHREF = link.getAttribute("href");
        String expectedHREF = "index.html";

        if (actualHREF.contains(expectedHREF)) {
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();
    }

}

