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
        for (Map.Entry<Integer, Note> resultNote: dataStoreTest.getNotes().entrySet()) {
            var keyResultNote = resultNote.getKey();
            var expectNote = storageExpect.getNotes().get(keyResultNote).getFullNote();
            assertEquals(expectNote, resultNote.getValue().getFullNote());
        }
    }

    @Test
    void printNoteByIDTest() {

        var outputExistingID  =  dataStoreTest.getNoteById(1);
        var outputUnExistingID = dataStoreTest.getNoteById(11);

        assertEquals(outputExistingID, dataStoreTest.getNotes().get(1).getFullNote());
        assertNull(outputUnExistingID);
    }
    @Test
    void printNoteByPartNameTest() {

        var outputPartNameExisting  =  dataStoreTest.getNoteByPartName("new");
        var outputPartNameUnExisting = dataStoreTest.getNoteByPartName("none");

        ArrayList<Note> expectList = new ArrayList<>();
        expectList.add(new Note(111, "new", "новое описание", "ссылка/1"));

        for (Note result: outputPartNameExisting) {
            for (Note expect: expectList) {
                assertEquals(result.getFullNote(), expect.getFullNote());
            }
        }
        assertTrue(outputPartNameUnExisting.isEmpty());
    }
}















