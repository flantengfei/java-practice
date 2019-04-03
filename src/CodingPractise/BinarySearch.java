package CodingPractise;

public class BinarySearch {
	public int[] kClosest(int[] array, int target, int k) {
		if (array == null || array.length == 0) {
			return new int[] {};
		}
		int[] result = new int[k];
		int left = getSmallestOrEqual(array, target);
		int right = left + 1;
		for (int i = 0; i < k; i++) {
			if (right >= array.length || left >= 0 && Math.abs(target - array[left]) <= Math.abs(target - array[right])) {
				result[i] = array[left--];
			} else {
				result[i] = array[right++];
			}
		}
		return result;
    }
	
	private int getSmallestOrEqual(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}
}