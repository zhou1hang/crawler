package com.crawler.common.util;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * @Description:crawler
 * @Author: old
 * @CreateTime:2017-11-15 :15:16:16
 */
public class WebDriverUtil {


    /**
     * 创建 Phantomjs
     *
     * @param path 路径
     * @return
     * @throws Exception
     */
    public static WebDriver createPhantomjsWebDriver(String path) throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
        if (path == null || "".equals(path)) {
            throw new Exception("配置错误, 没有配置:phantomjs.binary.path");
        }
        capabilities.setCapability("phantomjs.binary.path", path);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        capabilities.setBrowserName("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver webDriver = null;

        try {
            webDriver = new PhantomJSDriver(capabilities);
        } catch (RuntimeException e) {
            throw new Exception("创建webdriver失败");
        }
        if (webDriver == null) {
            throw new Exception("创建webdriver失败");
        }
        webDriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(1024, 768));
        return webDriver;
    }


    /**
     * 创建Chrome
     *
     * @param path 路径
     * @return
     * @throws Exception
     */
    public static WebDriver createChromeWebDriver(String path) throws Exception {
        if (path == null || "".equals(path)) {
            throw new Exception("配置错误, 没有配置:chrome path");
        }
        System.getProperties().setProperty("webdriver.chrome.driver", path);
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(1200, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(1024, 768));
        return webDriver;
    }


    /**
     * 创建Firefox
     *
     * @param path 路径
     * @return
     * @throws Exception
     */
    public static WebDriver createFirefoxWebDriver(String path) throws Exception {
        if (path == null || "".equals(path)) {
            throw new Exception("配置错误, 没有配置 gecko path");
        }
        System.setProperty("webdriver.gecko.driver", path);
        WebDriver webDriver = new FirefoxDriver();
        return webDriver;
    }

}
