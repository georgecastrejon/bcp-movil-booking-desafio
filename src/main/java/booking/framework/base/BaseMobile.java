package booking.framework.base;

import booking.framework.helpers.ExceptionMessage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        while (System.currentTimeMillis() - startTime < (long) timeoutInSeconds * 1000) {
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

    public boolean waitBooleanvisibilityOf(Duration timeoutInSeconds, WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickItemElements(By locatorElements, int nroElementClick, By locatorScroll, int maxWaitTimeSeconds) throws ExceptionMessage {
        try {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < maxWaitTimeSeconds * 1000) {
                List<WebElement> elements = driver.findElements(locatorElements);
                int nroElement = nroElementClick - 1;
                if (elements.size() > nroElement && nroElement >= 0) {
                    WebElement targetElement = elements.get(nroElement);
                    boolean isVisible = waitBooleanvisibilityOf(Duration.ofSeconds(1), targetElement);
                    if (isVisible) {
                        targetElement.click();
                        return;
                    } else {
                        scrollTo(locatorScroll, "up", 300);
                    }
                } else {
                    scrollTo(locatorScroll, "up", 300);
                }
            }
            throw new RuntimeException("No se pudo hacer clic en el elemento después de " + maxWaitTimeSeconds + " segundos.");

        } catch (Exception e) {
            throw new ExceptionMessage(e.getMessage());
        }
    }

    public void scrollTo(By locator, String direction, int sizePixel) {
        WebElement element = driver.findElement(locator);
        int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        int endY;
        if (direction.equalsIgnoreCase("down")) {
            endY = startY + sizePixel;
        } else {
            endY = startY - sizePixel;
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0);

        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(sequence));
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        WebElement type = driver.findElement(locator);
        type.sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void waitElementLocated(Duration timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitvisibility(Duration timeoutInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitvisibilityMillis(Duration timeoutInMillis, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInMillis);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitvisibilityBoolean(Duration timeoutInSeconds, By locator) {
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

    public void waitClickable(Duration timeoutInSeconds, By locator) {
        WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
        wait1.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementVisible(By locator, Duration timeInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}