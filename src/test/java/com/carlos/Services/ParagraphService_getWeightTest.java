package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphService_getWeightTest {

    LineService lineService;

    @Before
    public void setUp() {
        lineService = new LineServiceImpl();
    }

    @Test
    public void getWeight_shouldReturnWeightOfLine() throws Exception {
        // Given
        String line0 = "This is a test";
        String line1 = "This  is a test";
        String line2 = "This is  a test";
        String line3 = "This  is a   test";

        // When
        Integer weight0 = lineService.getWeight(line0);
        Integer weight1 = lineService.getWeight(line1);
        Integer weight2 = lineService.getWeight(line2);
        Integer weight3 = lineService.getWeight(line3);

        // Verify
        Assert.assertEquals(weight0, new Integer(0));
        Assert.assertEquals(weight1, new Integer(1));
        Assert.assertEquals(weight2, new Integer(1));
        Assert.assertEquals(weight3, new Integer(5));

    }

}
