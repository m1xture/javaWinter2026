package com.app.hw14;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DataRepositoryTest {
    @Test
    @Tag("DataRepository")
    @Description("get data")
    void getData() {
        assertEquals(new DataRepository().getData(), new DataRepository().getData());
    }
}
