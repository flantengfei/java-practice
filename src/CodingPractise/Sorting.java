package CodingPractise;

public class Sorting {
	public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
        	return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
	}
	
	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = sort(array, left, right);
		quickSort(array, left, pivot);
		quickSort(array, pivot + 1, right);
	}
	
	private int sort(int[] array, int left, int right) {
		int pivot = getPartition(array, left, right);
		int pivotValue = array[pivot];
		swap(array, pivot, right);
		int rightBound = right - 1;
		int leftBound = left;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivotValue) {
				leftBound++;
			} else if (array[rightBound] >= pivotValue) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		swap(array, leftBound, right);
		return leftBound;
	}
	
	private int getPartition(int[] array, int left, int right) {
		return left + (int) (Math.random() * (right - left + 1));
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
