package mentoringClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TutorialsNinja {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tutorialsninja.com/demo/");

        WebElement laptopsAndDesktops = driver.findElement(By.linkText("Laptops & Notebooks"));
        laptopsAndDesktops.click();

        WebElement showAllComputers = driver.findElement(By.linkText("Show All Laptops & Notebooks"));
        showAllComputers.click();

        WebElement sortButton = driver.findElement(By.id("input-sort"));

        Select sortButtonSelect = new Select(sortButton);

        sortButtonSelect.selectByVisibleText("Price (Low > High)");

        WebElement secondProduct = driver.findElement(By.linkText("MacBook"));
        secondProduct.click();

        WebElement addToCartButton = driver.findElement(By.id("button-cart"));
        addToCartButton.click();



        //<div class="alert alert-success alert-dismissible">Success: You have added <a
        // href="http://tutorialsninja.com/demo/index.php?route=product/product&amp;product_id=43">MacBook</a> to your <a
        // href="http://tutorialsninja.com/demo/index.php?route=checkout/cart">shopping cart</a>!<button type="button" class="close"
        // data-dismiss="alert">×</button></div>
        WebElement successMessage = driver.findElement(By.cssSelector("div[id='product-product']>div"));
        System.out.println(successMessage.getText());
        //System.out.println(successMessage.getText().contains("Success"));
    }
}
