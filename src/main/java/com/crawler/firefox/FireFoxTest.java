package com.crawler.firefox;

import com.crawler.common.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:crawler
 * @Author: old
 * @CreateTime:2017-11-15 :15:26:26
 */
public class FireFoxTest {

    public static void main(String[] args) {
        WebDriver webDriver = null;
        try {
            webDriver = WebDriverUtil.createFirefoxWebDriver("D:\\webdrvier\\Firefox\\geckodriver_18.exe");
            webDriver.get("https://book.douban.com/tag/");
            Set<String> tagSet = new HashSet<>();
            //获取豆瓣标签
            List<WebElement> divWebElement = webDriver.findElements(By.cssSelector("#content > div > div.article > div:nth-child(2) > div"));
            for (WebElement webElement : divWebElement) {
                List<WebElement> aWebElement = webElement.findElements(By.cssSelector("a"));
                for (WebElement element : aWebElement) {
                    tagSet.add(element.getText());
                }
            }
            System.out.println(tagSet);
            //点击小说标签
            WebElement webElement = webDriver.findElement(By.cssSelector("#content > div > div.article > div:nth-child(2) > div:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(1) > a"));
            webElement.click();
            System.out.println(webDriver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (webDriver != null) {
                webDriver.quit();
                webDriver.close();
            }
        }
    }

}
