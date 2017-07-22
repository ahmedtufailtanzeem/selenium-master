package org.tanzeem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverSetup {

	DesiredCapabilities getDesiredCapabilities();
	WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);
}
