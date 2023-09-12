import java.util.ArrayList;

public class GrayCodes {

        /* if n = 1 make list L containing bit strings 0 and 1 in this order
        else generate list L1 of bit strings of size n − 1 by calling BRGC(n − 1)
        copy list L1 to list L2 in reversed order add 0 in front of each bit string in list
        L1 add 1 in front of each bit string in list L2 append L2 to L1 to get list L
        return L
        - from textbook
         */

    public static void grayCodesAreFun(int subsetOfKids) {
        int k;
        int l;
        ArrayList<String> codes;
        codes = new ArrayList<String>();

        codes.add("0");
        codes.add("1");

        if (subsetOfKids <= 0)
            return; // subsetOfKids obviously cannot be negative OR equal to 0

        //NOTE: the >> signifies bitwise operators to shift right

        for (k = 2; k < (1 << subsetOfKids); k = k << 1) {
            for (l = k - 1; l >= 0; l--)
                codes.add(codes.get(l));
            for (l = 0; l < k; l++)
                codes.set(l, "0" + codes.get(l));
            for (l = k; l < 2 * k; l++)
                codes.set(l, "1" + codes.get(l));
        }
        for (k = 0; k < codes.size(); k++)
            System.out.println(codes.get(k));// prints out the gray code
    }

    public static void main(String[] args) {
        grayCodesAreFun(4);
    }
}

