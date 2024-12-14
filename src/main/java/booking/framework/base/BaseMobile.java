package booking.framework.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseMobile {
    protected AndroidDriver driver;

    public BaseMobile(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectDateCalendar(By calendar, By daysSelector, By btnSelectDates, String fechaIni, String fechafin, int timeoutInSeconds) {
        long startTime = System.currentTimeMillis();
        boolean fechaIniSelected = false;
        boolean fechaFinSelected = false;

        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
            List<WebElement> daysElements = driver.findElements(daysSelector);

            for (WebElement day : daysElements) {
                try {
                    String contentDesc = day.getAttribute("content-desc");
                    if (contentDesc != null) {
                        if (!fechaIniSelected && contentDesc.equals(fechaIni)) {
                            day.click();
                            fechaIniSelected = true;
                        } else if (fechaIniSelected && contentDesc.equals(fechafin)) {
                            day.click();
                            fechaFinSelected = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error al procesar el elemento: " + e.getMessage());
                }
            }
            if (fechaFinSelected) {
                click(btnSelectDates);
                break;
            }

            scrollTo(calendar, "up", 500);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error en la pausa: " + e.getMessage());
            }
        }
    }


    public void scrollTo(By locator, String direction, int sizePixel) {
        WebElement element = driver.findElement(locator);
        int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
        int endY = direction.equalsIgnoreCase("down") ? startY + sizePixel : startY - sizePixel;

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }


    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }


    public void type(String inputText, By locator) {
        MobileElement type = (MobileElement) driver.findElement(locator);
        type.clear();
        type.sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean idDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void wait(long timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitvisibility(long timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitvisibilityBoolean(long timeoutInSeconds, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitClickable(long timeoutInSeconds, By locator) {
        WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
        wait1.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public boolean isElementVisible(By locator, int timeInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}