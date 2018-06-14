package com.briarwooddental;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class AutoSurf {

    public void surf(String patientEmail) throws InterruptedException, AWTException{
        System.setProperty("java.awt.headless", "false");
        OpenDenticon openDenticon = new OpenDenticon();
        WebDriver driver = openDenticon.newDenticonWindow();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Login login = new Login();
        login.userLogin(driver, wait);
        searchByPatientEmail(driver, wait, patientEmail);
        accessReceipt(driver, wait);
        saveReceiptToDesktopRobot();
        driver.close();
    }

    private void searchByPatientEmail (WebDriver driver, WebDriverWait wait, String patientEmail) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSearch")));
        driver.findElement(By.id("rdoEmail")).click();
        driver.findElement(By.id("txtSearchText")).sendKeys(new CharSequence[]{patientEmail});
        driver.findElement(By.id("btnSearch")).click();
    }

    private void accessReceipt (WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lblPatName")));
        driver.findElement(By.id("MenuBar_aMenuPrint")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[onclick = 'menuProcessReports(1)']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id = 'btnWOReport']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void saveReceiptToDesktopRobot() throws InterruptedException, AWTException{
        Robot bot = new Robot();
        bot.mouseMove(608, 645);
        Thread.sleep(6000);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
        bot.mouseMove(608, 690);
        Thread.sleep(6000);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(6000);
        bot.keyPress(KeyEvent.VK_R);
        bot.keyPress(KeyEvent.VK_C);
        bot.keyPress(KeyEvent.VK_T);
        bot.keyPress(KeyEvent.VK_ENTER);
        bot.mouseMove(1100, 600);
    }
}


