public class Num10 
{
    public static void main(String[] args)
    {
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
        System.out.println(hexLattice(37));
    }
    public static String hexLattice(int n)
    {
        if(isCentered(n) == false)
            return "Invalid";
        /** If n is valid, then find the number in row */
        int c = 1;
        for(; 3 * c * (c - 1) + 1 != n; c++);
        /** c - is number in center hex row, and formula 2 *(c-1) + 1 - odd number, that give number of columns */
        int[] columns = columns(2 * (c - 1) + 1);
        /** finding max elements in row */
        int max = Integer.MIN_VALUE;    
        for(int i = 0; i < columns.length; i++)
        {
            if(columns[i] > max)
                max = columns[i];
        }

        /** Filling the string */
        String ret = "";
        final String EMPTY = " ";
        final String SPOT = " o";
        for(int i = 0; i < columns.length; i++)
        {
            int space = (max - columns[i]); // taking amount of spaces
            for(int j = 0; j < space; j++) ret += EMPTY;    // first padding
            for(int j = 0; j < columns[i]; j++) ret += SPOT;   // next fill with stars
            for(int j = 0; j < space; j++) ret += EMPTY;    // last - another padding
            ret += '\n';
        }
        return ret;
    }
    /** Fil number of spots in column */
    public static int[] columns(int n) 
    {
        int[] columns = new int[n];
        int h = (int)Math.floor(n / 2);
            
        for (int i = 0; i < n; i++)
            columns[i] = n - Math.abs(i - h);
    
        return columns;
    }
    /** Mathematical way to check is this number centered */
    public static boolean isCentered(int n)
    {
        double val = 4. * (n - 1) / 3.;
        double D = 1 + val;
        return D % 1 == 0;
    }
}
