package _02_AND_OR_and_XOR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;

import org.junit.jupiter.api.Test;

/*
 * Goal: Implement left and right rotate methods.
 * 
 * Inherently Java doesn't have an instruction to perform left or right
 * rotates (though there are rotate functions in the Integer class).
 * 
 * A rotate is when a bit is shifted outside the width of the variable and is
 * placed on the other side. Here is an example of a right rotate on int 7
 * by 1:
 *      00000000 00000000 00000000 00000111   // original value of 7
 *      10000000 00000000 00000000 00000011   // rotate right by 1
 * 
 * Normally when the number 7 is right shifted by 1, the rightmost '1' is
 * discarded and the result looks like this:
 *      00000000 00000000 00000000 00000011   // 7 >> 1 (last '1' is discarded)
 * For a right rotate the number is not discarded and it's placed on the left,
 * the most significant bit (bit 31).
 * 
 * The same goes for a left rotate:
 *      11111111 11111111 11111111 11111000   // original value of -8
 *      11111111 11111111 11111111 11110001   // rotate left by 1
 */
public class _02_Rotate {

	int rotateLeft(int value, int rotateAmount) {
		for (int i = 0; i < rotateAmount; i++) {
			int leftEdge = Integer.toBinaryString(value).charAt(i) & 1;
			// ^ return 1 if its one, otherwise return 0
			value = value << 1;//shift left one
			value = value+leftEdge;//add byte that got pushed off to the back again
		}

		return value;
	}

	int rotateRight(int value, int rotateAmount) {
		    for (int i = 0; i < rotateAmount; i++) {
		        int rightEdge = value & 1; //get bit on right edge
		        value = value >> 1; //shift one
		        if (rightEdge != 0) {
		            value = value | (1 << 32);  //int's have 32 bits, so u get 1000000...
		        } else {                        // instead of ...000000001
		            value = value &~(1 << 32); 
		            }
		    }

		    return value;
		}
	

	@Test
	void testRotateLeft() {
		int i = -8;

		int result = rotateLeft(i, 1);
		System.out.println("Left rotate tests");
		System.out.println("Expected: " + Integer.toBinaryString(-15));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(-15, result);

		result = rotateLeft(i, 3);
		System.out.println();
		System.out.println("Expected: " + Integer.toBinaryString(-57));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(-57, result);
	}

	@Test
	void testRotateRight() {
		int i = 7;

		int result = rotateRight(i, 1);
		System.out.println("\nRight rotate tests");
		System.out.println("Expected: " + Integer.toBinaryString(-2147483645));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(-2147483645, result);

		result = rotateRight(i, 16);
		System.out.println();
		System.out.println("Expected: " + Integer.toBinaryString(458752));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(458752, result);
	}
}
