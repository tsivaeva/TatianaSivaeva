package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MetalsColorsLogForm {

    @FindBy(css = "ul[class='panel-body-list results'] > li")
    public WebList result;

    public List<String> getLogList() {
        return IntStream.range(1, result.size() + 1)
                .mapToObj(i -> result.get(i).getText()).collect(Collectors.toList());
    }
}
