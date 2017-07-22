package org.tanzeem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public enum DriverType implements DriverSetup {

	FIREFOX {
		public DesiredCapabilities getDesiredCapabilities() {
			return DesiredCapabilities.firefox();
		}

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new FirefoxDriver(capabilities);
		}
	},
	CHROME {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
			HashMap<String, String> chromePreferences = new HashMap<String, String>();
			chromePreferences.put("profile.password_manager_enabled", "false");
			capabilities.setCapability("chrome.prefs", chromePreferences);
			System.setProperty("webdriver.chrome.driver", "/Users/tanz/chromedriver");
			return capabilities;
		}

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new ChromeDriver(capabilities);
		}
	},
	SAFARI {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities capabilities = DesiredCapabilities.safari();
			capabilities.setCapability("safari.cleanSession", true);
			return capabilities;
		}

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new SafariDriver(capabilities);
		}
	},
	OPERA {
		public DesiredCapabilities getDesiredCapabilities() {
			System.setProperty("webdriver.opera.driver", "/Users/tanz/operadriver");
			DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
			return capabilities;
		}

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new OperaDriver(capabilities);
		}
	},
	PHANTOMJS {
		public DesiredCapabilities getDesiredCapabilities() {
			System.setProperty("phantomjs.binary.path", "/Users/tanz/phantomjs");
			DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
			final List<String> cliArguments = new ArrayList<String>();
			cliArguments.add("--web-security=false");
			cliArguments.add("--ssl-protocol=any");
			cliArguments.add("--ignore-ssl-errors=true");
			capabilities.setCapability("phantomjs.cli.args", cliArguments);
			capabilities.setCapability("takesScreenshot", true);

			return capabilities;
		}

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new PhantomJSDriver(capabilities);
		}
	}
}
