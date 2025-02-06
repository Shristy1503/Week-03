import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import binarysearch.findrotationpointinarotatedsortedarray.*;
import binarysearch.findthepeakelementinanarray.*;
import binarysearch.searchforatargetin2dsortedmatrix.*;
import binarysearch.findfirstandlastoccurranceofelement.*;
import linearsearch.searchforaspecificword.*;
import linearsearch.searchforfirstnegativenumber.*;
import challenegproblem.*;
public class test {
    //testing linear search for first negative number in array
    @Test
    void testSearchNegativeNumber(){
        assertEquals(SearchForTheFirstNegativeNumber.linearSearch(new int[]{1, 2, 6, -1, 8, 9}), 3);
    }

    //testing linear search to find a specific word in list of sentences
    @Test
    void testSearchSpecificWord(){
        assertEquals(SearchForSpecificWordInListOfSentences.linearSearch(new String[]{"where is your home located", "it was down the alley i guess"}, "your"), "where is your home located" );
    }
    //testing binary search to search the peak element
    @Test
    void testSearchPeakElement(){
        assertEquals(FindThePeakElement.binarySearch(new int[]{3, 2, 6, 4, 7, 10, 9}), 5);
    }
    //testing binary search to search the rotation point in rotated sorted array
    @Test
    void testSearchRotationPoint(){
        assertEquals(FindTheRotationPoint.binarySearch(new int[]{11, 12, 4, 5, 7, 9, 10}), 2);
    }
    //testing binary search to search the target in 2d sorted matrix
    @Test
    void testSearchTargetIn2dMatrix(){
        assertEquals(SearchForATargetValue.binarySearch(new int[][]{{1, 3, 6, 9},
                {10, 11, 18, 20},
                {23, 31, 39, 40}}, 3),true );
    }
    //testing binary search to search the first occurrence of element
    @Test
    void testForFirstOccurrence(){
        assertEquals(FindTheFirstAndLastOccurrenceOfElement.findFirst(new int[]{1, 4, 4, 6, 8, 8}, 4), 1);
    }
    //testing binary search to search the last occurrence of element
    @Test
    void testForLastOccurrence(){
        assertEquals(FindTheFirstAndLastOccurrenceOfElement.findLast(new int[]{1, 4, 4, 6, 8, 8}, 4), 2);
    }
    //testing binary and linear for challenge problem
    @Test
    void testChallengeProblem1(){
        assertEquals(LinearAndBinarySearch.findFirstMissingPositive(new int[]{2, 6, 4, 5, -1, 7}), 1);
    }
    //testing binary and linear for challenge problem
    @Test
    void testChallengeProblem2(){
        assertEquals(LinearAndBinarySearch.binarySearch(new int[]{2, 6, 4, 5, -1, 7}, 4), 2);
    }
}
