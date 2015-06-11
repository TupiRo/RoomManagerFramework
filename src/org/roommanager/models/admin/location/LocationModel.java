package org.roommanager.models.admin.location;

import org.openqa.selenium.By;

public final class LocationModel {
	
	public static final By ADDBUTTON_LOCATION = By.xpath("//div/div/button");
	public static final By MESSAGECREATE_LOCATION = By.xpath("//div[@id='toast-container']/div");
	public static final By SELECTCHECKBOX_LOCATION = By.cssSelector("input.ngSelectionCheckbox");
	public static final By REMOVEBUTTON_LOCATION = By.xpath("//button[2]");
	public static final By MESSAGEREMOVE_LOCATION = By.cssSelector("div.ng-binding.ng-scope");
	public static final By MESSAGE = By.cssSelector("div.ng-binding.ng-scope");

}
