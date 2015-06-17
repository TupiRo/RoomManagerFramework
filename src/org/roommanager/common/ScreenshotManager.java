package org.roommanager.common;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.*;

public class ScreenshotManager extends TestListenerAdapter {

	//When TC is Failed Take screen shot
	@Override
	public void onTestFailure(ITestResult tr) {
		captureScreenShot();
	}

	private void captureScreenShot() {
		try {
	
			String NewFileNamePath;
		
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension scrnsize = toolkit.getScreenSize();
		
			File directory = new File (".");
			
			DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
			Date date = new Date();
		
			InetAddress ownIP=InetAddress.getLocalHost();
			NewFileNamePath = directory.getCanonicalPath()+ "\\screenshotTests\\"+ dateFormat.format(date)+"_"+ownIP.getHostAddress()+ ".png";
		
			Robot robot = new Robot();
			BufferedImage bi=robot.createScreenCapture(new Rectangle(scrnsize));
			ImageIO.write(bi, "png", new File(NewFileNamePath));
		} 
		catch (AWTException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}