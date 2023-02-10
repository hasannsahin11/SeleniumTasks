package seleniumTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task_10_etsySearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Test Case
         * 1-Navigate to etsy homepage: "https://www.etsy.com/"
         * 2-Search for “bamboo pen"
         * 3-Verify title starts with "part of the item"
         * 4-Click on "Gifts for Every Valentine" link
         * 5-Read the text of the Header using h1 tag
         * 6-Verify the header equals "Valentine's Day Gifts"
         * 7-Close the browser
         * */

        driver.get("https://www.etsy.com/");

        // <input id="global-enhancements-search-query" data-id="search-query" data-search-input="" type="text" name="search_query" class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input
        //  wt-pr-xs-7
        //  " placeholder="Search for anything" value="" autocomplete="off" autocorrect="off" autocapitalize="off">

        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("bamboo pen" + Keys.ENTER);

        // <span class="wt-display-table-cell wt-text-left-xs">Gifts for Every Valentine</span>
        WebElement giftsForEveryValentineButton = driver.findElement(By.linkText("Gifts for Every Valentine"));
        giftsForEveryValentineButton.click();
        // <h1 class="wt-text-display-01 wt-pb-xs-2 wt-text-black">Valentine's Day Gifts</h1>
        WebElement actualHeader = driver.findElement(By.tagName("h1"));
        String expectedHeader = "Valentine's Day Gifts";

        if (actualHeader.getText().equals(expectedHeader)) {
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAIL");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
