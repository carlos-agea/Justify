package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineService_createGapTest {

    LineService lineService;

    @Before
    public void setUp() {
        lineService = new LineServiceImpl();
    }

    @Test
    public void getSpaces_shouldCount4Spaces() {
        // Wen
        String gapStr0 = lineService.createGap(1);
        String gapStr1 = lineService.createGap(2);
        String gapStr2 = lineService.createGap(5);

        // Verify
        Assert.assertEquals(gapStr0, " ");
        Assert.assertEquals(gapStr1, "  ");
        Assert.assertEquals(gapStr2, "     ");
    }

}
