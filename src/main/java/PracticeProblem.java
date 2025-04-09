import java.util.*;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int[] recaman(int n) {
		//Write question 1 code here
		if (n <= 0) {
			return new int[0];
		}
		int[] sequence = new int[n + 1];
		HashSet<Integer> duplicate = new HashSet<>();
		sequence[0] = 0;
		duplicate.add(0);
		recamanHelper(sequence, duplicate, 1);
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = sequence[i + 1];
		}
		return result;
	}
	public static void recamanHelper(int[] sequence, HashSet<Integer> duplicate, int index) {
		if (index >= sequence.length) {
			return;
		}
		int last = sequence[index - 1];
		int next = last - index;
		if (next > 0 && !duplicate.contains(next)) {
			sequence[index] = next;
		} 
		else {
			sequence[index] = last + index; // subtract current step from teh last number, but when -ve then add it
		}

		duplicate.add(sequence[index]);

		recamanHelper(sequence, duplicate, index + 1);
	}
}
