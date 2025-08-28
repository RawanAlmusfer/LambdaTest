package com.lambdatest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public static WebDriver driver;
    WebDriverWait wait;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void setWait(WebDriverWait wait) {
        BasePage.wait = wait;
    }

    public WebElement find(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(By locator){
        find(locator).click();
    }

    public String getText(By locator){
        String text = find(locator).getText();
        System.out.println("Text: " + text);
        return text;
    }
}
