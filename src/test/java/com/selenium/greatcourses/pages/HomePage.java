package com.selenium.greatcourses.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.libraries.Base;

public class HomePage extends Base{

	public HomePage goto_theGreatCourseWebsite(){
		driver.get("https://www.thegreatcourses.com/");
		//assertEquals(driver.getTitle(), "Apple");		
		return this;
	}
	
	public SciencePage selectScienceCategory(){
		selectACourseCategory("Science");
		return new SciencePage();
	}
	
	private void selectACourseCategory(String courseCatogoryName) {
		WebElement parentElem = driver.findElement(By.cssSelector(".itemslider-wrapper.itemslider-categories"));
		List<WebElement> categoryCourses = parentElem.findElements(By.tagName("li"));

		for (WebElement li : categoryCourses) {
			List<WebElement> imgElems = li.findElements(By.tagName("img"));
			String altText = imgElems.get(0).getAttribute("alt");
			System.out.println("alt text is: " + altText);
			if (altText.contains(courseCatogoryName)) {
				imgElems.get(0).click();
				break;
			}
		}
	}
	
}
