package TestCases;

import Pages.P01;
import Pages.P02;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC01 {
    SHAFT.GUI.WebDriver driver ;
    SHAFT.TestData.JSON tData ;


    @BeforeClass
    public void setUp()
    {
        driver = new SHAFT.GUI.WebDriver();
        tData= new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData()+"searchTexts.json");
        driver.browser().navigateToURL("https://www.google.com/ncr");

    }

    @Test
    public void searchForMarsaAlamWeather()
    {
        new P01(driver)
                .enterTextSearch(tData.getTestData("FirstSearchWord"))
                .selectOption();


     driver.element().assertThat(new P02(driver).getLocator()).text().isEqualTo("Marsa Alam").perform();
    }


    @Test(dependsOnMethods = "searchForMarsaAlamWeather")
    public void searchForrestaurantNearMarsaAlam()
    {
        new P01(driver)
                .enterTextSearch(tData.getTestData("secondSearchWord"));

        new P02(driver)
                .selectSearchOption()
                .sortEle();
        driver.browser().assertThat().url().contains("q=top+rated+restaurant+near+marsa+alam")
                .withCustomReportMessage("new Url").perform();
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
