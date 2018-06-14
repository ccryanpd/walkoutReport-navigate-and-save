package com.briarwooddental;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenDenticon {

    public WebDriver newDenticonWindow () {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\team\\Desktop\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.denticon.com/aspx/home/login.aspx?STO=");
        return driver;
    }
}
