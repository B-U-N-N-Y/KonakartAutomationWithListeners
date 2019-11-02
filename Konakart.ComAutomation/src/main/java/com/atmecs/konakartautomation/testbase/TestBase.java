package com.atmecs.konakartautomation.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.atmecs.konakartautomation.constants.FilePath;
import com.atmecs.konakartautomation.constants.GridConnection;
import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.utils.ReadPropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class operate to choose the driver
 * 
 * @author arjun.santra
 *
 */
public class TestBase {
	public static WebDriver driver;
	Properties baseClass;
	String url;
	public static String browser;
	int downloadFile;
	String con;
	LoadPropertyFile property = new LoadPropertyFile();

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void intitailizeBrowser() throws IOException {

		baseClass = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("url");
		browser = baseClass.getProperty("browser");
		con = baseClass.getProperty("connection");

		System.out.println("browser is " + browser);
		if (con.equals("normal")) {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().arch64().setup();
				driver = new ChromeDriver();
				driver.get(url);

			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().arch64().setup();
				driver = new FirefoxDriver();
				driver.get(url);
			} else if (browser.equalsIgnoreCase("internet explorer")) {
				WebDriverManager.iedriver().arch32().setup();
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
				driver = new InternetExplorerDriver(ieCaps);
			}
		} else if (con.equals("grid")) {
			WebDriver drv = GridConnection.GridCon(driver, browser);
			// ExtentReport.driver = drv;
			driver.get(url);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
