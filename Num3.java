public class Num3 
{
    public static void main(String[] args)
    {
        System.out.println("canComplete(\"butl\", \"beautiful\") -> " + canComplete("butl", "beautiful"));
        System.out.println("canComplete(\"butlz\", \"beautiful\") -> " + canComplete("butlz", "beautiful"));
        System.out.println("canComplete(\"tulb\", \"beautiful\") -> " + canComplete("bbutl", "beautiful"));
        System.out.println("canComplete(\"bbutl\", \"beautiful\") -> " + canComplete("tulb", "beautiful"));
    }   
    
    public static boolean canComplete(String str, final String input)
    {
        // Check order
        int pos = -2;
        for(int i = 0; i < str.length(); i++)
        {
            int index = input.indexOf(str.charAt(i));    // get index of another character
            if(index <= pos) // if pos of current character lower than prev, then order is broken
                return false;
            else
                pos = index;
        }
        // check if characters actually in input
        for(int i = 0; i < str.length(); i++)
        {
            if(input.indexOf(str.charAt(i)) == -1)
                return false;
        }
        return true;
    }
}
