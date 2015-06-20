package org.roommanager.models.admin.resource;

import org.openqa.selenium.By;

public class ResourceModel {

	/*Resource Page*/
	
	public static final By ADDBUTTON_RESOURCE = By.xpath("//div/div/button");
	public static final By SEARCHFIELD_RESOURCE = By.xpath("//div/div/button");
	public static final By SELECTSEARCHFIELD_RESOURCE =	By.xpath("(//button[@type='button'])[5]");
	public static final By SEARCHTEXTFIELD_RESOURCE = By.xpath("//input[@type='text']");
	public static final By NAMECREATE_RESOURCE = By.cssSelector("div.ng-scope > span.ng-binding");
	public static final By REMOVEBUTTON_RESOURCES = By.id("btnRemove");
	
	public static final By SELECTGRID_RESOURCES = By.xpath("(//button[@type='button'])[5]");
	public static final By GRID_RESOURCES = By.xpath("//div[@id='resourcesGrid']/div[2]/div");
	public static final By TEXTGRID_RESOURCES= By.xpath("div[3]/div[2]/div/span");
	public static final By DIV_RESOURCES = By.xpath("div");
	
	//div[@id='resourcesGrid']/div[2]/div
	//div[3]/div[2]/div/span
	
	
	
}
