package com.mainacad;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static WebDriver getDriver(String deviceName) {

        //Устанавливаем имя эмулируемого девайса - deviceName
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", deviceName);

        //Создаём настройки хрома в соответствии с заданным девайсом
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        //Создаём драйвер с заданными настройками - options
        //Create a Chrome driver. All test classes use this.
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver(options);
    }
}
