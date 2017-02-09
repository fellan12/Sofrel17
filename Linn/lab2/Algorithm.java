class Algorithm {

	public static void main(String[] args) {

		int[] arr = new int[]{1,3,5,2,6,9,7,2,2,6,6};
    // Fixa och läs in data på rätt format
        // 

		System.out.print("Before sort: ");
		for (int elem : arr) {
			System.out.print(elem + ", ");
		}
		System.out.println("");

		int[] sorted_arr = sort(arr);

		System.out.print("After sort: ");
		for (int elem : arr) {
			System.out.print(elem + ", ");
		}
		System.out.println("");

		System.out.println(binarySearch(sorted_arr, 9));



	}

	public static int[] sort(int array[]) {
   		int arrlen = array.length;
   		int tmp;
   		for (int i = 0; i < arrlen; i++) {
       		for (int j = 1; j < arrlen; j++) {
           		if (array[j-1] > array[j]) {
       				tmp = array[j-1];
        			array[j-1] = array[j];
        			array[j] = tmp;
           		}
       		}
   		}
   		return array;
	}

	public static int myContains(int[] A ,int key) {
        
        int arrlen = array.length;
        int tmp;

        for (int i = 0; i < arrlen; i++) {
            for (int j = 1; j < arrlen; j++) {
                if (array[j-1] > array[j]) {
                    tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;


    	int l = 0;
    	int r = A.length-1;
    	int x = 0;
        
    	do {
        	x = (l + r) / 2;
        	if (key < A[x]) {
        		r = x-1;
        	}
        	else {
                l = x+1;
            }
    	} 
    	while (!(key == A[x] || l>r));
         
    	if (key == A[x]) {
        	return 1;
    	}
    	else {
        	return 0;
    	}
	}
}