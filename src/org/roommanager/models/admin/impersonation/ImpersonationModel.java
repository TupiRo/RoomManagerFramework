package org.roommanager.models.admin.impersonation;

import org.openqa.selenium.By;

public final class ImpersonationModel {

	public static final By CHECKBOX_IMPERSONATION = By.xpath("//input[@type='checkbox']");
	public static final By SAVEBUTTON = By.cssSelector("button.info.pull-right");
	public static final By MESSAGE_IMPERSONATION = By.cssSelector("div.ng-binding.ng-scope");
}
