package utils;

import org.openqa.selenium.*;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String name) {

        try {
            String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            String path = "screenshots/" + name + "_" + time + ".png";

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);

            FileUtils.copyFile(src, dest);

            System.out.println(" Screenshot: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
