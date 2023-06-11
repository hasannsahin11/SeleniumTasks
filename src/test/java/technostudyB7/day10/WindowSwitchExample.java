package technostudyB7.day10;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class WindowSwitchExample extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://www.selenium.dev/");

        String mainTabId = driver.getWindowHandle();

        List<WebElement> newTabLinks = driver.findElements(By.cssSelector("a[target='_blank']"));


        for (WebElement link : newTabLinks) {
            if (!link.getAttribute("href").contains("mailto")) {
                link.click();
            }
        }
        Set<String> idList = driver.getWindowHandles();

        for (String id : idList) {
            if (!id.equals(mainTabId)) {
                driver.switchTo().window(id);
                System.out.println(driver.getTitle());
                driver.close();
            }
            Wait(1);
        }
        driver.switchTo().window(mainTabId);
        System.out.println(driver.getTitle());

        driver.quit();

    }
}
