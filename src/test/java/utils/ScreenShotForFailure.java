package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotForFailure {
    public static void takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
        long timeStamp = System.currentTimeMillis();
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFolder = new File("screenshots/" + testCaseName+"_"+timeStamp + ".png");
        FileUtils.copyFile(file, destinationFolder);
    }
}