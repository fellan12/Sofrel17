class Algorithm {

	public static void main(String[] args) {

		int[] arr = new int[]{1,3,5,2,6,9,7,2,2,6,6};
    // Fixa och läs in data på rätt format

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

  public static int binarySearch(int[] A, int key){
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

  //Correct and working
	public static int myContains(int[] A ,int key) {
    	int[] sorted = sort(A);
      return binarySearch(sorted, key);
	}

  //No sorting
  public static int myContains1(int[] A ,int key) { 
     int res = binarySearch(A, key);
     return res;
  }

  //changed r to A.length/2
  public static int myContains2(int[] A ,int key) {
      A = sort(A);
      int l = 0;
      int r = A.length/2;
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

  public static int myContains3(int[] A ,int key) {

      int arrlen = A.length;
      int tmp;
      for (int i = 0; i < arrlen; i++) {
          for (int j = 1; j < arrlen; j++) {
              if (A[j-1] > A[j]) {
              tmp = A[j];       //Should be A[j-1]
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

  //chaged initial l to 1
  public static int myContains4(int[] A ,int key) {
      A = sort(A);
      int l = 1;            //Should be 0
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

  //For some reason you add the key to the first element in the array
  public static int myContains5(int[] A ,int key) {
      A[0]=key;
      A= sort(A);
      return binarySearch(A, key);
  }  

  //For some reason you computed the result, but returned the key
  public static int myContains6(int[] A ,int key) {
      A = sort(A);
      int res = binarySearch(A, key);
      return key;
  }

}