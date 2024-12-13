package com.luans1mple.selenium.guru99;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BuyingTest {

    private WebDriver myBrowser;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        myBrowser = new ChromeDriver();
        myBrowser.get("https://www.google.com/?hl=vi");
        myBrowser.manage().window().maximize();
    }

    public void loginAsUser() throws InterruptedException {
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginDirect = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginDirect.click();
        WebElement inputUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        inputUsername.sendKeys("tester");
        WebElement inputPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        inputPassword.sendKeys("123");
        WebElement dropdownRole = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(dropdownRole);
        select.selectByIndex(1);
        WebElement loginBtn = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginBtn.click();
        Thread.sleep(1000);
    }
    @Test
    @Order(1)
    public void testBuyingDirectNotLogin() throws InterruptedException {
         this.loginAsUser();  // Đăng nhập trước khi thực hiện mua hàng
       

        WebElement buyBtn = myBrowser.findElement(By.xpath("(//input[@value='Buy'])[4]"));
        buyBtn.click();
        Thread.sleep(1000);

        WebElement cashoutBtn = myBrowser.findElement(By.xpath("(//input[@value='Thanh toán'])[1]"));
        cashoutBtn.click();
        Thread.sleep(1000);

        WebElement historyBtn = myBrowser.findElement(By.xpath("(//a[normalize-space()='History'])[1]"));
        historyBtn.click();
        Thread.sleep(1000);

        WebElement product = myBrowser.findElement(By.xpath("(//td[normalize-space()='Dell G5 15'])[1]"));
        assertEquals("Dell G5 15", product.getText());
    }

    @AfterEach
    public void tearDown() {
        myBrowser.quit();
    }
}
