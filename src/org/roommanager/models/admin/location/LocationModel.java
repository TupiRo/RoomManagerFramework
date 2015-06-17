package org.roommanager.models.admin.location;

import org.openqa.selenium.By;

public final class LocationModel {
	
	/*Location Page*/
	public static final By ADDBUTTON_LOCATION = By.xpath("//div/div/button");
	public static final By MESSAGECREATE_LOCATION = By.xpath("//div[@id='toast-container']/div");
	public static final By SELECTCHECKBOX_LOCATION = By.cssSelector("input.ngSelectionCheckbox");
	public static final By REMOVEBUTTON_LOCATION = By.xpath("//button[2]");
	public static final By MESSAGEREMOVE_LOCATION = By.cssSelector("div.ng-binding.ng-scope");
	public static final By MESSAGE = By.cssSelector("div.ng-binding.ng-scope");
	public static final By NAMEREMOVE_LOCATION = By.xpath("//div[@id='locationGrid']/div[2]/div/div/div[3]/div[2]/div/span"); 
	
	/*Create Location Page*/
	public static final By NAMEFIELD_LOCATION = By.id("location-add-name");
	public static final By DISPLAYNAMEFIELD_LOCATION = By.id("location-add-display-name");
	public static final By SAVEBUTTON_LOCATION = By.cssSelector("button.btn.btn-primary");
	

	/*Delete Location Page*/
	public static final By FORM_DELETELOCATION = By.cssSelector("h3");
	public static final By REMOVEBUTTON_DELETELOCATION = By.cssSelector("button.btn.btn-primary");
}
