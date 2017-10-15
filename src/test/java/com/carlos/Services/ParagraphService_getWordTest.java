package com.carlos.Services;

import com.carlos.Services.impl.LineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class ParagraphService_getWordTest {

    LineService lineService;

    @Before
    public void setUp() {
        lineService = new LineServiceImpl();
    }

    @Test
    public void getwordWithSingleSpacedLine_shouldReturnWordAtGivenPositionOfUnjustifiedLine() throws Exception {
        // Given
        String line = "This is a test";

        // When
        String word0 = lineService.getWord(line,0);
        String word1 = lineService.getWord(line,1);
        String word2 = lineService.getWord(line,2);
        String word3 = lineService.getWord(line,3);

        // Verify
        Assert.assertEquals(word0, "This");
        Assert.assertEquals(word1, "is");
        Assert.assertEquals(word2, "a");
        Assert.assertEquals(word3, "test");
    }

    @Test
    public void getWordWidthMultipleSpacedLined_shouldReturnWordAtGivenPositionOfSingleWordLines() throws Exception {
        // Given
        String line = "This  is    a   test";

        // When
        String word0 = lineService.getWord(line,0);
        String word1 = lineService.getWord(line,1);
        String word2 = lineService.getWord(line,2);
        String word3 = lineService.getWord(line,3);

        // Verify
        Assert.assertEquals(word0, "This");
        Assert.assertEquals(word1, "is");
        Assert.assertEquals(word2, "a");
        Assert.assertEquals(word3, "test");
    }

    @Test(expected = Exception.class)
    public void getWordWithWronPosition_shouldThrowExceptionWhenPositionLessThan0() throws Exception {
        // Given
        String line = "This  is    a   test";

        // When
        String word0 = lineService.getWord(line,-1);
    }

    @Test(expected = Exception.class)
    public void getWordWithWronPosition_shouldThrowExceptionWhenPositionGreaterThanWordsNumber() throws Exception {
        // Given
        String line = "This  is    a   test";

        // When
        String word0 = lineService.getWord(line,4);
    }

    @Test
    public void getWords_shouldReturnListOfWordsWhenLineIsJustified() {
        // Given
        String line = "This  is    a   test";

        // When
        List<String> words = lineService.getWords(line);

        // Verify
        Assert.assertEquals(words.get(0), "This");
        Assert.assertEquals(words.get(1), "is");
        Assert.assertEquals(words.get(2), "a");
        Assert.assertEquals(words.get(3), "test");
    }
}
