package org.tanzeem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverThread {

	private WebDriver webdriver;
	private DriverType selectedDriverType;
	private final DriverType defaultDriverType = DriverType.FIREFOX;
	private final String browser = System.getProperty("browser").toUpperCase();

	public WebDriver getDriver() throws Exception {
		if (null == webdriver) {
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);
		}

		return webdriver;
	}

	public void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
		}
	}

	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = DriverType.valueOf(browser);
		} catch (IllegalArgumentException ignored) {
			System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
		} catch (NullPointerException ignored) {
			System.err.println("No driver specified, defaulting to '" + driverType + "'...");
		}
		return driverType;
	}

	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
		webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
	}

}
