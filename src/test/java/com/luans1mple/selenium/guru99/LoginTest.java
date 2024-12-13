/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.luans1mple.selenium.guru99;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author thanh
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    private WebDriver myBrowser;

    @BeforeEach // Mỗi test sẽ khởi tạo trình duyệt riêng
    public void setUp() {
        // Thay đổi trình duyệt tại đây (Chrome hoặc Edge)
        WebDriverManager.chromedriver().setup();
        
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void testLoginAdminCorrectGivenReturnTrue() throws InterruptedException {
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginButton = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        loginUsername.sendKeys("admin1");
        WebElement loginPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        loginPassword.sendKeys("123");
        WebElement loginDropdown = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(loginDropdown);
        select.selectByIndex(0);
        WebElement loginSubmit = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginSubmit.click();
        Thread.sleep(1000);

        WebElement dashboard = myBrowser.findElement(By.xpath("(//a[normalize-space()='Dashboard'])[1]"));
        assertEquals(dashboard.getText(), "Dashboard");
    }

    @Test
    @Order(2)
    public void testLoginUserCorrectGivenReturnTrue() throws InterruptedException {
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginButton = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        loginUsername.sendKeys("tester");
        WebElement loginPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        loginPassword.sendKeys("123");
        WebElement loginDropdown = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(loginDropdown);
        select.selectByIndex(1);
        WebElement loginSubmit = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginSubmit.click();
        Thread.sleep(1000);

        WebElement userName = myBrowser.findElement(By.xpath("(//a[normalize-space()='Dashboard'])[1]"));
        assertEquals(userName.getText(), "Nguyen Duc Luan");
    }
    @Test
    @Order(3)
    public void testLoginAdminIncorrectGivenReturnFail() throws InterruptedException{
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginButton = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        loginUsername.sendKeys("xxx");
        WebElement loginPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        loginPassword.sendKeys("123");
        WebElement loginDropdown = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(loginDropdown);
        select.selectByIndex(0);
        WebElement loginSubmit = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginSubmit.click();
        Thread.sleep(1000);

        WebElement userName = myBrowser.findElement(By.xpath("(//p[@class='error'])[1]"));
        assertEquals(userName.getText(), "Incorrect username or password");
    }
    @Test
    @Order(4)
    public void testLoginUserIncorrectGivenReturnFail() throws InterruptedException{
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginButton = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        loginUsername.sendKeys("xxxzx");
        WebElement loginPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        loginPassword.sendKeys("123");
        WebElement loginDropdown = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(loginDropdown);
        select.selectByIndex(1);
        WebElement loginSubmit = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginSubmit.click();
        Thread.sleep(1000);

        WebElement userName = myBrowser.findElement(By.xpath("(//p[@class='error'])[1]"));
        assertEquals(userName.getText(), "Incorrect username or password");
    }
    @Test
    @Order(5)
    public void testLoginAdminCorrectGivenWrongRoleReturnFail() throws InterruptedException{
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginButton = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        loginUsername.sendKeys("admin1");
        WebElement loginPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        loginPassword.sendKeys("123");
        WebElement loginDropdown = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(loginDropdown);
        select.selectByIndex(1);
        WebElement loginSubmit = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginSubmit.click();
        Thread.sleep(1000);

        WebElement userName = myBrowser.findElement(By.xpath("(//p[@class='error'])[1]"));
        assertEquals(userName.getText(), "Incorrect username or password");
    }
    @Test
    @Order(6)
    public void testLoginUserCorrectGivenWrongRoleReturnFail() throws InterruptedException{
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginButton = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        loginUsername.sendKeys("tester");
        WebElement loginPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        loginPassword.sendKeys("123");
        WebElement loginDropdown = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(loginDropdown);
        select.selectByIndex(0);
        WebElement loginSubmit = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginSubmit.click();
        Thread.sleep(1000);

        WebElement userName = myBrowser.findElement(By.xpath("(//p[@class='error'])[1]"));
        assertEquals(userName.getText(), "Incorrect username or password");
    }
    @Test
    @Order(7)
    public void testLoginAdminRememberAccount() throws InterruptedException{
        myBrowser.get("http://localhost:8080/PRJ_Project_LaptopShop/home");
        Thread.sleep(1000);

        WebElement loginButton = myBrowser.findElement(By.xpath("(//a[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginUsername = myBrowser.findElement(By.xpath("(//input[@id='username'])[1]"));
        loginUsername.sendKeys("admin1");
        WebElement loginPassword = myBrowser.findElement(By.xpath("(//input[@id='password'])[1]"));
        loginPassword.sendKeys("123");
        WebElement loginDropdown = myBrowser.findElement(By.xpath("(//select[@name='role'])[1]"));
        Select select = new Select(loginDropdown);
        select.selectByIndex(0);
        WebElement rememberBtn = myBrowser.findElement(By.xpath("(//input[@name='remember'])[1]"));
        rememberBtn.click();
        WebElement loginSubmit = myBrowser.findElement(By.xpath("(//input[@value='Login'])[1]"));
        loginSubmit.click();
        Thread.sleep(1000);
        WebElement logoutBtn = myBrowser.findElement(By.xpath("(//a[normalize-space()='Log out'])[1]"));
        logoutBtn.click();
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(1000);

        WebElement dashboard = myBrowser.findElement(By.xpath("(//a[normalize-space()='Dashboard'])[1]"));
        assertEquals(dashboard.getText(), "Dashboard");
    }
    @AfterEach // Tắt trình duyệt sau mỗi test
    public void tearDown() {
        myBrowser.quit();
    }
}
