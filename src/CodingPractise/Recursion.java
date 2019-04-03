package CodingPractise;

public class Recursion {
	public long power(int a, int b) {
        if (b == 0) {
        	return 1;
        }
        
        if (b == 1) {
        	return a;
        }
        
        long left = power(a, b / 2);
        if (b % 2 == 1) {
        	return left * left * a;
        } else {
        	return left * left;
        }
    }
}
