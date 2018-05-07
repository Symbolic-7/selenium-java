package ru.stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends BaseTest {

    @Test
    public void test() {
/*
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("[name = username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name = password]")).sendKeys("admin");
        //driver.findElement(By.cssSelector("[type = submit]")).click();
        WebElement loginButton = driver.findElement(By.cssSelector("[type = submit]"));
        loginButton.click();

        driver.findElement(By.cssSelector("#widget-stats"));
*/
        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));
        String nameMain = driver.findElement(By.cssSelector("#box-campaigns .product a")).getAttribute("title");
        //System.out.println(nameMain);
        String priceMain = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getAttribute("textContent");
        String priceMainTag = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName();
        assertEquals("s", priceMainTag);

        String priceMainColor = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
        //System.out.println(priceMainColor);
        String priceMainColorValue1 = priceMainColor.replace("rgba(", "");
        String priceMainColorValue2 = priceMainColorValue1.replace(")", "");
        System.out.println(priceMainColorValue2);
        String[] colorA = priceMainColorValue2.split(", ");
        assertEquals(colorA[0], colorA[1]);
        assertEquals(colorA[0], colorA[2]);

        String PriceMainFont = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("font-size");
        System.out.println(PriceMainFont);

        String salePriceMain = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getAttribute("textContent");
        String salePriceMainTag = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getTagName();
        assertEquals("strong", salePriceMainTag);
        String salePriceMainColor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
        System.out.println(salePriceMainColor);
        String salePriceMainFont = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-size");
        System.out.println(salePriceMainFont);
        //System.out.println(PriceMainFont < salePriceMainFont);


        driver.findElement(By.cssSelector("#box-campaigns .product a")).click();


        String nameCart = driver.findElement(By.cssSelector("#box-product .title")).getAttribute("textContent");
        String priceCart = driver.findElement(By.cssSelector("#box-product .regular-price")).getAttribute("textContent");
        String priceCartTag = driver.findElement(By.cssSelector("#box-product .regular-price")).getTagName();
        assertEquals("s", priceCartTag);
        String priceCartColor = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("color");
        System.out.println(priceCartColor);
        
        String PriceCartFont = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("font-size");
        System.out.println(PriceCartFont);

        String salePriceCart = driver.findElement(By.cssSelector("#box-product .campaign-price")).getAttribute("textContent");
        String salePriceCartTag = driver.findElement(By.cssSelector("#box-product .campaign-price")).getTagName();
        assertEquals("strong", salePriceCartTag);
        String salePriceCartColor = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("color");
        System.out.println(salePriceCartColor);
        String salePriceCartFont = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("font-size");
        System.out.println(salePriceCartFont);

        assertEquals(nameMain, nameCart);
        assertEquals(priceMain, priceCart);
        assertEquals(salePriceMain, salePriceCart);
        assertNotEquals(PriceMainFont, salePriceMainFont);
        assertNotEquals(PriceCartFont, salePriceCartFont);



    }
}