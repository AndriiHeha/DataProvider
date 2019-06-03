package com.mainacad;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainTest
{
    //Пример DataProvider метода
    @DataProvider
    public Object[] myDataProvider(){
        return new Object[]{
                "Data 1 from my data provider",
                "Data 2 from my data provider",
                "Data 3 from my data provider",
                "Data 4 from my data provider",
                "Data 5 from my data provider"
        };
    }

    //Пример теста с использованием DataProvider
    @Test(dataProvider = "myDataProvider")
    public void testWithDataProvider(String inputData) throws InterruptedException {
        System.out.println("Test received: " + inputData);
        Thread.sleep(1000);
        Assert.assertTrue( true );
    }

    //TODO: Напишите @DataProvider метод
    // метод должен считать данные из файла deviceList.txt и привести их к типу Object[]
    // справка для чтения файла: https://stackoverflow.com/questions/2977075/java-how-to-read-a-txt-file-to-an-array-of-strings

    @DataProvider(name = "aheha-provider")
    public Object[] myFirstDataProvider() throws FileNotFoundException {
        String filename = "deviceList.txt";
        Scanner sc = new Scanner(new File(filename));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        String[] arrayDevices = lines.toArray(new String[0]);
        return arrayDevices;
    }

    //My own test to check DataProvider
        @Test(dataProvider = "aheha-provider")
        public void testMethod(String arrayDevices)
        {
            System.out.println("Device is: " + arrayDevices);
        }

    //TODO: Перепишите тест testGoogleSearch с использованием @DataProvider
    // Тест должен выполнится для каждого девайса из списка в deviceList.txt

    @Test(dataProvider = "aheha-provider")
    public void testGoogleSearch(String arrayDevices) throws InterruptedException {
        //Передаём девайс для эмуляции и создаём драйвер
        //WebDriver driver = Main.getDriver("Nexus 10");
        WebDriver driver = Main.getDriver(arrayDevices);

        driver.get("http://www.google.com/xhtml");
        Thread.sleep(3000);

        WebElement searchBox =driver.findElement(By.name("q"));
        searchBox.sendKeys("automation");
        searchBox.submit();
        Thread.sleep(3000);

        driver.quit();
    }

}
