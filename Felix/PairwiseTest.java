import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.io.PrintWriter;
import java.util.Random;
import java.util.stream.IntStream;


public class PairwiseTest{
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static final String ANSI_RESET = "\u001B[0m";
	static int N = 3;
	static int[] array = new int[N];
	static int[] defaults = {-1, 0 ,1};

	static int sizeOfArray = N;
	static String testFilename = "Pairwise-tests.txt";
	
	public static void main(String[] args) {		
		genPairwiseTest(defaults);
		System.out.println("Running test....");
		System.out.println("Array Size: " + sizeOfArray);
		runTest();
		//runTest1();
		//runTest2();
		//runTest3();
		//runTest4();
		//runTest5();
		//runTest6();
	}

	public static void genPairwiseTest(int[] defaults){
		HashSet<String> res = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			array[i] = 0;			
		}
		res.add(0 + " " + Arrays.toString(array).replace("[","").replace("]","").replace(",",""));	//0-wise

		for (int i =  0; i < N; i++) {	//1-wise
			for (int j = 0;j < defaults.length; j++ ) {		
				int[] tmp = array.clone();
				tmp[i] = defaults[j];
				res.add(defaults[i%3] + " " +(Arrays.toString(tmp).replace("[","").replace("]","").replace(",","")));
			}
		}
	
		for (int i = 0; i < N; i++) {		//2-wise
			for (int j = i; j < N; j++) {
				for (int k = i+1; k < N; k++ ) {
					int[] tmp = array.clone();
					tmp[i] = defaults[i%defaults.length];
					tmp[k] = defaults[k%defaults.length];
					res.add(defaults[i%3] + " " + Arrays.toString(tmp).replace("[","").replace("]","").replace(",",""));
				}
			}
		}

		for (String x : res) {
			System.out.println(x);
		}
		
		try{
			PrintWriter writer = new PrintWriter(testFilename, "UTF-8");
			writer.println(res.size());	//Number of tests
			writer.println(sizeOfArray);	//Array size

			for (String x : res) {
				String[] tmp = x.split(" ");

				int[] intArray = new int[tmp.length];
				for (int i = 0; i< tmp.length; i++) {
					intArray[i] = Integer.parseInt(tmp[i]);
				}

				int key = intArray[0];

				int[] array = Arrays.copyOfRange(intArray,1,intArray.length);
				
				int result = 0;
				for (int i : array) {
					if(i == key){
						result = 1;
					}
				}

				String arr = Arrays.toString(array).replace("[","").replace("]","").replace(",","");
				writer.println(key + " " + arr + " " + result);
			}

			writer.close();
			System.out.println("File complete");

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void runTest(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(testFilename));
			int numOfTests = reader.nextInt();
			int arraySize = reader.nextInt();
			int key, result;
			for(int i = 0; i < numOfTests; i++){
				key = reader.nextInt();
				int[] testArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					testArray[j] = reader.nextInt();
				}
				result = reader.nextInt();
				
				try{
					int testRes = alg.myContains(testArray,key);
					if(testRes == result){
						//System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

	public static void runTest1(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(testFilename));
			int numOfTests = reader.nextInt();
			int arraySize = reader.nextInt();
			int key, result;
			for(int i = 0; i < numOfTests; i++){
				key = reader.nextInt();
				int[] testArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					testArray[j] = reader.nextInt();
				}
				result = reader.nextInt();
				try{
					int testRes = alg.myContains1(testArray,key);
					if(testRes == result){
						////System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains1: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

	public static void runTest2(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(testFilename));
			int numOfTests = reader.nextInt();
			int arraySize = reader.nextInt();
			int key, result;
			for(int i = 0; i < numOfTests; i++){
				key = reader.nextInt();
				int[] testArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					testArray[j] = reader.nextInt();
				}
				result = reader.nextInt();
				try{
					int testRes = alg.myContains2(testArray,key);
					if(testRes == result){
						//System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains2: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

	public static void runTest3(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(testFilename));
			int numOfTests = reader.nextInt();
			int arraySize = reader.nextInt();
			int key, result;
			for(int i = 0; i < numOfTests; i++){
				key = reader.nextInt();
				int[] testArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					testArray[j] = reader.nextInt();
				}
				result = reader.nextInt();
				try{
					int testRes = alg.myContains3(testArray,key);
					if(testRes == result){
						//System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains3: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

	public static void runTest4(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(testFilename));
			int numOfTests = reader.nextInt();
			int arraySize = reader.nextInt();
			int key, result;
			for(int i = 0; i < numOfTests; i++){
				key = reader.nextInt();
				int[] testArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					testArray[j] = reader.nextInt();
				}
				result = reader.nextInt();
				try{
					int testRes = alg.myContains4(testArray,key);
					if(testRes == result){
						//System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains4: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

	public static void runTest5(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(testFilename));
			int numOfTests = reader.nextInt();
			int arraySize = reader.nextInt();
			int key, result;
			for(int i = 0; i < numOfTests; i++){
				key = reader.nextInt();
				int[] testArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					testArray[j] = reader.nextInt();
				}
				result = reader.nextInt();
				try{
					int testRes = alg.myContains5(testArray,key);
					if(testRes == result){
						//System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains5: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

	public static void runTest6(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(testFilename));
			int numOfTests = reader.nextInt();
			int arraySize = reader.nextInt();
			int key, result;
			for(int i = 0; i < numOfTests; i++){
				key = reader.nextInt();
				int[] testArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					testArray[j] = reader.nextInt();
				}
				result = reader.nextInt();
				try{
					int testRes = alg.myContains6(testArray,key);
					if(testRes == result){
						//System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);

					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains6: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

	public static void print(int[] in){
		for (int x: in) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}