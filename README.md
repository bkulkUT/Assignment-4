    Project   :  Assignment 4
    Written by:  Bharat Kulkarni - bsk524
    			 Dung Le - dkl524
    Completed :	 03/06/16
    
    Team #: 10
    Driver - Assign4Driver.java
    git URL: https://github.com/bkulkUT/Assignment-4.git
    All other requirements: Kulkarni_Le_Lab4 file
     
    Input Arg: Program takes 2 input arguments. The first input is the dictionary. The second input is the input file.
    Output Format: Output format is as described in the manual. However, we print our word ladder in form one word one line.
    Exception: If there are exception such as null line, incorrect number of words per line, word doesn't exist in dict, etc
               An exception is thrown and the program continues to process the input file.
               
               There are 3 types of exceptions: Too few/too many input (if there are not just 2 words on 1 line)
               									InvalidInput (if word doesn't exist in dictionary)
               									NoSuchLadder (if there is no ladder between words)
               									
    JUnit tests: There are 3 test cases to test for 3 different main outputs: 
    			 	returning a ladder, throwing no ladder exception, throwing word doesn't exist exception. 
    			 To run these tests, please right click on the Test_CorrectOutput.java, go to Run as, and click JUnit Test.
	