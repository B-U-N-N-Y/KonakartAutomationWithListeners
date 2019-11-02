package com.atmecs.konakartautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.logreports.LogReport;

public class SearchBoxFunction {
	static LogReport logreport = new LogReport();

	/**
	 * This method takes input as string array and select and click dropdown option
	 * dynamically
	 * 
	 * @param data
	 */
	public static void serachBoxInput(String[] data) {
		CommonUtility.selectDropdown(LoadPropertyFile.locators.getProperty("loc.konakart.homepage.dpdn"), data[0]);
		CommonUtility.clickAndSendText(LoadPropertyFile.locators.getProperty("loc.konakart.search.txtbox"), data[1]);
	}

	/**
	 * This method validate the web page redirect to proper page or not
	 * 
	 * @param driver
	 * @param validatedata
	 * @param log
	 */
	public static void isRedirection(WebDriver driver, String validatedata, Logger log) {
		String title = driver.getTitle();
		Assert.assertEquals(title, validatedata, "Page is not redirect properly");
	//	ExtentReport.messagePrint("Page is redirecting to proper web page");
		logreport.info("Page is redirecting to proper web page");
	}

	/**
	 * This method validate that selected product is available or not
	 * 
	 * @param data
	 * @param log
	 */
	public static void validateProduct(String[] data, Logger log) {
		String producttitle = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.producttitle.txt")).getText();
		Assert.assertEquals(producttitle, data[1], "Product title validationfailed");
	//	ExtentReport.messagePrint("Product title validate successfully");
		logreport.info("Product title validate successfully");
		String producprice = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productprice.txt")).getText();
		Assert.assertEquals(producprice, data[3], "Product price validationfailed");
	//	ExtentReport.messagePrint("Product price validate successfully");
		logreport.info("Product price validate successfully");
		CommonUtility.action(LoadPropertyFile.locators.getProperty("loc.konakart.productclick.btn"));
		String addtocart = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productaddtocart.txt")).getText();
		
		Assert.assertEquals(addtocart, data[6], "Product add to cart validationfailed");
		//ExtentReport.messagePrint("Product add to cart button validate successfully");
		logreport.info("Product add to cart button validate successfully");
		String addtowishlist = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productaddtowishlist.txt")).getText();
		Assert.assertEquals(addtowishlist, data[7], "Product add to wishlist validationfailed");
	//	ExtentReport.messagePrint("Product add to wishlist button validate successfully");
		logreport.info("Product add to wishlist button validate successfully");
		String productavailibility = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.productavailaibilty.txt")).getText();
		Assert.assertEquals(productavailibility, data[4].replace(" ", "\n"), "Product availibility validationfailed");
	//	ExtentReport.messagePrint("Product availibility validate successfully");
		logreport.info("Product availibility validate successfully");
	}

	/**
	 * By giving negative input validating that Web application working properly or
	 * not
	 * 
	 * @param data
	 * @param log
	 */
	public static void negativeInputvalidtion(String[] data, Logger log) {
		CommonUtility.selectDropdown(LoadPropertyFile.locators.getProperty("loc.konakart.homepage.dpdn"), data[0]);
		CommonUtility.clickAndSendText(LoadPropertyFile.locators.getProperty("loc.konakart.search.txtbox"), data[2]);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.search.btn"));
		String errormsg = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.erromsg.txt")).getText();
		Assert.assertEquals(errormsg, data[5], "Negative input validation failed");
	//	ExtentReport.messagePrint("Negative input validation passed");
		logreport.info("Negative input validation passed");
	}
}
