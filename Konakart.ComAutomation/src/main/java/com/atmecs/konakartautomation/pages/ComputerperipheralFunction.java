package com.atmecs.konakartautomation.pages;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.helpers.CommonUtility;
import com.atmecs.konakartautomation.logreports.LogReport;

public class ComputerperipheralFunction {
	static LogReport logreport = new LogReport();

	public static void erroMsgValidation(String validatedata,Logger log) {
		String erromsg = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.konakart.erromsg.txt"))
				.getText();
		Assert.assertTrue(erromsg.contains(validatedata), "Erro message validation failed");
		//ExtentReport.messagePrint("Error Message validate successfully");
		logreport.info("Error Message validate successfully");
	}

	public static void productValidation(String[] data,Logger log) {
		String producttitle = CommonUtility
				.getElement(
						LoadPropertyFile.locators.getProperty("loc.konakart.product.title").replace("dummy", data[0]))
				.getText();
		String productprice = CommonUtility
				.getElement(
						LoadPropertyFile.locators.getProperty("loc.konakart.product.price").replace("dummy", data[1]))
				.getText();
		//System.out.println(data[0] + data[1]);
		Assert.assertEquals(producttitle, data[0], "Product title validation failed");
	//	ExtentReport.messagePrint("Product title validate successfully");
		logreport.info("Product title validate successfully");
		Assert.assertEquals(productprice, data[1], "Product price validation failed");
	//	ExtentReport.messagePrint("Product price validate successfully");
		logreport.info("Product price validate successfully");

	}
}
