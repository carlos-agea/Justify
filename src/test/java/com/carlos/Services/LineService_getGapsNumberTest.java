package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineService_getGapsNumberTest {

    LineService lineService;

    @Before
    public void setUp() {
        lineService = new LineServiceImpl();
    }

    @Test
    public void whenGapsHaveMultipleSpaces_thenTheyShouldBeMerged() {
        // Given
        String line = "This  is a   test";

        // Wen
        Integer gapsNumber = lineService.getGapsNumber(line);

        // Verify
        Assert.assertEquals(gapsNumber, Integer.valueOf(3));
    }
}
