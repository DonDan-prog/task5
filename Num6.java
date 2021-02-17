public class Num6 
{
    public static void main(String[] args)
    {
        System.out.println("validateCard(1234567890123456) -> " + validateCard(1234567890123456L));
        System.out.println("validateCard(1234567890123452) -> " + validateCard(1234567890123452L));
    }
    /** Realization using String */
    public static boolean validateCard(final long cardLong)
    {  
        final String card = Long.toString(cardLong);
        int cardLen = card.length();
        // Length of card number must be from 14 to 19
        if(cardLen < 14 || cardLen > 19)
            return false;
        // Luna's test
        String reversedString = card.substring(0, cardLen - 1);
        int checkDigit = card.charAt(cardLen - 1) - '0';

        reversedString = reverseString(reversedString);
        cardLen = reversedString.length();

        int[] massive = new int[cardLen];
        int sum = 0;
        for(int i = 0; i < cardLen; i++) massive[i] = reversedString.charAt(i) - '0';
        for(int i = 0; i < cardLen; i += 2) 
        {
            massive[i] <<= 1; // doubled val
            if(massive[i] > 9)  // because of n to be digit, max doubled is 9 * 2 = 18
                massive[i] = massive[i] % 10 + massive[i] / 10;
        }
        for(int i = 0; i < cardLen; i++)
            sum += massive[i];

        int check = 10 - sum % 10;
        if(check == checkDigit)
            return true;
        return false;
    }
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
      }
}
