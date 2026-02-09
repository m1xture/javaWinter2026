package com.app.hw15;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DataHandlerTest {

    DataHandler dataHandler;

    @BeforeEach
    void initializeDataHandler() {
        dataHandler = new DataHandler();
    }

    @Test
    @Tag("DataHandlerTest")
    @Description("list all users in string")
    void getAll() {
        assertNotNull(dataHandler.getAll());
        assertEquals(dataHandler.getAll(), dataHandler.getAll());
    }

    @Test
    @Tag("DataHandlerTest")
    @Description("get user by id")
    void getById() {
        assertEquals("No data!", dataHandler.getById(Integer.valueOf(-1)));
        assertEquals(dataHandler.getById(137), dataHandler.getById(137));
    }
}
