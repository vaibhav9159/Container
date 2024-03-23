package com.qa.service.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.UUID;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.service.utils.ShoppingPage;

public class shoppingAppTest {

	public static final String paymentMode = "UPI";
	public static final String OrderID = UUID.randomUUID().toString().replace("-", ""); 
	
	ShoppingPage sp;
	
	@BeforeClass
	public void getSetupData() {
		sp = new ShoppingPage();
	}
	
	@Test
	@DataProvider
	public Object testData(){
		
		return new Object[][] {
			
			{"shiv","shakti"},
			{"Radha","Krishna"},
			{"Sita","Ram"}
		};
	}
	
	@Test(dataProvider="testData", priority=1)
	public void EndToEndFlowTest(String Username, String password) {
		
		sp.login(Username, password)
			.search("macbook")
				.addProductToCart("macbook added")
					.selectPaymentType(paymentMode)
						.makePayment("UPI payment successfull !!!!")
							.verifyOrderID(OrderID)
								.logOut();
	}
	
	@Test(dataProvider="testData", priority=2)
	public void EndToEndFlowTestTwo(String Username, String password) {
		
		sp.login(Username, password)
			.search("iPhone")
				.addProductToCart("iPhone added")
					.selectPaymentType(paymentMode)
						.makePayment("UPI payment successfull !!!!")
							.verifyOrderID(OrderID)
								.logOut();
	}
	
	@Test(dataProvider="testData", priority=3)
	public void EndToEndFlowTestThree(String Username, String password) {
		
		sp.login(Username, password)
			.search("Kurta")
				.addProductToCart("Kurta added")
					.selectPaymentType(paymentMode)
						.makePayment("UPI payment successfull !!!!")
							.verifyOrderID(OrderID)
								.logOut();
	}
	
}
