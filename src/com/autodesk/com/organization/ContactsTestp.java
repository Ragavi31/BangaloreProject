package com.autodesk.com.organization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.autodesk.com.genericlib.BaseLib;
import com.autodesk.com.pageobjects.ContactsPage;

public class ContactsTestp extends BaseLib {
	
	
	ContactsPage cp;
	@Test
	public void SelectmultipleContactAndDeleteMassContactWithHeaderAndCancel() throws IOException {
		
		cp=new ContactsPage(driver);
        
		/*navigate to contact page*/
		hp.clickContacts();
		
		/*create multiple contacts*/
		cp.createContact(flib.getExcelData("Sheet1", 1, 0), flib.getExcelData("Sheet1", 1, 1));
		cp.createContact(flib.getExcelData("Sheet1", 2, 0), flib.getExcelData("Sheet1", 2, 1));
		cp.createContact(flib.getExcelData("Sheet1", 2, 0), flib.getExcelData("Sheet1", 2, 1));
		
		/*try to do master select of contacts and delete then in alert do clicl dismiss*/
		cp.contacts();
		
		
	}

}
