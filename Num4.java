public class Num4 
{
    public static void main(String[] args)
    {
        System.out.println("sumDigProd(16, 28) -> " + sumDigProd(16, 28));
        System.out.println("sumDigProd(0) -> " + sumDigProd(0));
        System.out.println("sumDigProd(1, 2, 3, 4, 5, 6) -> " + sumDigProd(1, 2, 3, 4, 5, 6));
    }
    public static int sumDigProd(int ... v)
    {
        int ret = 0;
        for(int i = 0; i < v.length; i++) ret += v[i];

        int new_n = ret;
        while(new_n > 10)
        {
            int temp = new_n;
            new_n = 1;
            while(temp > 0)
            {
                new_n *= temp % 10;
                temp /= 10;
            }
        } 
        return new_n;
    }    
}
