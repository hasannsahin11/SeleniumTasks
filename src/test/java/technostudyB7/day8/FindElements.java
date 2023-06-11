package technostudyB7.day8;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://www.youtube.com/");
        List<WebElement> videoTitles =  driver.findElements(By.id("video-title"));
        System.out.println(videoTitles.get(10).getText());
    }
}
