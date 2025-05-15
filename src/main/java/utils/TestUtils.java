package utils;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import base.BaseTest;

public class TestUtils extends BaseTest {

	public static void action_clickOnPosition(int pointA_X, int pointA_Y) {
		PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
		org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger,1);

		clickPosition.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), pointA_X, pointA_Y))
				.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(clickPosition));
	}
	 public static void swipeToEnd(String direction, double swipePercentage) {
	        Dimension size = driver.manage().window().getSize();
	        int startX = 0, endX = 0, startY = 0, endY = 0;

	        switch (direction.toLowerCase()) {
	            case "up":
	                startX = size.width / 2;
	                startY = (int) (size.height * (1 - swipePercentage));
	                endX = size.width / 2;
	                endY = (int) (size.height * swipePercentage);
	                break;
	            case "down":
	                startX = size.width / 2;
	                startY = (int) (size.height * swipePercentage);
	                endX = size.width / 2;
	                endY = (int) (size.height * (1 - swipePercentage));
	                break;
	            case "left":
	                startY = size.height / 2;
	                startX = (int) (size.width * (1 - swipePercentage));
	                endY = size.height / 2;
	                endX = (int) (size.width * swipePercentage);
	                break;
	            case "right":
	                startY = size.height / 2;
	                startX = (int) (size.width * swipePercentage);
	                endY = size.height / 2;
	                endX = (int) (size.width * (1 - swipePercentage));
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
	        }

	        performSwipe(startX, startY, endX, endY);
	    }

	    public static boolean swipeTillTextVisible(String text, String direction, double swipePercentage, int maxSwipes) throws InterruptedException {
	        for (int i = 0; i < maxSwipes; i++) {
	            if (isTextVisible(text)) {
	                return true;
	            }
	            swipeToEnd(direction, swipePercentage);
	            Thread.sleep(1000);
	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        return false; // Text not visible after max swipes
	    }

	    private static void performSwipe(int startX, int startY, int endX, int endY) {
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 0);
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), startX, startY))
	                .addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
	                .addAction(finger.createPointerMove(Duration.ofMillis(200), Origin.viewport(), endX, endY)) // Adjust duration as needed
	                .addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
	        driver.perform(Arrays.asList(swipe));
	    }

	    private static boolean isTextVisible(String text) {
	        try {
	            return driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).isDisplayed();
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return false; // Text not found on the current screen
	        }
	    }
	
	    
}
