package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_4_facebookCreateAPageLinkVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2- Go to https://www.facebook.com
         *3- Verify “Create a page” link href value contains text:
         * Expected:“registration_form”
         * */

        driver.get("https://www.facebook.com");

        // <a href="/pages/create/?ref_type=registration_form" class="_8esh">Create a Page</a>
        WebElement element = driver.findElement(By.linkText("Create a Page"));
        String actualHREF = element.getAttribute("href");
        String expectedHREF = "registration_form";

        if (actualHREF.contains(expectedHREF)) {
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();




    }
}
