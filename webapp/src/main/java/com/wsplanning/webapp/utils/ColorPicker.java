package com.wsplanning.webapp.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import groovyjarjarcommonscli.ParseException;

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

            JsonParser parser = new JsonParser();
            Object object = parser.parse(new FileReader(file.toString()));
            JsonObject jsonObject = (JsonObject) object;
            // jsonObject.
            objArray = jsonObject.getAsJsonArray();
            objArray.forEach(item -> {
                
                if (item.getAsJsonObject().get("username").toString() == obj.username) {
                    // item.getAsJsonObject().get("colorCode").
                }
            });
            // objArray.
            // objArray.add(obj.toString());
            return objArray;
        }

    }
}
