package technostudyB7.day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATH {
    public static void main(String[] args) {
        //    "tagName[attribute='value']"  This is cssSelector
        //   //tagName[@attribute='value']" This is relative xpath
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.worldometers.info/world-population/");

        WebElement worldPopulationTitle = driver.findElement(By.xpath("//div[@id='maincounter-wrap']//h1"));
        System.out.println(worldPopulationTitle.getText());

        WebElement worldPopulationCounter = driver.findElement(By.xpath("//span[@class='rts-counter']"));
        System.out.println(worldPopulationCounter.getText());


    }
}
