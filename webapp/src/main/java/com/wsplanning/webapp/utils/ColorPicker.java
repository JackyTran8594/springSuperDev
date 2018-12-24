package com.wsplanning.webapp.utils;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import org.springframework.boot.json.JsonParser;




public class ColorPicker {
    
    public static void jsonFileColorThemes(JsonObject obj) throws IOException {
        Path file = Paths.get("src/main/resources/static/colorPickerData.json");
        
        JsonReader reader = Json. 
        if (file == null) {
            FileWriter jsonfile = new FileWriter(file.toString());
            jsonfile.write(obj.toString());
            jsonfile.flush();
        }
        else {

        }

    }
}
