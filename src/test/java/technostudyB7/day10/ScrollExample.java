package technostudyB7.day10;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ScrollExample extends UtilityClass {
    public static void main(String[] args) {
        /**
         * Go to https://www.youtube.com/
         * Scroll down until there are at least 300 videos on the page
         * Print the name of 100 videos
         * */

        driver.get("https://www.youtube.com/");
        Wait(3);
        List<WebElement> videoList = driver.findElements(By.cssSelector("yt-formatted-string[id='video-title']"));
        System.out.println(videoList.size());

        while (videoList.size() < 100) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)");
            Wait(3);
            videoList = driver.findElements(By.cssSelector("yt-formatted-string[id='video-title']"));
        }
        System.out.println(videoList.size());
        System.out.println(videoList.get(99).getText());


    }
}
