package ru.electrictower.rwts.pages.blocks;

import org.openqa.selenium.support.FindBy;
import ru.electrictower.rwts.beans.Trip;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * @author Aliaksei Boole
 */
@Name("Wagon block")
@Block(@FindBy(xpath = "//table[@class='fields']"))
public class WagonTypeBlock extends HtmlElement
{
    @Name("Cost Text")
    @FindBy(xpath = ".//p/span[contains(@style,'font-weight:bold')]")
    private TextBlock cost;

    @Name("Select Button")
    @FindBy(xpath = ".//input[contains(@id,'button1')]")
    private Button selectButton;

    public boolean isGoodCost(Trip trip)
    {
        int costActual = Integer.valueOf(cost.getText().replace(" ", ""));
        return costActual <= trip.getCost();
    }

    public void clickSelect()
    {
        selectButton.click();
    }
}
