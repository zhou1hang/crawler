package com.crawler.chrome;

import com.crawler.common.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * @Description:crawler
 * @Author: old
 * @CreateTime:2017-11-15 :15:23:23
 */
public class ChromeTest {

    public static void main(String[] args) {
        WebDriver webDriver = null;
        try {
            webDriver = WebDriverUtil.createChromeWebDriver("D:\\webdrvier\\chromedriver.exe");
            webDriver.get("https://www.baidu.com/");
            System.out.println(webDriver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (webDriver != null) {
                webDriver.close();
            }
        }
    }


}
