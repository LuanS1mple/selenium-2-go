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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        myBrowser.get("https://demo.guru99.com/V1/index.php");
        //Tìm thẻ cần thao tác trên đó (Ghi trong note)
        //đưa câu QUery XPath cho myBrowser, nếu tìm thấy thẻ thì đó là 1 object trả về thuộc WebElement
        WebElement userTag = myBrowser.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        userTag.sendKeys("mngr603705"); //gõ vào text
        WebElement passTag = myBrowser.findElement(By.xpath("(//input[@name='password'])[1]"));
        passTag.sendKeys("EtEmAme");
        WebElement loginTag = myBrowser.findElement(By.xpath("(//input[@name='btnLogin'])[1]"));
        loginTag.submit();
        Thread.sleep(3000);
        WebElement helloTag= myBrowser.findElement(By.xpath("(//marquee[@class='heading3'])[1]"));
        System.out.println(helloTag.getText());
        //Lấy text của 1 thẻ là .getText();
        assertEquals("Welcome To Manager's Page of GTPL Bank", helloTag.getText());
        //đây là kết hợp Junit và selenium
        Thread.sleep(5000);
        
    }
    @AfterAll //tắt app sau khi test xong tránh lãng phí
    public static void tearDownClass() {
        myBrowser.quit();
    }
    
}
