class Algorithm {

	public static void main(String[] args) {

		int[] arr = new int[]{1,3,5,2,6,9,7,2,2,6,6};


		System.out.println(myContains(arr, 9));

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

        int tmp;

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j-1] > A[j]) {
                    tmp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = tmp;
                }
            }
        }

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