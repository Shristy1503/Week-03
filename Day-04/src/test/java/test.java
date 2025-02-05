import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import stringbuffer.concatenatestrings.*;
import filereader.counttheoccurrenceofawordinfile.*;
import stringbuilder.removeduplicate.*;
import stringbuilder.reverseastring.*;


public class test {
    //testing remove duplicate from string code
    @Test
    void testRemoveduplicate(){
        assertEquals(RemoveDuplicate.removeDuplicate(new String("shristy")), "shrity");
    }

    //testing concatenate string
    @Test
    void testConcatenateString(){
        assertEquals(ConcatenateString.concatenate(new String[]{"shristy", " mishra"}), "shristy mishra");
    }
    //testing reverse string
    @Test
    void testReverseString(){
        assertEquals(ReverseAString.reverseString("shristy"), "ytsirhs");
    }
    //testing count the occurrance of a word in file
    @Test
    void testCountOccurrenceOfWord(){
        assertEquals(CountTheOccurrenceOfAWord.countWordOccurrence("src/sample.txt", "pets"), 3);
    }
}
