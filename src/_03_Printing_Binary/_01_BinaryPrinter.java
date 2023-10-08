package _03_Printing_Binary;

public class _01_BinaryPrinter {
    /*
     * Complete the methods below so they print the passed in parameter in binary.
     * Do not use the Integer.toBinaryString method!
     * Use the main method to test your methods.
     */

						//ONE BYTE = 8 BITS
    public static void printByteBinary(byte b) {
        // We first want to print the bit in the one's place
    	int first = b&1;
    	System.out.print(first);
  
        // Shift b seven bits to the right
    	b = (byte) (b>>1);
        // Use the & operator to "mask" the bit in the one's place
        // This can be done by "anding" (&) it with the value of 1
        // Print the result using System.out.print (NOT System.out.println)
        //Use this method to print the remaining 7 bits of b
    	for(int i = 0; i < 7; i++) {
    		System.out.print(b&1);
    		b = (byte)(b>>1);
    	}
    }
    public static void printShortBinary(short s) {
        // Create 2 byte variables
    	   byte b1 = 0;
           byte b2 = 0;
        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte
           System.out.println();
           for (int i = 0; i < 8; i++) { //first 8
               b1 = (byte) (b1 | (s & 1));  // compare 0 to 00000001
               if (i != 7 ) {
                   b1 = (byte) (b1 << 1); //keep moving b1
               }
               s = (short) (s >> 1); //keep shifting s
           }

           for (int i = 0; i < 8; i++) {
               b2 = (byte) (b2 | (s & 1));
               if (i < 7) {
                   b2 = (byte) (b2 << 1); 
               }
               s = (short) (s >> 1); 
           }
    	
        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
        printByteBinary(b2); //second half
        printByteBinary(b1);//firt hlaf
    }
    	
   

    public static void printIntBinary(int i) {
   short one = 0;
   short two = 0;
 
   System.out.println();
   for (int j = 0; j < 16; j++) { //first 8
       one = (short) (one | (j & 1));  // compare 0 to 00000001
       if (j != 15 ) {
           one = (short) (one << 1); //keep moving b1
       }
       i = (int) (i >> 1); //keep shifting s
   }

   for (int j = 0; j < 16; j++) {
       two = (short) (two | (i & 1));
       if (j < 15) {
           two = (short) (two << 1); 
       }
       i = (int) (i >> 1); 
   }

// Call printByteBinary twice using the two bytes
// Make sure they are in the correct order
printShortBinary(two); //second half
printShortBinary(one);//firt hlaf
    }

    public static void printLongBinary(long l) {
        // Use the same method as before to complete this method
    	   int one = 0;
    	   int two = 0;
    	 
    	   System.out.println();
    	   for (int j = 0; j < 32; j++) { //first 8
    	       one = (int) (one | (j & 1));  // compare 0 to 00000001
    	       if (j != 31 ) {
    	           one = (int) (one << 1); //keep moving b1
    	       }
    	       l = (long) (l >> 1); //keep shifting s
    	   }

    	   for (int j = 0; j < 32; j++) {
    	       two = (int) (two | (l & 1));
    	       if (j < 31) {
    	           two = (int) (two << 1); 
    	       }
    	       l = (long) (l >> 1); 
    	   }

    	// Call printByteBinary twice using the two bytes
    	// Make sure they are in the correct order
    	printIntBinary(two); //second half
    	printIntBinary(one);//firt hlaf
    	
    }

    public static void main(String[] args) {
        // Test your methods here
    byte b = 3;
    short s = 5;
    int i = 4;
    long l = 5;
    	printByteBinary(b);
    	printShortBinary(s);
    	printIntBinary(i);
    	printLongBinary(l);
    }
}
