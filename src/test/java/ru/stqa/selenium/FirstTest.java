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

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.cssSelector("[name = username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name = password]")).sendKeys("admin");
        //driver.findElement(By.cssSelector("[type = submit]")).click();
        WebElement loginButton = driver.findElement(By.cssSelector("[type = submit]"));
        loginButton.click();

        driver.findElement(By.cssSelector("#widget-stats"));
    }
}