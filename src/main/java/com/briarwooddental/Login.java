package com.briarwooddental;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    public void userLogin(WebDriver driver, WebDriverWait wait) {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("txtUserName")));
        driver.findElement(By.id("txtUserName")).sendKeys(new CharSequence[]{"username"});
        driver.findElement(By.id("txtPassword")).sendKeys(new CharSequence[]{"password"});
        driver.findElement(By.cssSelector("a[href = '#']")).click();
    }

}
