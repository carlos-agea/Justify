package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineService_getSpacesTest {

    LineService lineService;

    @Before
    public void setUp() {
        lineService = new LineServiceImpl();
    }

    @Test
    public void getSpaces_shouldCount4Spaces() {
        // Wen
        Integer spacesNumber = lineService.getSpacesNumber("Hello my name is Carlos");

        // Verify
        Assert.assertEquals(spacesNumber, Integer.valueOf(4));
    }

    @Test
    public void getSpaces_shouldCount5Spaces() {
        // Wen
        Integer spacesNumber = lineService.getSpacesNumber("Hello my name is  Carlos");

        // Verify
        Assert.assertEquals(spacesNumber, Integer.valueOf(5));
    }

}
