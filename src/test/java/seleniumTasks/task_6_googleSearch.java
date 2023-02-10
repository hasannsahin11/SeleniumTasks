package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_6_googleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         *1-Open Chrome Browser
         *2-Go to https://www.google.com
         *3-Write "apple" in search box
         *4-Click google search button (or press enter)
         *5-Verify title:
         * Expected: Title should start with "apple" word
         * */

        driver.get("https://www.google.com");

        // <input class="gLFyf" jsaction="paste:puy29d;" maxlength="2048" name="q"
        // type="text" aria-autocomplete="both" aria-haspopup="false" autocapitalize="off"
        // autocomplete="off" autocorrect="off" autofocus="" role="combobox" spellcheck="false"
        // title="Search" value="" aria-label="Search" data-ved="0ahUKEwi0refVp4r9AhVjkGoFHeNWDTMQ39UDCAY">

        WebElement searchBox = driver.findElement(By.cssSelector("input[class='gLFyf']"));
        searchBox.sendKeys("apple" + Keys.ENTER);

        if (driver.getTitle().substring(0, 5).equals("apple")) {
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.quit();


    }
}
