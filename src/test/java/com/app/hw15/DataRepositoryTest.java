package com.app.hw15;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class DataRepositoryTest {
    @Test
    @Tag("DataRepository")
    @Description("get Map of users")
    void getData() {
        assertNotNull(new DataRepository().getData());
        assertEquals(new DataRepository().getData(), new DataRepository().getData());
    }
}
