package com.atmecs.konakartautomation.helpers;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.konakartautomation.testbase.TestBase;

public class CommonUtility extends TestBase {

	/**
	 * method click the Element using the fluent wait concepts ignoring the
	 * ElementClickInterceptedException.
	 * 
	 * @param driver
	 * @param xpath
	 */

	public static void clickElement(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}
		});
	}

	public static void selectDropdown(final String xpath, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select trip = new Select(element);

				trip.selectByVisibleText(text);
				return true;
			}

		});
	}

	/**
	 * method click the blank fields and send the text to be entered
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text
	 */
	public static void clickAndSendText(final String xpath, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(text);
				;
				return true;
			}
		});
	}

	public static WebElement getElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param XPathIsDisplayed
	 * @return a boolean value for the displayed element on the web page
	 */
	public static boolean isDisplayed(String XPathIsDisplayed) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param XPathIsSelected
	 * @return a boolean value for the selected element on the web page
	 */
	public static boolean isSelected(String XPathIsSelected) {
		boolean isSelected = false;
		try {
			isSelected = driver.findElement(By.xpath(XPathIsSelected)).isSelected();
		} catch (Exception e) {
			isSelected = false;
		}
		return isSelected;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath  and uses the explicit wait concept
	 * @return a boolean value after checking the visibility of the.
	 */
	public static boolean isElementVisible(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param locators
	 * @return the list of elements
	 */

	public static List<WebElement> getElementsList(final String locators) {
		String [] loc=locators.split(",");
		List<WebElement> element ;
		if((loc[0].toUpperCase()).equalsIgnoreCase("CSS")) {
			element= driver.findElements(By.cssSelector(loc[1]));
		}
		else  {
		 element = driver.findElements(By.xpath(loc[1]));
		}
		
		return element;
	}

	/**
	 * method scroll down the window on the web page
	 * 
	 * @param driver
	 * @param horizontal index
	 * @param vertical   index
	 */

	public static void scrollDownPage(int horizontalIndex, int verticalIndex) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(" + horizontalIndex + "," + verticalIndex + ")";
		js.executeScript(scroll);
	}

	/**
	 * In this method, enter button operation of the keyboard is done
	 * 
	 * @param Webdriver
	 */
	public static void action() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("System interrupted");
		}
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	/**
	 * In this method,Input boxes entered texts are cleared
	 * 
	 * @param webdriver
	 * @param xpath
	 */
	public static void clearField(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	/**
	 * Method gets the title of the current page
	 */
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * Method waits for the time until the xpath of the element is clickable
	 * 
	 * @param WebDriver
	 * @param xpath
	 */
	public static void explicitWait(String xpath, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	/**
	 * Method scrolls down the window resolution until the view of webelement is not
	 * found
	 * 
	 * @param WebDriver
	 * @param xpath
	 */
	public static void scrollIntoview(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * In this method, mouse over operation of the mouse is done
	 * 
	 * @param Webdriver
	 */
	public static void action(String xpath) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("System interrupted");
		}
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xpath));
		if (browser.equals("firefox"))
			action.click(element).build().perform();
		else
			action.moveToElement(element).build().perform();
	}

	/**
	 * method select the dropdown and select the Element by index, using the fluent
	 * wait concepts ignoring the ElementClickInterceptedException.
	 * 
	 * @param driver
	 * @param xpath
	 */
	public static void selectDropdownByIndex(final String xpath, final int index) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select trip = new Select(element);

				trip.selectByIndex(index);
				return true;
			}

		});

	}
	
	/**
	 * Method sets the attribute value of the web element
	 * 
	 * @param xpath
	 */
	public static void setAttributeValue(String xpath, int xOffset) {

		WebElement slider = CommonUtility.getElement(xpath);
		Actions move = new Actions(driver);
		// move.moveToElement(slider).clickAndHold().moveByOffset(xOffset,
		// 0).release().build().perform();
		move.clickAndHold(slider).dragAndDropBy(slider, xOffset, 0).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
