public class Num9 
{
    public static void main(String[] args)
    {
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
    }
    public static String correctTitle(String string)
    {
        return correctOne(string, " ");
    }
    public static String correctOne(String string, String delimiter)
    {
        final String immutable = "ANDINTHEOF";
        
        String[] words = string.split(delimiter);

        for(int i = 0; i < words.length; i++)
        {
            String s = words[i];
            if(s.indexOf('-') == -1)
            {
                int index = immutable.indexOf(s.toUpperCase());
                if(index == -1)
                {
                    String newString = Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
                    words[i] = newString;
                }
                else
                    words[i] = s.toLowerCase();
            }
            else
            {
                words[i] = correctOne(s, "-");
            }
        }

        String ret = "";
        for(int i = 0; i < words.length; i++)
        {
            ret += words[i];
            if(i + 1 < words.length)
                ret += delimiter; 
        }
        return ret;
    }
}