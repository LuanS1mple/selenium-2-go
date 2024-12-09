/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.luans1mple.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author thanh
 */
public class Selenium2Go {

    public static void main(String[] args) throws InterruptedException {
        searchGoogleV2();
    }

    public static void searchGoogleV2() throws InterruptedException {
        //1. Khai báo biến đại diện cho chrome
        WebDriverManager.chromedriver().setup();

        // Khởi tạo trình duyệt
        ChromeOptions opt = new ChromeOptions();
        //chế độ ẩn danh
        opt.addArguments("--incognito");
        //đổi ngôn ngữ
        opt.addArguments("--lang=vi");
        WebDriver driver = new ChromeDriver(opt);

        // Điều hướng tới một trang web
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("GET GO");
        searchBox.submit();
        Thread.sleep(3000); // app nghỉ 3s trước khi quit
        driver.quit();//câu này để kill process không bị leak ram
    }

    public static void searchGoogle() {
        //1. Khai báo biến đại diện cho chrome
        WebDriver myBrowser;// biến object thuộc bộ thư viện Selenium, nó sẽ trỏ đến trình duyệt khi được new
        //mỗi lần new là 1 lần mở trình duyệt
        //1 object trình duyệt đc new trong heap
        //2, Khai báo gã điều khiển trình duyệt , tương thích với trình duyệt đang dùng
        String driverPath = "C:\\Users\\thanh\\Downloads\\SP2025\\SWT\\Project\\selenium-2-go\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        //giair thich: báo với máy ảo java rằng có 1 thằng .exe sẽ tham gia vào danh sách class mà JVM quản lí
        //Nó (Dll,Exe) sẽ xả 1 đống class vào JVM 
        //gọi nhóm class này và webdriver.chrome.driver -> quy ước rồi
        //code selenium qua class webdriver,chrome driver ở dưới
        //biết cách chơi với class của .exe vừa rồi,vì chúng đang ở chung máy ảo
        //3, Mở trình duyệt đẻ gắn kết với driver chrome
        //thêm các options
        ChromeOptions opt = new ChromeOptions();
        //chế độ ẩn danh
        opt.addArguments("--incognito");
        //đổi ngôn ngữ
        opt.addArguments("--lang=vi");
        myBrowser = new ChromeDriver(opt);
        myBrowser.manage().window().maximize();
        //4. viết code selenium để nói chuyện với driver, driver sẽ nói với chrome đã new
        // trình duyệt thông qua driver đưa hết data cho mình dưới dạng cây DOM- Document Object Model
        // cây object của HTML  
        //node/tag được xem là Object trong WebElement
        myBrowser.get("https://www.google.com");
        // Đợi vài giây để trình duyệt tải (không bắt buộc)
        // nếu tắt mà không kill ChromeDriver, nó sẽ tồn tại trong ram -> leak memory gây lãng phí

        //Các thẻ đều là thành phần của webelement
        //ta có thể lấy và điều khiển thẻ dó
        //vd
        WebElement searchBox = myBrowser.findElement(By.id("q"));
        searchBox.sendKeys("GET GO");
        searchBox.submit();
        myBrowser.quit();
        //bên trên là ví dụ tìm kiếm
    }
}
