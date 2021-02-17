import java.util.*;

public class Num5 
{
    public static void main(String[] args)
    {
        String[] test1 = { "toe", "ocelot", "maniac" };
        String[] test2 = { "many", "carriage", "emit", "apricot", "animal" };
        String[] test3 = { "hoops", "chuff", "bot", "bottom" };

        System.out.println("sameVowelGroup([\"toe\", \"ocelot\", \"maniac\"]) -> " + sameVowelGroup(test1));
        System.out.println("sameVowelGroup([\"many\", \"carriage\", \"emit\", \"apricot\", \"animal\"]) -> " + sameVowelGroup(test2));
        System.out.println("sameVowelGroup([\"hoops\", \"chuff\", \"bot\", \"bottom\"]) -> " + sameVowelGroup(test3));
    }   
    /** 
     * Made using default Java collections; 
     * HashSet provides the equality to check if sets equal regardless 
     * the order of elements and add function which add only unique elements 
     * */
    public static ArrayList<String> sameVowelGroup(String[] arr)    
    {
        final String VOWELS = "aeiouy";
        HashSet<Character> vowelsSet = new HashSet<>();
        String word = arr[0];

        // Extract vowels from first word
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int indexInVOWELS = VOWELS.indexOf(c);
            if(indexInVOWELS != -1) vowelsSet.add(c);
        }

        ArrayList<String> ret = new ArrayList<>();
        for(String s : arr)
        {
            HashSet<Character> check = new HashSet<>();
            for(int i = 0; i < s.length(); ++i)
            {
                char c = s.charAt(i);
                int index = VOWELS.indexOf(c);
                if(index != -1)
                    check.add(c);
            }
            if(check.equals(vowelsSet) == true)
                ret.add(s);
        }        

        return ret;
    } 
}