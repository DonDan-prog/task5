public class Num2 
{
    public static void main(String[] args)
    {
        System.out.println("canMove(\"Rook\", \"A8\", \"H8\") -> " + canMove("Rook", "A8", "H8"));
        System.out.println("canMove(\"Bishop\", \"A7\", \"G1\") -> " + canMove("Bishop", "A7", "G1"));
        System.out.println("canMove(\"Queen\", \"C4\", \"D6\") -> " + canMove("Queen", "C4", "D6"));
    }

    public static boolean canMove(String figure, String pos1, String pos2)
    {
        switch(figure)
        {
            case "Pawn":
                return Pawn.checkMove(pos1, pos2);
            case "Knight":
                return Knight.checkMove(pos1, pos2);
            case "Bishop":
                return Bishop.checkMove(pos1, pos2);
            case "Rook":
                return Rook.checkMove(pos1, pos2);
            case "Queen":
                return Queen.checkMove(pos1, pos2);
            case "King":
                return King.checkMove(pos1, pos2);
            default:
                System.out.println("Undefined figure");
                return false;
        }
    }
    private static class Pawn
    {
        public static boolean checkMove(String pos1, String pos2)
        {
            char literal1 = pos1.charAt(0);
            int digit1 = pos1.charAt(1) - '0';
            
            char literal2 = pos2.charAt(0);
            int digit2 = pos2.charAt(1) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if((difference_digit == 2 || difference_digit == 1) && difference_literal == 0)
                return true;
            return false;
        }
    }
    private static class Knight
    {
        public static boolean checkMove(String pos1, String pos2)
        {
            char literal1 = pos1.charAt(0);
            int digit1 = pos1.charAt(1) - '0';
            
            char literal2 = pos2.charAt(0);
            int digit2 = pos2.charAt(1) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if(Math.abs(difference_digit) == 2 && Math.abs(difference_literal) == 1)
                return true;

            return false;
        }
    }
    private static class Bishop
    {
        public static boolean checkMove(String pos1, String pos2)
        {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';
            
            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if(Math.abs(difference_digit) == Math.abs(difference_literal))
                return true;
            return false;
        }
    }
    private static class Rook
    {
        public static boolean checkMove(String pos1, String pos2)
        {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';
            
            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if((difference_digit == 0 && difference_literal < 8) || (difference_digit < 8 && difference_literal == 0))
                return true;
            return false;
        }
    }
    private static class Queen
    {
        public static boolean checkMove(String pos1, String pos2)
        {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';
            
            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if((difference_digit == 0 && difference_literal < 8) 
            || (difference_digit < 8 && difference_literal == 0) 
            || (Math.abs(difference_digit) == Math.abs(difference_literal)))
                return true;
            return false;
        }
    }
    private static class King
    {
        public static boolean checkMove(String pos1, String pos2)
        {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';
            
            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if(Math.abs(difference_literal) == 1 || Math.abs(difference_digit) == 1)
                return true;
            return false;
        }
    }
}
