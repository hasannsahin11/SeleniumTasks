package technostudyB7.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoreNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.seleniumeasy.com/");
        System.out.println("Title of seleniumeasy page = " + driver.getTitle());
        String expectedTitle = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Verification is done: PASS");
            System.out.println("Actual title = " + actualTitle);
        } else {
            System.out.println("Verification is FAILED");
            System.out.println("Actual title = " + actualTitle);
        }

        Thread.sleep(3000);
        String teslaUrl = "https://www.tesla.com/";
        driver.navigate().to(teslaUrl);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        driver.close(); // close only one page
        driver.quit(); // close all the page
    }
}

