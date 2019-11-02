package com.atmecs.konakartautomation.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.pages.SearchBoxFunction;
import com.atmecs.konakartautomation.testbase.TestBase;

public class HomePageSearchBoxFunctionality extends TestBase {
	public static Logger log;

	@Test(priority = 1, dataProvider = "searchbox", dataProviderClass = TestDataProvider.class)
	public void searchBox(String[] data) {
		log = Logger.getLogger(HomePageSearchBoxFunctionality.class);
		//logger = extent.startTest("Search box Functionality validation");
		SearchBoxFunction.isRedirection(driver, data[8], log);
		SearchBoxFunction.serachBoxInput(data);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.search.btn"));
		SearchBoxFunction.validateProduct(data, log);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.home.btn"));
		SearchBoxFunction.negativeInputvalidtion(data, log);
	}
}