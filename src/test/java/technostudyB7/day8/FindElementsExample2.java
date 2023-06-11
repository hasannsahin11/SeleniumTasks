package technostudyB7.day8;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindElementsExample2 extends UtilityClass {
    /**
     * 1- Go to https://www.saucedemo.com/
     * 2- login with valid credentials
     * 3- Add 3 random products to the cart
     * 4- Click on the cart
     * 5- Click on the Check Out button
     * 6- Fill the form and click on Continue
     * 7- Check if you see your products
     */


    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginButton.click();

        List<WebElement> inventoryItems;
        List<String> inventoryItemsNames = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        //TODO: complete and explain this part
        while (inventoryItemsNames.size()<3){
            inventoryItems = driver.findElements(By.cssSelector(".inventory_item_name"));
            int randomIndex = (int)(Math.random()*inventoryItems.size());

            if (indexList.contains(randomIndex)){
                continue;
            }
            indexList.add(randomIndex);
            inventoryItemsNames.add(inventoryItems.get(randomIndex).getText());
            inventoryItems.get(randomIndex).click();
            WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
            addToCartButton.click();
            driver.navigate().back();
        }

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        cartIcon.click();

        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();

        WebElement nameInput = driver.findElement(By.id("first-name"));
        nameInput.sendKeys("John");

        WebElement lastNameBar = driver.findElement(By.id("last-name"));
        lastNameBar.sendKeys("Snow");

        WebElement zipCode=driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("44444");

        WebElement continuee=driver.findElement(By.id("continue"));
        continuee.click();

        List<WebElement> checkOutItemsList = driver.findElements(By.className("inventory_item_name"));

        for (WebElement product: checkOutItemsList){
            System.out.println(inventoryItemsNames.contains(product.getText()));
        }

        driver.quit();
    }
}
