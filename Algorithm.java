

public class Algorithm{
	public static void main(String[] args) {
		int[] testArray = new int[]{1,7,1,4,8,3,2,4,6,8};
		int key = 9;
		
		System.out.println(myContains(testArray,key));
	}

	public static int[] bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < arr.length - j; i++) {                                       
				if (arr[i] > arr[i + 1]) {                          
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}                
		}
		return arr;
	}

	public static boolean binarySearch(int[] A ,int key){
		int x,r,l;
		l= 0;
		r = A.length-1;
		do{
			x = (l + r) / 2;
			if(A[x] > key) {
				r = x - 1;
			}else{
				l = x + 1;
			}
		}while(!(key == A[x] || l > r));

		if(key == A[x]){
			return true;
		}else{
			return false;
		}
	}

	public static boolean myContains(int[] array, int key){
		return binarySearch(bubbleSort(array), key);
	}
}