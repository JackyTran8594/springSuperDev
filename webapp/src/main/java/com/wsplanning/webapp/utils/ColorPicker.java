package com.wsplanning.webapp.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
public class ColorPicker {

    public static String jsonFileColorThemes(colorPickerDTO obj) throws IOException {

        Path file = Paths.get("src/main/resources/static/colorPickerData.json");
        Gson gson = new Gson();
        int tempCount = 0;

        if (file == null) {

            // convert object to json
            String jObject = gson.toJson(obj);
            FileWriter jsonfile = new FileWriter(file.toString());
            jsonfile.write(jObject);        
            return jObject;
        } else {           
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toString()));
            // using arrays
            // colorPickerDTO[] colorArray = gson.fromJson(bufferedReader.toString(),
            // colorPickerDTO[].class);
          
            // using lists
            // In order for Gson to understand the List structure correctly. You've to
            // figure out its type.
            Type colorPickerListType = new TypeToken<ArrayList<colorPickerDTO>>() {
            }.getType();
            List<colorPickerDTO> colorList = gson.fromJson(bufferedReader.toString(), colorPickerListType);
            String jObject = gson.toJson(colorList);
            colorList.forEach(item -> {
                if (item.username == obj.username && item.siteId == obj.siteId) {
                    item.colorCode = obj.colorCode;
                } else {
                    int i = tempCount + 1;
                    i = tempCount;
                }
            });

            if (tempCount > 0) {
             gson.toJson(obj, new FileWriter(file.toString()));                
            };
            return jObject;
        }

    }
}
