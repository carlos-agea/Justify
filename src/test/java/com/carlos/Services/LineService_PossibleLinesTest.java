package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class LineService_PossibleLinesTest {

    LineService lineService;

    @Before
    public void setUp() {
        lineService = new LineServiceImpl();
    }

    @Test
    public void getPossibleLines_shouldReturnAllPossibleLines() {
        // Given
        String line = "This is a test";

        // Wen
        List<String> lines = lineService.getPossibleLines(line);

        // Verify
        Assert.assertEquals(lines.size(), 4);
        Assert.assertTrue(lines.get(0).equals("This"));
        Assert.assertTrue(lines.get(1).equals("This is"));
        Assert.assertTrue(lines.get(2).equals("This is a"));
        Assert.assertTrue(lines.get(3).equals("This is a test"));
    }

}
