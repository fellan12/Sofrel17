import java.util.Random;
import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class RandomTest{
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static int[][] tests;
	static int[] keys;
	static int numOfTests = 100;
	static int sizeOfArray = 20;
	static int numberRange = 20;
	public static void main(String[] args) {
		tests = new int[numOfTests][sizeOfArray];
		keys = new int[numOfTests];
		String filename = "Random-tests-"+numOfTests+"-"+sizeOfArray+"-"+numberRange+".txt";

		randomGenTests(numOfTests,sizeOfArray,numberRange,filename);
		System.out.println("Generated " + numOfTests+ " tests");
		System.out.println("Array size of " +sizeOfArray);
		System.out.println("Number range of " +numberRange);
		System.out.println("In the file: " + filename);
		System.out.println();
		System.out.println("Running test....");
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
				System.out.println(key + " " + sb.toString().trim() + " " +keyInArray);
				writer.println(key + " " + sb.toString().trim() + " " +keyInArray);	//Write the testcase to file
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runTest(){
		Algorithm alg = new Algorithm();
		try{
			Scanner reader = new Scanner(new File("Random-tests-100-20-20.txt"));
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
				int testRes = alg.myContains(testArray,key);

				if(testRes == result){
					System.out.println(ANSI_GREEN+"Pass " + i);
				}else{
					System.out.println(ANSI_RED+"Fail" + i);
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}