package com.thewhite.study;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class Reader {
    public static Map<Integer, Note> read(String pathData) {
        Type paramsMapType = new TypeToken<Map<Integer, Note>>() {}.getType();
        Map<Integer, Note> notes;
        try {
            notes = new Gson().fromJson(new FileReader(pathData), paramsMapType);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }
}
