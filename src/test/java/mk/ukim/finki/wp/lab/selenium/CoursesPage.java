package mk.ukim.finki.wp.lab.selenium;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class CoursesPage extends AbstractPage {

    @FindBy(id = "edit")
    private List<WebElement> editButtons;

    @FindBy(id = "delete")
    private List<WebElement> deleteButtons;

    @FindBy(id = "open-course")
    private List<WebElement> openCourseButtons;

    public CoursesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static CoursesPage to(WebDriver driver) {
        get(driver, "/products");
        return PageFactory.initElements(driver, CoursesPage.class);
    }


    public void assertElements(int deleteButtons, int editButtons, int openCourseButtons) {
        Assert.assertEquals("delete buttons do not match", deleteButtons, this.getDeleteButtons().size());
        Assert.assertEquals("edit buttons do not match", editButtons, this.getEditButtons().size());
        Assert.assertEquals("open course links do not match", openCourseButtons, this.getOpenCourseButtons().size());
    }

}
