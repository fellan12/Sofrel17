import java.util.Random;
import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class RandomTest{
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static final String ANSI_RESET = "\u001B[0m";
	static int[][] tests;
	static int[] keys;
	static int numOfTests = 100;
	static int sizeOfArray = 100;
	static int numberRange = sizeOfArray;
	static String filename = "Random-tests.txt";
	
	public static void main(String[] args) {
		tests = new int[numOfTests][sizeOfArray];
		keys = new int[numOfTests];

		//randomGenTests(numOfTests,sizeOfArray,numberRange,filename);
		System.out.println("Generated " + numOfTests+ " tests");
		System.out.println("Array size of " +sizeOfArray);
		System.out.println("Number range of " +numberRange);
		System.out.println("In the file: " + filename);
		System.out.println();
		System.out.println("Running test....");
		runTest();
		runTest1();
		runTest2();
		runTest3();
		runTest4();
		runTest5();
		runTest6();

	}

	public static void randomGenTests(int numOfTests, int sizeOfArray, int numberRange, String filename){
		try{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			writer.println(numOfTests);		//Number of tests
			writer.println(sizeOfArray);	//Array size

			Random rand = new Random();

			
			for(int i = 0; i < numOfTests; i++){
				ArrayList<String> testArray = new ArrayList<String>();
				StringBuilder sb = new StringBuilder();

				for(int j = 0; j < sizeOfArray; j++){					//Generate the test array
					int randNum = rand.nextInt(numberRange);
					testArray.add(randNum + " ");		//Add a random number from 0 to numberRange-1
					tests[i][j] = randNum;
				}

				int key = rand.nextInt(numberRange);					//Generate the key
				keys[i] = key;

				int keyInArray = testArray.contains(key+ " ") ? 1 : 0;		//Check it the key is in the array

				for(String x : testArray){								//Convert the Array to string for writing
					sb.append(x);
				}
				writer.println(key + " " + sb.toString().trim() + " " +keyInArray);	//Write the testcase to file
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void runTest(){
		Algorithm alg = new Algorithm();
		int wrongCounter = 0;
		int rightCounter = 0;
		try{
			Scanner reader = new Scanner(new File(filename));
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
						//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
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
			Scanner reader = new Scanner(new File(filename));
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
						//System.out.println(ANSI_GREEN+"Pass " + (i+1) +ANSI_RESET);
						rightCounter++;
					}else{
						//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
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
			Scanner reader = new Scanner(new File(filename));
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
						//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
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
			Scanner reader = new Scanner(new File(filename));
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
						//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
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
			Scanner reader = new Scanner(new File(filename));
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
						//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
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
			Scanner reader = new Scanner(new File(filename));
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
						//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
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
			Scanner reader = new Scanner(new File(filename));
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
						//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Wrong answer"+ANSI_RESET);
						wrongCounter++;
					}
				}catch(Exception a){
					//System.out.println(ANSI_RED+"Fail " + (i+1) + ": Exception"+ANSI_RESET);
					wrongCounter++;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.out.println("myContains6: Wrong on " + wrongCounter + " out of " + (wrongCounter+rightCounter));
	}

}