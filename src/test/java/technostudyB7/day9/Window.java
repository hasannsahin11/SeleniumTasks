package technostudyB7.day9;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Window extends UtilityClass {
    public static void main(String[] args) {
        /**
         * Go to https://www.selenium.dev/
         * Click on Register now
         * Print the title of the new page
         */
        driver.get("https://www.selenium.dev/");

        String mainPageId = driver.getWindowHandle(); // we are getting the id of the active window

        WebElement registerNowButton = driver.findElement(By.xpath("//a[text()='Get Tickets']"));
        registerNowButton.click();

        Set<String> allIds = driver.getWindowHandles();

        for (String id : allIds) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }

        System.out.println(driver.getTitle());

        driver.close();  // We close the active window(Register)

        //After we closed the active window
        driver.switchTo().window(mainPageId);
        System.out.println(driver.getTitle());
    }
}
