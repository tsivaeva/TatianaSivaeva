package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class MetalColorsDataProvider {

    public static Map<String, MetalsColorsJsonDTO> getDTOfromJson() throws Exception {
        HashMap<String, MetalsColorsJsonDTO> map;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(MetalColorsDataProvider.class.getClassLoader()
                            .getResource("JDI_ex8_metalsColorsDataSet.json"),
                    new TypeReference<>() {
                    });
        } catch (Exception e) {
            throw new Exception("Incorrect file");
        }
        return map;
    }

    @DataProvider(name = "json")
    public Object[][] dataProvider() throws Exception {
        Map<String, MetalsColorsJsonDTO> mapFromJson = MetalColorsDataProvider.getDTOfromJson();
        Object[][] objectMap = new Object[mapFromJson.size()][1];
        int i = 0;
        for (Map.Entry<String, MetalsColorsJsonDTO> entry : mapFromJson.entrySet()) {
            objectMap[i][0] = entry.getValue();
            i++;
        }
        return objectMap;
    }
}
