/*
    Project   :  Assignment 4
    Written by:  Bharat Kulkarni - bsk524
    			 Dung Le - dkl524
    Completed :	 03/06/16
 */

package assignment4;

import java.util.List;

public class WordLadderSolver implements Assignment4Interface
{	
    // dictionary and graph (underlying structures)
	protected Dictionary myDictionary;
	protected Graph myGraph;
	protected List<String> myWordLadder;
	
	
	// constructor
	WordLadderSolver (String fileName)
	{
		// create dictionary and graph of dictionary
		long beginTest;
		long endTest;
		
		System.out.println("Loading Dictionary ... ");
		myDictionary = new Dictionary();
    	myDictionary.createDictionary(fileName);
    	System.out.println("Dictionary loaded!");
    	
    	System.out.println("Creating graph of dictionary words ...");
    	myGraph = new Graph();
    	beginTest = System.nanoTime();
		myGraph.createGraph(myDictionary.getDictionaryWords());
		endTest = System.nanoTime();
		System.out.println("Graph Created! (Time needed: " + (endTest - beginTest) + " ns)\n");
	}
	
	
    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
    	List<String> wordLadder;
    	List<String> words = myDictionary.getDictionaryWords();
    	
    	if (!words.contains(startWord) || !words.contains(endWord))
    	{
    		
    		throw new NoSuchLadderException ("For the input words, " + "\""+ startWord +"\""+ " and "
    										 +"\""+ endWord +"\""
    										 +"\nAt least one of the words " + startWord +
    										 " and " + endWord + " is not a legitimate 5-letter word "
    										 + "from the dictionary"
    										 + "\n**********\n");
    	}
    	
    	wordLadder = myGraph.computeBFS(startWord, endWord, words);
    	if (wordLadder.isEmpty()) throw new NoSuchLadderException ("For the input words, " + "\""+ startWord +"\""+ " and "
    																+"\""+ endWord +"\""+ "\nThere is no word ladder between "
    																+ startWord + " and " + endWord +"!"
    			                                                    + "\n**********\n");

		return wordLadder;
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
    	List<String> words = myDictionary.getDictionaryWords();
    	
    	for (String entry : wordLadder)
    	{
    		if (!words.contains(entry))
    			return false;	    		
    	}
    	
    	myWordLadder = wordLadder;
    	
    	return true;
    }
}





















