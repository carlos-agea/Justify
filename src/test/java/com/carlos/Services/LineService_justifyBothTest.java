package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineService_justifyBothTest {

    LineService lineService;

    @Before
    public void setUp() {
        lineService = new LineServiceImpl();
    }

    @Test
    public void whenJustifyBoth_thenLineShouldBeCompleteJustified() {
        // Given
        String line0 = "Here is an example";
        String line1 = "Here";
        String line2 = "";

        // Wen
        String newLine0 = lineService.justifyBoth(line0, 22);
        String newLine1 = lineService.justifyBoth(line1, 22);
        String newLine2 = lineService.justifyBoth(line2, 22);

        // Verify
        Assert.assertEquals(newLine0, "Here   is  an  example");
        Assert.assertEquals(newLine1, "Here");
        Assert.assertEquals(newLine2, "");
    }

    @Test
    public void whenJustifyBothLongerLine_thenItShouldNotBeTruncated() {
        // Given
        String line3 = "Here is a very very long example";

        // Wen
        String newLine3 = lineService.justifyBoth(line3, 22);

        // Verify
        Assert.assertEquals(newLine3, "Here is a very very long example");
    }
}
