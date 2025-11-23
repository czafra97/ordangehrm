package com.orangehrm.qa.utils;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ConfiguradorDriverUtil implements DriverSource {

    @Override
    public WebDriver newDriver() {
        Map<String, Object> prefs = new HashMap<>(); //preferencias
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("profile.managed_default_content_settings.popups", 0);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("profile.default_content_setting_values.notifications", 2);


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments(
                "--start-maximized",
                "--test-type",
                "--no-sandbox",
                "--disable-popup-blocking",
                "--disable-infobars",
                "--disable-geolocation",
                "--disable-notifications",
                "--incognito");
        ChromeDriver driver = new ChromeDriver(options);

        // Configurar los timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}

