package org.roommanager.models.admin.resource;

import org.openqa.selenium.By;

public class CreateResourceModel {

	public static final By NAMEFIELD_RESOURCE= By.xpath("(//input[@type='text'])[3]");
	public static final By DISPLAYNAMEFIELD_RESOURCE = By.xpath("(//input[@type='text'])[4]");
	public static final By SAVEBUTTON_RESOURCE = By.cssSelector("button.info");
	public static final By FORMCREATE_RESOURCE = By.cssSelector("div.col-xs-12 > div.row");
}
