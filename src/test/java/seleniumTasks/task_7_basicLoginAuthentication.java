package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_7_basicLoginAuthentication {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open a chrome browser
         *2-Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
         *3-Verify title equals:
         *Expected: Web Orders Login
         *4-Enter username: “Tester”
         *5-Enter password: “test”
         *6-Click “Sign In” button
         *7-Verify title equals:
         *Expected: Web Orders
         * */

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        if (driver.getTitle().equals("Web Orders Login")) {
            // <input name="ctl00$MainContent$username" type="text" id="ctl00_MainContent_username" class="txt" style="width:142px">
            WebElement userNameBox = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']"));
            userNameBox.sendKeys("Tester");
            // <input name="ctl00$MainContent$password" type="password" id="ctl00_MainContent_password" class="txt" style="width:142px">
            WebElement passwordBox = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$password']"));
            passwordBox.sendKeys("test");
            // <input type="submit" name="ctl00$MainContent$login_button" value="Login" id="ctl00_MainContent_login_button" class="button">
            WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
            loginButton.click();
        }
        if (driver.getTitle().equals("Web Orders")) {
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();
    }

}


