package com.TestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import BasePackage.BaseClass;

public class DesktopSelectionTest extends BaseClass {

	@Test(priority=2)
	public void NavigationForDesktops() {
		System.out.println("Select Desktops Method");
		deskpage.navigateToPC();
		deskpage.navigateToMac();
		deskpage.navigateToAllDesktops();

	}

	@Test(priority=3)
	public void ChangeView() {
		System.out.println("Change view to Grid");
		deskListPage.ChangeView("Grid");
	}

	@Test(priority=4)
	public void SortItems() {
		System.out.println("Sort according to Descending");
		deskListPage.sortDesktops("Name (Z - A)");
	}

	@Test(priority=5)
	public void filterByQty() {
		System.out.println("Filter Quantity");
		deskListPage.sortQty("10");
	}

	@Test(priority=6)
	public void addItemsInWishlist() {
		System.out.println("Select Desktops to WishList");
		deskListPage.addToWishlist();
	}

	@Test(priority=7)
	public void addItemstoCart() {
		System.out.println("Select Desktops to Cart");
		deskListPage.addToCart("Red");
	}

}
