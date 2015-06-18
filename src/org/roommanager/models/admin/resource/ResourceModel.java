package org.roommanager.models.admin.resource;

import org.openqa.selenium.By;

public class ResourceModel {

	/*Resource Page*/
	
	public static final By ADDBUTTON_RESOURCE = By.xpath("//div/div/button");
	public static final By SEARCHFIELD_RESOURCE = By.xpath("//div/div/button");
	public static final By SELECTSEARCHFIELD_RESOURCE =	By.xpath("(//button[@type='button'])[5]");
	public static final By SEARCHTEXTFIELD_RESOURCE = By.xpath("//input[@type='text']");
	public static final By NAMECREATE_RESOURCE = By.cssSelector("div.ng-scope > span.ng-binding");
	
	public static final By MESSAGECREATE_LOCATION = By.xpath("//div[@id='toast-container']/div");
	public static final By SELECTCHECKBOX_LOCATION = By.cssSelector("input.ngSelectionCheckbox");
	public static final By REMOVEBUTTON_LOCATION = By.xpath("//button[2]");
	public static final By MESSAGEREMOVE_LOCATION = By.cssSelector("div.ng-binding.ng-scope");
	public static final By MESSAGE = By.cssSelector("div.ng-binding.ng-scope");
	public static final By NAMEREMOVE_LOCATION = By.xpath("//div[@id='locationGrid']/div[2]/div/div/div[3]/div[2]/div/span"); 
	
	
}
