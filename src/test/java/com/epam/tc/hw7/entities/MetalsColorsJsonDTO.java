package com.epam.tc.hw7.entities;

import java.util.List;
import lombok.Data;

@Data
public class MetalsColorsJsonDTO {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;
}
