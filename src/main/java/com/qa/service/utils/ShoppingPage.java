package com.qa.service.utils;

public class ShoppingPage {

	public ShoppingPage login() {
		System.out.println("user login");
		return this;
	}
	
	public ShoppingPage login(String u , String p) {
		System.out.println("user login with credentials : "+ u + "  "+ p);
		return this;
	}
	
	public ShoppingPage search(String prod) {
		System.out.println("user search product : "+ prod);
		return this;
	}
	
	public ShoppingPage addProductToCart(String prod) {
		System.out.println("user adds product to cart : "+ prod);
		return this;
	}
	
	public ShoppingPage selectPaymentType(String type) {
		System.out.println("user selected payment mode : "+ type);
		return this;
	}
	
	public ShoppingPage addUserPin(String pin) {
		System.out.println("user entered UPI pin : "+ pin);
		return this;
	}
	
	public ShoppingPage makePayment(String msg) {
		System.out.println("user made payment successfully : "+ msg);
		return this;
	}
	
	public ShoppingPage verifyOrderID(String orderid) {
		System.out.println("Order ID generated : "+ orderid);
		return this;
	}
	
	public ShoppingPage logOut() {
		System.out.println("LogOut successfull");
		return this;
	}
	
}
