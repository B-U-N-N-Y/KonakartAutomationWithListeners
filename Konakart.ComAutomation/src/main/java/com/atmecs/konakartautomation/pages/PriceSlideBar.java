package com.atmecs.konakartautomation.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.logreports.LogReport;

public class PriceSlideBar {
	static LogReport logreport=new LogReport();

	public static void priceSlideBar(String xoffset) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.hearder.computerperipherals"));
		CommonUtility.scrollDownPage(0, 300);
		CommonUtility.setAttributeValue(LoadPropertyFile.locators.getProperty("loc.konakart.priceslider"),
				Integer.parseInt(xoffset));
		CommonUtility.explicitWait(LoadPropertyFile.locators.getProperty("loc.konakart.hearder.computerperipherals"),
				10);
	}

	public static void priceValidation(Logger log) {
		List<WebElement> prices = CommonUtility
				.getElementsList(LoadPropertyFile.locators.getProperty("loc.koanakart.pricesacordingslidebar"));
//		int pricecount = prices.size();
		String[] pricerange = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.pricerange"))
				.getText().split("-");
		String minprice = pricerange[0].replace("$", "");
		String maxprice = pricerange[1].replace("$", "");
		for (WebElement price : prices) {
			String productprice = price.getText().replace("$", "");
			Assert.assertTrue(
					Float.parseFloat(productprice) >= Float.parseFloat(minprice)
							&& Float.parseFloat(productprice) <= Float.parseFloat(maxprice),
					"Price slidebar fuctionality validation failed");
			//ExtentReport.messagePrint("Price slidebar fuctionality validate successfully");
			logreport.info("Price slidebar fuctionality validate successfully");
		}

	}
}
