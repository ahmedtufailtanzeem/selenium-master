package org.tanzeem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleTestWD extends DriverFactory {

	private void googleExampleThatSearchesFor(final String searchString) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.get("http://www.google.com");
		WebElement searchField = driver.findElement(By.name("q"));

		searchField.clear();
		searchField.sendKeys(searchString);
		System.out.println("Page title is: " + driver.getTitle());
		searchField.submit();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
			}
		});

		System.out.println("Page title is: " + driver.getTitle());
	}

	@Test(enabled = true)
	public void searchCheese() throws Exception {
		googleExampleThatSearchesFor("Cheese!");
	}

	@Test(enabled = true)
	public void searchBird() throws Exception {
		googleExampleThatSearchesFor("Bird!");
	}

}