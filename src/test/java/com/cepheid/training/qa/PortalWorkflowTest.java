package com.cepheid.training.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

// Intentionally poor automation code for the refactoring lab:
// - duplicated login/navigation steps in every test method
// - Thread.sleep() instead of explicit waits
// - long test methods mixing multiple concerns
// - weak assertions and poor exception handling
public class PortalWorkflowTest {

    @Test
    public void loginThenViewProducts() throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver();
        try {
            driver.get(TestConfig.pageUrl("login.html"));
            driver.findElement(By.id("username")).sendKeys("trainee1");
            driver.findElement(By.id("password")).sendKeys("Training@123");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(1500); // hardcoded wait -- should be an explicit wait
            driver.get(TestConfig.pageUrl("products.html"));
            Thread.sleep(1000); // duplicated hardcoded wait
            if (driver.findElements(By.id("product-list")).size() > 0) {
                System.out.println("products visible");
            }
        } catch (Exception e) {
            // swallow everything -- known smell for the lab
        } finally {
            driver.quit();
        }
    }

    @Test
    public void loginThenViewOrderForm() throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver();
        try {
            driver.get(TestConfig.pageUrl("login.html"));
            driver.findElement(By.id("username")).sendKeys("trainee1");
            driver.findElement(By.id("password")).sendKeys("Training@123");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(1500); // duplicated hardcoded wait (same as above test)
            driver.get(TestConfig.pageUrl("order.html"));
            Thread.sleep(1000);
            if (driver.findElements(By.id("order-form")).size() > 0) {
                System.out.println("order form visible");
            }
        } catch (Exception e) {
            // swallow everything -- known smell for the lab
        } finally {
            driver.quit();
        }
    }
}
