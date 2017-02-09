import java.util.Random;
import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class RandomTestGen{
	public static void main(String[] args) {
		int numOfTests = 100;
		int sizeOfArray = 20;
		int numberRange = 20;
		String filename = "Random-tests-"+numOfTests+"-"+sizeOfArray+"-"+numberRange+".txt";

		randomGenTests(numOfTests,sizeOfArray,numberRange,filename);
		System.out.println("Generated " + numOfTests+ " tests");
		System.out.println("Array size of " +sizeOfArray);
		System.out.println("Number range of " +numberRange);
		System.out.println("In the file: " + filename);
	}

	public static void randomGenTests(int numOfTests, int sizeOfArray, int numberRange, String filename){
		try{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			Random rand = new Random();
			
			for(int i = 0; i < numOfTests; i++){
				ArrayList<String> testArray = new ArrayList<String>();
				StringBuilder sb = new StringBuilder();

				for(int j = 0; j < sizeOfArray; j++){					//Generate the test array
					testArray.add(rand.nextInt(numberRange) + " ");		//Add a random number from 0 to numberRange-1
				}

				int key = rand.nextInt(numberRange);					//Generate the key

				boolean keyInArray = testArray.contains(key+ " ");		//Check it the key is in the array

				for(String x : testArray){								//Convert the Array to string for writing
					sb.append(x);
				}
				System.out.println(key + " [" + sb.toString().trim() + "] " +keyInArray);	
				writer.println(key + " [" + sb.toString().trim() + "] " +keyInArray);	//Write the testcase to file
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}