public class Num7 
{
    public static void main(String[] args)
    {
        System.out.println("numToEng(0) -> " + numToEng(0));
        System.out.println("numToEng(18) -> " + numToEng(18));
        System.out.println("numToEng(126) -> " + numToEng(126));
        System.out.println("numToEng(909) -> " + numToEng(909));
    }
    public static String numToEng(int n)
    {
        final String[] list1 = { "one", "two", "three", "four", "five", "six", "seven", "eight",
                                 "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                                 "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        final String[] list2 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                                "eighty", "ninety"};

        String ret = "";
        int nDivide = n / 100;
        int nMod = n % 100;
        if(n == 0)
            return "zero";
        if(nDivide != 0 && nMod != 0)
            ret = String.format("%s hundred ", list1[nDivide - 1]);
        else if(nDivide != 0)
            ret = String.format("%s hundred", list1[nDivide - 1]);
        if(nMod <= 19)
            ret += list1[nMod - 1];
        else
            ret += list2[nMod / 10 - 2] + " " + list1[n % 10 - 1];
        return ret;
    }
    
}
