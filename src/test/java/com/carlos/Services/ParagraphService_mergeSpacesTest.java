package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphService_mergeSpacesTest {

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
        String result = lineService.mergeSpaces(line);

        // Verify
        Assert.assertEquals(result, "This is a test");
    }
}
