package technostudyB7.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        //Test Case
        //Click for JS Alert
        //
        //


        //<button onclick="jsAlert()">Click for JS Alert</button>
        WebElement jsAlert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        jsAlert.click();

        // it will give me the text of the Alert message
        String jsAlertText = driver.switchTo().alert().getText();
        System.out.println(jsAlertText);

        //it will click on OK button
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        //<button onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement jsConfirm = driver.findElement(By.cssSelector("button[onclick ='jsConfirm()']"));
        jsConfirm.click();

        String textJsConfirm = driver.switchTo().alert().getText();
        System.out.println(textJsConfirm);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        ///<button onclick="jsPrompt()">Click for JS Prompt</button>/
        WebElement jsPrompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        jsPrompt.click();

        driver.switchTo().alert().sendKeys("Hasan Sahin");
        driver.switchTo().alert().accept();

        driver.quit();

    }
}
