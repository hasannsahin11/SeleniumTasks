package technostudyB7.day8;

import Utilities.UtilityClass;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindElementsExample extends UtilityClass {
    public static void main(String[] args) {
        /**
         * 1- Go to https://www.saucedemo.com/
         * 2- login with valid credentials
         * 3- Click on Sauce Labs Backpack and add to the cart
         * 4- Click on Back To Products
         * 5- Click on Sauce Labs Bolt T-Shirt and add to the cart
         * 6- Click on the cart
         * 7- Click on the Check Out button
         * 8- Fill the form and click on Continue
         * 9- Check if you see your products
         */

        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginButton.click();

        WebElement product1 = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String product1Str = product1.getText();
        product1.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
        addToCartButton.click();

        driver.navigate().back();

        WebElement product2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")); //We located the element with its text
        String product2Str = product2.getText();
        product2.click();

        WebElement addToCartButton2 = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCartButton2.click();

        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();

        WebElement checkOutButton = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));
        checkOutButton.click();

        WebElement customerName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        customerName.sendKeys("John");

        WebElement customerLastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        customerLastName.sendKeys("Snow");

        WebElement zipCode = driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']"));
        zipCode.sendKeys("548965");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();

        List<WebElement> inventory_item_name = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        System.out.println(inventory_item_name.get(0).getText().equals(product1Str));
        System.out.println(inventory_item_name.get(1).getText().equals(product2Str));

        quitDriver(4);

    }
}

