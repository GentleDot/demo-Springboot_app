package net.gentledot.readinglist;/**
 * Created by Sang on 2017-04-27.
 */

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

import net.gentledot.DemoApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerWebTests {

    private static FirefoxDriver browser;

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser(){
        browser = new FirefoxDriver(); // FirefoxDriver 설정
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser(){
        browser.quit(); // 웹브라우저 종료
    }

    @Test
    public void addBookToEmptyList(){
        String baseUrl = "http://localhost:8080";
        browser.get(baseUrl); // 메인 페이지 조회

        assertEquals("You have no books in your book list", browser.findElementByTagName("p").getText()); // 빈 책 목록 검증

        browser.findElementByName("title").sendKeys("BOOK TITLE");
        browser.findElementByName("author").sendKeys("BOOK AUTHOR");
        browser.findElementByName("isbn").sendKeys("1234567890");
        browser.findElementByName("description").sendKeys("DESCRIPTION");
        browser.findElementByTagName("form").submit(); // 폼에 데이터를 추가하고 전송

        WebElement dl = browser.findElementByCssSelector("dt.bookHeadline > p");
        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN : 1234567890)", dl.getText());

        WebElement dt = browser.findElementByCssSelector("dd.bookDescription");
        assertEquals("DESCRIPTION", dt.getText()); // 목록에 새 책이 있는지 검증

    }
}