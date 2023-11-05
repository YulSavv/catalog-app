package com.thewhite.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DataStoreTest {
    private DataStore dataStoreTest;

    @BeforeEach
    public void newDataStore() {
        dataStoreTest = new DataStore("src/test/java/com/thewhite/study/dataTest.json");
    }

    @Test
    void addInStorage() {
        Map<Integer, Note> notesTest = Reader.read("src/test/java/com/thewhite/study/dataTest.json");
        DataStore storageExpect = new DataStore(notesTest);
        assertEquals(notesTest, dataStoreTest.getNotes());
    }

    @Test
    void printNoteByIDTest() {

        var outputExistingID  =  dataStoreTest.getNoteById(1);
        assertEquals(outputExistingID, dataStoreTest.getNotes().get(1).getFullNote());
    }
    @Test
    void printNoteByPartNameTest() {

        ArrayList<Note> expectList = new ArrayList<>();
        expectList.add(new Note(111, "new", "new", "new"));

        var outputPartNameExisting  =  dataStoreTest.getNoteByPartName("new");
        var outputPartNameUnExisting = dataStoreTest.getNoteByPartName("none");

        assertEquals(expectList, outputPartNameExisting);
        assertTrue(outputPartNameUnExisting.isEmpty());

    }
}















