package com.atmecs.konakartautomation.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.pages.PriceSlideBar;
import com.atmecs.konakartautomation.testbase.TestBase;

public class PriceSlideBarFunctionality extends TestBase {
	public static Logger log;

	@Test(priority = 8, dataProvider = "priceslidebar", dataProviderClass = TestDataProvider.class)
	public void priceSlideBar(String xoffset) {
		log = Logger.getLogger(PriceSlideBarFunctionality.class);
		//logger = extent.startTest("Price slidebar functionality validation");
		PriceSlideBar.priceSlideBar(xoffset);
		PriceSlideBar.priceValidation(log);

	}
}
