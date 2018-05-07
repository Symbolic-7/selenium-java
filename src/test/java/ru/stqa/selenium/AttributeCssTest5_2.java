package ru.stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class AttributeCssTest5_2 extends BaseTest {

    @Test
    public void test() {

        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));
//Товар на главной странице
        String nameMain = driver.findElement(By.cssSelector("#box-campaigns .product a")).getAttribute("title");
        String priceMain = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getAttribute("textContent");
        String priceMainTag = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName();
        assertEquals("s", priceMainTag);
//color обычной цены
        String priceMainColor = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
        String priceMainColorValue1 = priceMainColor.replace("rgba(", "");
        String priceMainColorValue2 = priceMainColorValue1.replace(")", "");
        String[] colorGrey = priceMainColorValue2.split(", ");
        assertEquals(colorGrey[0], colorGrey[1]);
        assertEquals(colorGrey[0], colorGrey[2]);
//font обычной цены
        String PriceMainFont = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("font-size");
        String PriceMainFontValue = PriceMainFont.replace("px", "");
        double PriceMainFontValueInt = Double.parseDouble(PriceMainFontValue);

        String salePriceMain = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getAttribute("textContent");
        String salePriceMainTag = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getTagName();
        assertEquals("strong", salePriceMainTag);
//color распродажной цены
        String salePriceMainColor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
        String salePriceMainColorValue1 = salePriceMainColor.replace("rgba(", "");
        String salePriceMainColorValue2 = salePriceMainColorValue1.replace(")", "");
        String[] colorRed = salePriceMainColorValue2.split(", ");
        assertEquals(colorRed[1], colorRed[2]);
        assertNotEquals(colorRed[0], colorRed[1]);
//font распродажной цены
        String salePriceMainFont = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-size");
        String salePriceMainFontValue = salePriceMainFont.replace("px", "");
        double salePriceMainFontValueInt = Double.parseDouble(salePriceMainFontValue);


        driver.findElement(By.cssSelector("#box-campaigns .product a")).click();

//Карточка товара
        String nameCart = driver.findElement(By.cssSelector("#box-product .title")).getAttribute("textContent");
        String priceCart = driver.findElement(By.cssSelector("#box-product .regular-price")).getAttribute("textContent");
        String priceCartTag = driver.findElement(By.cssSelector("#box-product .regular-price")).getTagName();
        assertEquals("s", priceCartTag);
//color обычной цены
        String priceCartColor = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("color");
        String priceCartColorValue1 = priceCartColor.replace("rgba(", "");
        String priceCartColorValue2 = priceCartColorValue1.replace(")", "");
        String[] colorGrey2 = priceCartColorValue2.split(", ");
        assertEquals(colorGrey2[0], colorGrey2[1]);
        assertEquals(colorGrey2[0], colorGrey2[2]);
//font обычной цены
        String PriceCartFont = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("font-size");
        String PriceCartFontValue = PriceCartFont.replace("px", "");
        double PriceCartFontValueInt = Double.parseDouble(PriceCartFontValue);


        String salePriceCart = driver.findElement(By.cssSelector("#box-product .campaign-price")).getAttribute("textContent");
        String salePriceCartTag = driver.findElement(By.cssSelector("#box-product .campaign-price")).getTagName();
        assertEquals("strong", salePriceCartTag);
//color распродажной цены
        String salePriceCartColor = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("color");
        String salePriceCartColorValue1 = salePriceCartColor.replace("rgba(", "");
        String salePriceCartColorValue2 = salePriceCartColorValue1.replace(")", "");
        String[] colorRed2 = salePriceCartColorValue2.split(", ");
        assertEquals(colorRed2[1], colorRed2[2]);
        assertNotEquals(colorRed2[0], colorRed2[1]);
//font распродажной цены
        String salePriceCartFont = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("font-size");
        String salePriceCartFontValue = salePriceCartFont.replace("px", "");
        double salePriceCartFontValueInt = Double.parseDouble(salePriceCartFontValue);

//other asserts
        assertEquals(nameMain, nameCart);
        assertEquals(priceMain, priceCart);
        assertEquals(salePriceMain, salePriceCart);
        assertNotEquals(PriceMainFont, salePriceMainFont);
        assertNotEquals(PriceCartFont, salePriceCartFont);
        assert PriceMainFontValueInt<=salePriceMainFontValueInt;
        assert PriceCartFontValueInt<=salePriceCartFontValueInt;

    }
}
