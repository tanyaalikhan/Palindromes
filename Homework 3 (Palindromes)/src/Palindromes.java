import java.util.Arrays;
import java.util.Scanner;

public class Palindromes {

    public static boolean palindromeCheck(String phrase) {
        phrase = phrase.toLowerCase().replaceAll("\\s", "");

        boolean case1 = (phrase.length() == 0 || phrase.length() == 1);         // first case that makes it a palindrome
        boolean case2 = phrase.charAt(0) == phrase.charAt(phrase.length() - 1); // second case that makes it a palindrome
        // boolean case2 will check if the characters are the same from outward to inward-- when we call the method recursively
        // with this case and the original phrase, we will have a palindrome
        // if neither case1 or 2, the method will return false in this method-- in the main method we will say with a print statement
        // that the string is not a palindrome

        if (case1) {
            return true;
        }
        if (case2) {
            return palindromeCheck((phrase.substring(1, phrase.length() - 1)));
        }
        return false;
    }

    public static void easyInversionCount(int [] A){    // 2 for-loops means O(n^2) time complexity
        int ctr = 0;                                    // initializing counter var to 0 since we're going to be updating it later
        for (int i = 0; i < A.length; i++) {            // incrementing through the i subset
            for (int j = i + 1; j < A.length; j++) {    // incrementing through the j subset
                if (A[i] > A[j]) {                      // this is what we're told an inversion is from the assignment, so we're making it a condition
                    ctr = ctr + 1;                      // updating the count if conditional above is satisfied
                }
            }
        }
        System.out.println(ctr);                        // prints count once loops are exited
    }

    private static int fastInversionCountHelper(int[] arrayOfNums, int l, int m, int r) {

        int[] left = Arrays.copyOfRange(arrayOfNums, l, m + 1);
        int[] right = Arrays.copyOfRange(arrayOfNums, m + 1, r + 1);

        int i = 0;
        int j = 0;
        int k = l;
        int numOfSwaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arrayOfNums[k++] = left[i++];
            else {
                arrayOfNums[k++] = right[j++];
                numOfSwaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arrayOfNums[k++] = left[i++];
        while (j < right.length)
            arrayOfNums[k++] = right[j++];

        return numOfSwaps;
    }

    public static int fastInversionCount(int[] array, int left, int right) {
        int ctr = 0;

        if (left < right) {
            int middle = (left + right) / 2;
            ctr += fastInversionCount(array, left, middle);
            ctr += fastInversionCount(array, middle + 1, right);
            ctr += fastInversionCountHelper(array, left, middle, right);
        }

        System.out.println(ctr);
        return ctr;

        //please note: collaborated with peers, asked TAs for help, and used the sources
        //recommended by TAs for the mergeSort algorithm (fastInversionCount)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palindrome check time! Type in your string:  ");
        String phrase = scanner.nextLine();

        if (palindromeCheck(phrase))
            System.out.println(phrase + " is a palindrome");
        else
            System.out.println(phrase + " is not a palindrome");

        int[] sampleArray1 = new int[] { 3,2,1};
        easyInversionCount(sampleArray1);
        int[] sampleArray2 = new int[] {6, 4, 5, 2, 7};
        easyInversionCount(sampleArray2);
    }
}

