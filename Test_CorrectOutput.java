package assignment4;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class Test_CorrectOutput {
	

	@Test(expected = NoSuchLadderException.class)
	public void testNoLadderException() throws NoSuchLadderException, InvalidInputException {
		String startWord = "swish";
		String endWord = "butyl";
        Assignment4Interface findLadder = new WordLadderSolver ("A4-words.txt"); //string is the name of the dict file
		findLadder.computeLadder(startWord, endWord);
     }

	@Test(expected = InvalidInputException.class)
	public void testInvalidInput() throws InvalidInputException, NoSuchLadderException {
		String startWord = "abaca";
		String endWord = "aaaaa";
        Assignment4Interface findLadder = new WordLadderSolver ("A4-words.txt");//string is the name of the dict file
		findLadder.computeLadder(startWord, endWord);
     }

	@Test
	public void testCorrectOutput() throws NoSuchLadderException, InvalidInputException {
		String startWord = "heads";
		String endWord = "tails";
        Assignment4Interface findLadder = new WordLadderSolver ("A4-words.txt");//string is the name of the dict file
		List<String> ladder = findLadder.computeLadder(startWord, endWord);
		assert(ladder.size()>0);
		assert(ladder.get(0).equals("heads"));
		assert(ladder.get(ladder.size()-1).equals("tails"));
  		for (int i = 0; i < ladder.size()-1; i++)
		{
  			int difference = 0;
  			for (int j = 0; j < 5; j++) //for this lab purpose, all words have only 5 characters
  			{
  				if (ladder.get(i).charAt(j) != ladder.get(i+1).charAt(j))
  					difference++;
  				
  			}
  			assert(difference == 1);
		}
     }

}
