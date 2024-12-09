/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.luans1mple.selenium.guru99;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author thanh
 */
public class Guru99Test {
    private static WebDriver myBrowser;
    @BeforeAll // khởi động app để test
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        myBrowser = new ChromeDriver();// có thể dùng thêm chrome option
        myBrowser.get("htts://google.com");
        myBrowser.manage().window().maximize();
    }
    @Test
    public void testLoginGivenRightAccountSayHelloUsername() throws InterruptedException{
        myBrowser.get("https://www.youtube.com/");
        Thread.sleep(5000);
    }
    @AfterAll //tắt app sau khi test xong tránh lãng phí
    public static void tearDownClass() {
        myBrowser.quit();
    }
    
}
