public class Num8 
{
    public static void main(String[] args)
    {
        System.out.println("getSha256Hash(\"password123\") -> " + getSha256Hash("password123"));
        System.out.println("getSha256Hash(\"Fluffy@home\") -> " + getSha256Hash("Fluffy@home"));
        System.out.println("getSha256Hash(\"Hey dude!\") -> " + getSha256Hash("Hey dude!"));
    }

    public static String getSha256Hash(final String input)
    {
        /** 64 constants of SHA256 */
        final int[] K = { 0x428A2F98, 0x71374491, 0xB5C0FBCF, 0xE9B5DBA5, 0x3956C25B, 0x59F111F1, 0x923F82A4, 0xAB1C5ED5,
            0xD807AA98, 0x12835B01, 0x243185BE, 0x550C7DC3, 0x72BE5D74, 0x80DEB1FE, 0x9BDC06A7, 0xC19BF174,
            0xE49B69C1, 0xEFBE4786, 0x0FC19DC6, 0x240CA1CC, 0x2DE92C6F, 0x4A7484AA, 0x5CB0A9DC, 0x76F988DA,
            0x983E5152, 0xA831C66D, 0xB00327C8, 0xBF597FC7, 0xC6E00BF3, 0xD5A79147, 0x06CA6351, 0x14292967,
            0x27B70A85, 0x2E1B2138, 0x4D2C6DFC, 0x53380D13, 0x650A7354, 0x766A0ABB, 0x81C2C92E, 0x92722C85,
            0xA2BFE8A1, 0xA81A664B, 0xC24B8B70, 0xC76C51A3, 0xD192E819, 0xD6990624, 0xF40E3585, 0x106AA070,
            0x19A4C116, 0x1E376C08, 0x2748774C, 0x34B0BCB5, 0x391C0CB3, 0x4ED8AA4A, 0x5B9CCA4F, 0x682E6FF3,
            0x748F82EE, 0x78A5636F, 0x84C87814, 0x8CC70208, 0x90BEFFFA, 0xA4506CEB, 0xBEF9A3F7, 0xC67178F2
        };
        /** Initial context */
        int[] H = { 0x6A09E667, 0xBB67AE85, 0x3C6EF372, 0xA54FF53A, 0x510E527F, 0x9B05688C, 0x1F83D9AB, 0x5BE0CD19 };
        /** Hashing block */
        int[] W = new int[64];
        
        /** Now we padding the input */
        final int BLOCKSIZE = 512; // bits
        final int CHARSIZE = 8; // bits
        final int ADDITIONBITS = 1 + 64; // bits
        /** Calculate size for BitSet that can contain our input + 1 bit + 8 bit of size in bits */
        int fullSizeInBits = input.length() * CHARSIZE + ADDITIONBITS;
        int calculatedBits = (int)(Math.ceil((double)fullSizeInBits / BLOCKSIZE) * BLOCKSIZE);
        /** Allocate array for the whole SHA256 message buffer, in BYTES */
        int[] byteString = new int[calculatedBits / 8];
        int inputLen = input.length();
        /** Fill byte array with ASCII codes of input string */
        for(int i = 0; i < inputLen; i++)
            byteString[i] = (int)input.charAt(i);
        byteString[inputLen] = -128; // it's 10000000, because Java's byte is [-128;127]
        for(int i = inputLen + 1; i < calculatedBits / 8 - 8; i++)
            byteString[i] = 0;
        /** Adding in the end the size of input in bits */
        long longSizeInput = inputLen * 8;
        for(int i = 0, j = byteString.length - 1; i < 8; i++, j--)
            byteString[j] = (int)(longSizeInput >> (8 * i));

        /** We done with preparation, next task - implement hashing */
        for(int j = 0; j < byteString.length; j += BLOCKSIZE / 8)
        {
            /** Initializing first block with 32 bit words; because we using byte == 8 bit, we need 4 bytes to be added
             * but I used bit or because we shift each byte, so bit or will operate excatly like addition.
             * Also, because of lack of choosing negativity of the byte, we need to force the all to be unsigned, for that we do "0xff &" as it set the sign bit to be positive
             */
            for(int i = 0; i < 16; i++)
                W[i] = ((0xff & byteString[j + i * 4]) << 24) | ((0xff & byteString[j + i * 4 + 1]) << 16) | ((0xff & byteString[j + i * 4 + 2]) << 8) | ((0xff & byteString[j + i * 4 + 3]) << 0);
            for(int i = 16; i < 64; i++)
            {
                int s0 = Integer.rotateRight(W[i-15], 7) ^ Integer.rotateRight(W[i-15], 18) ^ (W[i-15] >>> 3);
                int s1 = Integer.rotateRight(W[i-2], 17) ^ Integer.rotateRight(W[i-2], 19) ^ (W[i-2] >>> 10);
                W[i] = W[i-16] + s0 + W[i-7] + s1;
            }
            /** Just repeat psuedo-code from Wiki */
            int a = H[0];
            int b = H[1];
            int c = H[2];
            int d = H[3];
            int e = H[4];
            int f = H[5];
            int g = H[6];
            int h = H[7];
            for(int i = 0; i < 64; i++)
            {
                int sigma0 = (Integer.rotateRight(a, 2) ^ Integer.rotateRight(a, 13) ^ Integer.rotateRight(a, 22));
                int Ma = ((a & b) ^ (a & c) ^ (b & c));
                int t2 = sigma0 + Ma;
                int sigma1 = (Integer.rotateRight(e, 6) ^ Integer.rotateRight(e, 11) ^ Integer.rotateRight(e, 25));
                int Ch = ((e & f) ^ ((~e) & g));
                int t1 = h + sigma1 + Ch + K[i] + W[i];

                h = g;
                g = f;
                f = e;
                e = d + t1;
                d = c;
                c = b;
                b = a;
                a = t1 + t2;
            }
            H[0] += a;
            H[1] += b;
            H[2] += c;
            H[3] += d;
            H[4] += e;
            H[5] += f;
            H[6] += g;
            H[7] += h;
        }
        String digestString = "";
        for(int i = 0; i < H.length; i++)
            digestString += Integer.toHexString(H[i]);
        return digestString;
    }
}