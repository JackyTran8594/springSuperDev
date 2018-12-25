package com.wsplanning.webapp.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ColorPicker {

    public static JsonArray jsonFileColorThemes(colorPickerDTO obj) throws IOException {

        Path file = Paths.get("src/main/resources/static/colorPickerData.json");
        JsonArray objArray = new JsonArray();
       
        if (file == null) {
            objArray.add(obj.toString());
            FileWriter jsonfile = new FileWriter(file.toString());
            jsonfile.write(objArray.toString());
            return objArray;
        } else {
            // JsonParser parser = new JsonParser();
            // Object object = parser.parse(new FileReader("src/main/resources/static/colorPickerData.json"));
            objArray.add(obj.toString());
            return objArray;
        }

    }
}
