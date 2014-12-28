package pageobject;

import cuisine.Cuisine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Тёма on 12.12.2014.
 */
public class CuisinesPage {
    private WebDriver webDriver;
    public CuisinesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(xpath = ".//*[@id='back']")
    private WebElement back;
    public void back(){
        back.click();
    }

    public  Set<Cuisine> cuisineSet(){

        Set<Cuisine> cuisineSet = new HashSet<Cuisine>();
        List<WebElement> cuisineWebElement = webDriver.findElements(By.xpath("//label[text()]/ancestor::div[@href]"));

        for (WebElement element: cuisineWebElement){
            Cuisine cuisine = new Cuisine(element.getText(),"snack");
            cuisineSet.add(cuisine);
        }
        return cuisineSet;
    }

    public WebElement getWebElementCuisine(String cuisineName){
     WebElement element = webDriver.findElement(By.xpath("//label[text()='" + cuisineName + "']/ancestor::div[@href]"));
        return element;
    }

    @FindBy(id = "cuisine")
    private WebElement cuisine;
    public void cuisine(){
        cuisine.click();
    }

    @FindBy(linkText = "Закуски")
    private WebElement enterSnacks;
    public void enterSnacks(){
        enterSnacks.click();
    }
}
