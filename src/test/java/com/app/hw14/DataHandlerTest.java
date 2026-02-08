package com.app.hw14;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataHandlerTest {
    public List<String> data;

    @BeforeEach
    void initializeData() {
        data = new DataRepository().getData();
    }

    @Test
    @Tag("DataHandler")
    @Description("form output")
    void formOutput() {
        DataHandler dataHandler = new DataHandler();
        assertEquals(dataHandler.formOutput(data, 0), dataHandler.formOutput(data, 0));
        assertNotEquals(dataHandler.formOutput(data, 1), dataHandler.formOutput(data, 0));
        assertEquals("Wrong index!", dataHandler.formOutput(data, data.size() + 1));
    }

    @Test
    @Tag("DataHandler")
    @Description("form list output")
    void formListOutput() {
        DataHandler dataHandler = new DataHandler();

        assertNotNull(dataHandler.formListOutput(data));
        assertEquals(dataHandler.formListOutput(data), dataHandler.formListOutput(data));

    }
}
