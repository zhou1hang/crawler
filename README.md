# crawler
---

> chrome、firefox、phantomjs插件安装和版本说明
> 基于selenium-java封装chrome、firefox、phantomjs实现爬虫

## maven版本说明

```xml
        <!-- +++|selenium|+++ -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.5.1</version>
        </dependency>
        <!-- +++|phantomjsdriver|+++ -->
        <dependency>
            <groupId>com.github.detro.ghostdriver</groupId>
            <artifactId>phantomjsdriver</artifactId>
            <version>1.1.0</version>
        </dependency>

```



## chrome插件配置
 1. 下载地址：[chromedriver下载地址](https://sites.google.com/a/chromium.org/chromedriver/downloads)选择本地系统对应的chrome版本安装，工程下面有一个 对应的目录是：`Plugin/chromedriver_win32.zip`，对应chrmoe版本是`Supports Chrome v60-62`
 2. 直接运行项目中示例
 ```java
 
 public class ChromeTest {
    public static void main(String[] args) {
        WebDriver webDriver = null;
        try {
            webDriver = WebDriverUtil.createChromeWebDriver("D:\\webdrvier\\chromedriver.exe");//修改路径
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
 ```
 3. chrome配置插件是最简单的，linux上面只需要把插件换成linux版本即可
 
## firefox
 4. 下载插件地址：[geckodriver下载地址](https://github.com/mozilla/geckodriver/releases)，选择本地系统对应的firefox版本安装，工程下面有一个 对应的目录是：`Plugin/geckodriver-v0.18.0-win64.zip`，对应firefox版本是`Firefox Setup 50.0(64位)`、其他版本没有测试过
 5. [firefox下载地址](https://ftp.mozilla.org/pub/firefox/releases/)、`selenium-java版本和geckodriver版本更新迭代不一致，导致在搭建环境时很容易出现一系列问题。`
 6. 直接运行项目中示例
```java
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
```
## phantomjs
 
 7. 下载插件地址[phantomjs插件地址1](http://npm.taobao.org/dist/phantomjs/)、[phantomjs插件地址2](https://bitbucket.org/ariya/phantomjs/downloads/)、下载有些慢。phantomjs是没有界面的，所以只需要下载插件即可。
 8. 直接运行项目中示例
 ```java
 
 public class PhantomjsTest {
    public static void main(String[] args) {
        WebDriver webDriver = null;
        try {
            webDriver = WebDriverUtil.createPhantomjsWebDriver("D:/webdrvier/phantomjs-1.9.8-windows/phantomjs.exe");
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
 ```
