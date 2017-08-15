package org.tanzeem.practice;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Learning {

	public static void main(String[] args) {

		WebDriver driver = null;
		long startTime = 0;
		try {

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			startTime = Instant.now().toEpochMilli();
			//driver.findElement(By.name("abc"));

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(new ExpectedCondition<WebElement>() {

				@Override
				public WebElement apply(WebDriver d) {
					return d.findElement(By.name("Topics"));
				}
			});

		} catch (Exception e) {
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(Instant.now().toEpochMilli() - startTime));
			driver.quit();
		}
	}
}
