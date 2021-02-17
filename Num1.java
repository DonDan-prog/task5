import java.util.Arrays;

public class Num1
{
    public static void main(String[] args)
    {
        int[] test2 = { 72, 33, -73, 84, -12, -3, 13, -13, -68 };

        System.out.println("encrypt(\"Hello\") -> " + Arrays.toString(encrypt("Hello")));
        System.out.println("decrypt([ 72, 33, -73, 84, -12, -3, 13, -13, -68 ]) -> " + decrypt(test2));
        System.out.println("encrypt(\"Sunshine\") -> " + Arrays.toString(encrypt("Sunshine")));
    }
    public static int[] encrypt(String text)
    {
        int[] encrypted = new int[text.length()];
        int dependecy = 0;
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            encrypted[i] = c - dependecy;
            dependecy = (int)c;
        }
        return encrypted;
    }
    public static String decrypt(int[] input)
    {
        String temp = "";
        int dependecy = 0;
        for(int i = 0; i < input.length; i++)
        {
            char c = (char)(input[i] + dependecy);
            temp += c;
            dependecy = c;
        }
        return temp;
    }
}