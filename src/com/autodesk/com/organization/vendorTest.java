package com.autodesk.com.organization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.autodesk.com.genericlib.BaseLib;
import com.autodesk.com.pageobjects.VendorsPage;

public class vendorTest extends BaseLib {

	VendorsPage vp;

	@Test
	public void AddingActivitHistoryitoCreatedLead() throws IOException {

		vp = new VendorsPage(driver);

		/*navigate to more */
		hp.clickMoreDrpDwn();
		
		/*navigate to vendors*/
		hp.clickVendors();
		
		/*create filter for vendor*/
		vp.creatingFilter(flib.getExcelData("Sheet1", 5, 0), flib.getExcelData("Sheet1", 5, 1),
				flib.getExcelData("Sheet1", 5, 2), flib.getExcelData("Sheet1", 5, 3));
		
	}
}