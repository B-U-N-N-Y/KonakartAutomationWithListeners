package com.atmecs.konakartautomation.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;

import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.pages.SearchBoxFunction;
import com.atmecs.konakartautomation.pages.ComputerperipheralFunction;
import com.atmecs.konakartautomation.testbase.TestBase;

public class ComuterPeripheralsFunctionality extends TestBase {

	public static Logger log;

	@Test(priority = 5, dataProvider = "scenario3", dataProviderClass = TestDataProvider.class)
	public void searchBoxWithoutSearchOption(String[] data) {
		log = Logger.getLogger(ComuterPeripheralsFunctionality.class);
		//logger = extent.startTest("validation of search box Functionality without using search options");
		SearchBoxFunction.serachBoxInput(data);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.search.btn"));
		ComputerperipheralFunction.erroMsgValidation(data[2], log);
	}

	@Test(priority = 6, dataProvider = "scenario3", dataProviderClass = TestDataProvider.class)
	public void searchBoxWithSearchOption(String[] data) {
		log = Logger.getLogger(ComuterPeripheralsFunctionality.class);
		//logger = extent.startTest("validation of search box Functionality with using search options");
		SearchBoxFunction.serachBoxInput(data);
		CommonUtility.explicitWait(
				LoadPropertyFile.locators.getProperty("loc.konakart.searchbox.options").replace("value", data[1]), 5);
		CommonUtility.clickElement(
				LoadPropertyFile.locators.getProperty("loc.konakart.searchbox.options").replace("value", data[1]));
	}

	@Test(priority = 7, dataProvider = "product details", dataProviderClass = TestDataProvider.class)
	public void productDetailsVerify(String[] data) {
		log = Logger.getLogger(ComuterPeripheralsFunctionality.class);
		//logger = extent.startTest("Product details validation");
		ComputerperipheralFunction.productValidation(data, log);
	}

}
