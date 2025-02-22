package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P01 {
    SHAFT.GUI.WebDriver driver ;

    //constructor
    public P01(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver ;
    }

    //locators
    private final By search_Input = By.id("APjFqb") ;
    private final By lis= By.xpath("//li[contains(@data-entityname,'marsa alam weather')]");

    private List<WebElement> lisEle ;



    //Action Methods
    public P01 enterTextSearch(String txt)
    {
        driver.element().clear(search_Input);
        driver.element().type(search_Input,txt);
        return this;
    }



    public P02 selectOption()
    {
         lisEle = driver.getDriver().findElements(lis); // 10 options
         System.out.println(lisEle.size());
       for (int i = 0; i<lisEle.size() ;i++)
        {
            WebElement index = lisEle.get(i);
            String txt =index.getText();
            if(txt.equalsIgnoreCase("marsa alam weather"))
            {
                System.out.println(txt);
                driver.getDriver().findElements(lis).get(i).click();
                break;
            }

            }

        return new P02(driver);

    }


}
