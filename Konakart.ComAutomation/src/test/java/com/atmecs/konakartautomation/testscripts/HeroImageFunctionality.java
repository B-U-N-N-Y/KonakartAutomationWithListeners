package com.atmecs.konakartautomation.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.dataProvider.TestDataProvider;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.pages.HeroImageFunction;
import com.atmecs.konakartautomation.testbase.TestBase;

public class HeroImageFunctionality extends TestBase {
	public static Logger log;

	@Test(priority = 1)
	public void heroImageSelect() {
		log = Logger.getLogger(HeroImageFunctionality.class);
		//logger = extent.startTest("Hero image Select");
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.btn"));
	}

	@Test(priority = 2, dataProvider = "heroimage", dataProviderClass = TestDataProvider.class)
	public void heroImgContent(String[] data) {
		log = Logger.getLogger(HeroImageFunctionality.class);
		//logger = extent.startTest("Hero image content validation");
		// CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.konakart.heroimg.btn"));
		HeroImageFunction.heroImgContentValidation(driver, data, log);

	}

	@Test(priority = 3, dataProvider = "reviewdropdown", dataProviderClass = TestDataProvider.class)
	public void heroImgSortingDateFunctionality(String[] data) {
		log = Logger.getLogger(HeroImageFunctionality.class);
		//logger = extent.startTest("Hero image sorting validation by date");
		HeroImageFunction.heroImgSortOption(data[0]);
		HeroImageFunction.sortingDateValidation(data[0], log);
		HeroImageFunction.heroImgSortOption(data[1]);
		HeroImageFunction.sortingDateValidation(data[1], log);
	}

	@Test(priority = 4, dataProvider = "reviewdropdown", dataProviderClass = TestDataProvider.class)
	public void heroImgSortingRatingFunctionality(String[] data) {
		log = Logger.getLogger(HeroImageFunctionality.class);
		//logger = extent.startTest("Hero image sorting validation by rating");
		HeroImageFunction.heroImgSortOption(data[2]);
		HeroImageFunction.starRatingValidation(data[2], log);
		HeroImageFunction.heroImgSortOption(data[3]);
		HeroImageFunction.starRatingValidation(data[3], log);
	}

}
