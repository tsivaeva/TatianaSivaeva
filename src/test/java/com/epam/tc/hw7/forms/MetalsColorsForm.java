package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiDropdown;
import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;
import java.util.List;

public class MetalsColorsForm extends Form<MetalsColorsJsonDTO> {

    @FindBy(xpath = "//p[@class='radio'][contains(., '%s')]//label")
    public Menu summary;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metals;

    @UI("#vegetables")
    public MultiDropdown vegetables;

    @FindBy(xpath = "//p[@class='checkbox'][contains(., '%s')]//label")
    public UIElement elements;

    @UI("#submit-button")
    public Button submitButton;

    public void selectSummary(List<Integer> sum) {
        summary.select(sum.get(0));
        summary.select(sum.get(1));
    }

    public void selectElements(List<String> el) {
        el.forEach(str -> elements.select(str));
    }

    public void selectColors(String col) {
        colors.select(col);
    }

    public void selectMetals(String col) {
        metals.select(col);
    }

    public void selectVegetables(List<String> veg) {
        vegetables.select("Vegetables");
        veg.forEach(str -> vegetables.select(str));
    }

    public void submit() {
        submitButton.click();
    }

    @Override
    public void fill(MetalsColorsJsonDTO dto) {
        selectSummary(dto.getSummary());
        selectElements(dto.getElements());
        selectColors(dto.getColor());
        selectMetals(dto.getMetals());
        selectVegetables(dto.getVegetables());
        submit();
    }
}
