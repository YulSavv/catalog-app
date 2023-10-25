package com.thewhite.study;


import java.util.Map;
import java.util.ArrayList;

public class DataStore {
    Map<Integer, Note> notes;

    public Map<Integer, Note> getNotes() {
        return notes;
    }

    public DataStore() {
        notes = Reader.read("src/main/resources/data.json");
    }

    public DataStore(Map<Integer, Note> notes) {
        this.notes = notes;
    }

    public DataStore(String pathData) {
        notes = Reader.read(pathData);
    }

    public String getNoteById(int id) {
        if (notes.containsKey(id))
            return String.valueOf(notes.get(id).getFullNote());
        else
            return null;
    }

    public ArrayList<Note> getNoteByPartName(String partName) {
        ArrayList<Note> result = new ArrayList<>();
        for (Map.Entry<Integer, Note> note: notes.entrySet()) {
            if(note.getValue().getName().contains(partName.toLowerCase()))
                result.add(note.getValue());
        }
        return result;
    }

}
