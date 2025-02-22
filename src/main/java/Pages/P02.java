package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P02 {
    SHAFT.GUI.WebDriver driver ;

    public P02(SHAFT.GUI.WebDriver driver) {
        this.driver = driver ;
    }

    private final By assertTxt = By.xpath("//span[@class=\"BBwThe\"]") ;
    private final By options =  By.xpath("//li[contains(@data-entityname,'restaurant')]");
    private List<WebElement> list ;
    private final By topRate = By.xpath("//span[.='Top rated']") ;


    public P02 selectSearchOption()
    {
        list = driver.getDriver().findElements(options);
        for (int i=0 ; i<list.size();i++)
        {
            WebElement index = list.get(i);
            String txt = index.getText();
            if(txt.equalsIgnoreCase("restaurant near marsa alam"))
            {
                driver.getDriver().findElements(options).get(i).click();
                break;
            }



        }


        return this;
    }

    public P02 sortEle()
    {
        driver.element().click(topRate);
        return this;
    }




    public By getLocator() {
        return By.xpath("//span[@class=\"BBwThe\"]");
    }

}
