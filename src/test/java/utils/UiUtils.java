package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class UiUtils {

    public static void closeWindows(WebDriver driver, String parentWindowId) {

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            if (!id.equals(parentWindowId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowId);
    }

    public static void switchByUrl(WebDriver driver, String url) {
        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            if (!driver.getCurrentUrl().equals(url)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByID(WebDriver driver, String pageId) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (id.equals(pageId)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void click(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void hoverOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

}
