package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Assign4Driver
{
    public static void main(String[] args)
    {
    	String startWord;
        String endWord;
    	String dictFile = args[0];
    	String inputFile = args[1];
    	
        Assignment4Interface wordLadderSolver = new WordLadderSolver (dictFile);
        List<String> inputs = extractWordPairs (inputFile);
        
        try 
        {
        	long startTime = 0;
            long endTime = 0;
            
        	for (int i = 0; i < inputs.size(); i++)
            {
            	String line = inputs.get(i);
            	String[] entries = line.split("[\\s]");
            	
            	startWord = entries[0];
            	endWord = entries[1];
            	
            	startTime = System.nanoTime();
            	List<String> result = wordLadderSolver.computeLadder(startWord, endWord);
                boolean correct = wordLadderSolver.validateResult(startWord, endWord, result);
                endTime = System.nanoTime();
                if (correct) printWordLadder (startWord, endWord, result, startTime, endTime);
            }
        } 
        
        catch (NoSuchLadderException e) 
        {
            //e.printStackTrace();
            System.err.println(e);
        }
    }
    
    
    public static List<String> extractWordPairs (String file)
    {
    	List<String> result = new ArrayList<String>();
    	
    	try 
		{
			FileReader freader = new FileReader(file);
			BufferedReader reader = new BufferedReader(freader);
			
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				
				result.add(line);
			}
			reader.close();
		}
    	
		catch (FileNotFoundException e) 
		{
			System.err.println("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} 
    	
		catch (IOException e) 
		{
			System.err.println("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
    	
    	return result;
    }
    
    // prints the word ladder if it exists 
    public static void printWordLadder (String start, String end, List<String> myWordLadder, long startTime, long endTime)
    {
    	if (!myWordLadder.isEmpty())
    	{
    		System.out.println("For the input words, " + start + " and " + end + ", the following word ladder"
    							+ " was found:\n");
    		
    		for (int i = 0; i < myWordLadder.size(); i++)
    		{
    			System.out.println(myWordLadder.get(i));
    		}
    		
            System.out.println("\nTotal runtime in (ns): " + (endTime - startTime) + "\n"); 	
    		System.out.print("**********\n\n");
    	}
    }
}
