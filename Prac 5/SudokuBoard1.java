import java.io.*;

/* TEMPLATE TO ASSIST YOU IN SOLVING THE SUDOKU PUZZLE */

public class SudokuBoard
{
	boolean explain;  // to explain moves set variable to true
    
	public static int size = 9;
    
    private String[][] board = new String[size][size];
	
    private String stringWithAllDigits = "123456789";

	public SudokuBoard(boolean arg)
	{	explain = arg;
	}

	public void initializeBoard()
	{	// populate every cell of board with string that contains all 9 didgits
        for (int r=0; r<9; r++)
		{	for (int c=0; c<9; c++)
			{	board[r][c] = stringWithAllDigits;
			}
		}
        // then store single digits in appropriate cells of board
		board[0][1] = "6"; board[0][3] = "1"; board[0][5] = "4"; board[0][7] = "5";
		board[1][2] = "8"; board[1][3] = "3"; board[1][5] = "5"; board[1][6] = "6";	
		board[2][0] = "2"; board[2][8] = "1"; board[3][0] = "8"; board[3][3] = "4"; 
		board[3][5] = "7"; board[3][8] = "6"; board[4][2] = "6"; board[4][6] = "3"; 
		board[5][0] = "7"; board[5][3] = "9"; board[5][5] = "1"; board[5][8] = "4";
 		board[6][0] = "5"; board[6][8] = "2"; board[7][2] = "7"; board[7][3] = "2"; 
		board[7][5] = "6"; board[7][6] = "9"; board[8][1] = "4"; board[8][3] = "5"; 
		board[8][5] = "8"; board[8][7] = "7";

	}

	public String extractDigitAtPos(int pos, String aStrng)
	{	// returns digit at index pos
        return aStrng.substring(pos,pos+1);
	}

	// Boolean methods
	// ---------------
	public boolean squareContainsASingleDigit(int r,int c)
	{	// checks if cell contains a single digit
        return (board[r][c].trim().length() == 1);
	}

	public boolean moreThanOneDigitInString(String strng)	
	{	// checks if cell contains more than 1 digit
        return ( strng.length() > 1);
	}

	public boolean	digitAppearsInString(String digt, String strng)
	{ 	// checks if digt appears in string strng
        return (strng.indexOf(digt) >= 0);
	}

	public boolean digitAppearsOnlyOnceInString(String dgt, String strng)
    {   // checks if digt appears only once in string strng
		int counter = 0;
		for (int indx=0; indx< strng.length(); indx++)
		{	if (strng.substring(indx,indx+1).equals(dgt))
				counter++; 
		}
		return (counter == 1);
	}

	// Accessors
	// ---------
	public String getContentOfSquare(int r, int c)
	{	return board[r][c];
	}
	
	public String[] getColumn(int c)
	{	// retrieve column from board
        String[] temp = new String[size];
		for (int r=0; r<size; r++)
			temp[r] = board[r][c];
		return temp;
	}

	public String[] getRow(int r)
    { // your code goes here
    }

	public String[] get3x3region(int row, int col)	// extracts 3x3 region which
	{	// retrieve 3x3 region from board
        int topRow  = 3*(row / 3);		// contains board[row][col]
		int leftCol = 3*(col / 3);
		int k = 0;
		String[] temp = new String[size];

        // your code goes here
        
		return temp;
	}

	// Mutators
	// --------
	public void setContentOfSquare(int r, int c, String val)
	{	board[r][c] = val;
	}
	
	public void setRow(int r, String[] arr)
	{	// copies an array of strings to row r of board
        for (int c=0; c<size; c++)
			board[r][c] = arr[c]; 
	}

	public void setColumn(int c, String[] arr)
    {   //copies an array of strings to column c of board
        // your code goes here
    }

	public void set3x3region(int row, int col, String[] arr)
	{	// copies an array of strings to appropriate part of board
        int topRow = 3*(row / 3);
		int leftCol = 3*(col / 3);
		int k=0;
		for (int r=topRow; r<topRow+3; r++)
		{	for (int c=leftCol; c<leftCol+3; c++)
			{	board[r][c] = arr[k]; 
				k++;
			}
		}
	}
	// ------------------------------------------------------------------------------------

	// Removes a digit 
	// ---------------
	 
	public String removeDigitFromStringOfLength2orMore(String dgt, String strng)
	{	// Removes a digit from a string
        String aStrng = strng;
		int indx = aStrng.indexOf(dgt);
		if ((indx >= 0) && (moreThanOneDigitInString(aStrng)))
			aStrng = aStrng.substring(0,indx) + aStrng.substring(indx+1);			
		return aStrng;
	}

	
	public String[] removeDigitFromArray(String dgt, String[] arr)
    {   // Removes a digit dgt from each element of a string array

        // your code goes here
    }

	public void removeDigitFromAllStringsOfLength2orMoreInRow(int r, int c)
    {   // Removes a digit dgt from ALL strings of length 2 or more in a row

        // your code goes here
    }

	public void removeDigitFromAllStringsOfLength2orMoreInColumn(int r, int c)
    {   // Removes a digit dgt from ALL strings of length 2 or more in a column
		String digt = board[r][c];
	 	String[] column = getColumn(c);
		String[] temp = removeDigitFromArray(digt, column);
		setColumn(c, temp);		
	}

	public void removeDigitFromAllStringsOfLength2orMoreIn3x3region(int row, int col)
    {   // Removes a digit dgt from ALL strings of length 2 or more in a 3x3 region

        // your code goes here
    }

	// ---------------------------------------------------

	public String joinAllStringsInArray(String[] arr)
	{	// joins all strings in an array and returns a single string
        String temp = "";
		for (int indx = 0; indx < arr.length; indx++)
		{	temp = temp + arr[indx];
		}
		return temp;
	}

	public String joinAllStringsInRowR(int r, int c)
    {	// joins all strings in a row and returns a single string
		String[] row = getRow(r);
		String temp = joinAllStringsInArray(row);
		return temp;
	}

	public String joinAllStringsInColC(int r, int c)
    {	// joins all strings in a column and returns a single string

        // your code goes here
    }

	public String joinAllStringsIn3x3region(int r, int c)
    {	// joins all strings in a 3x3 region and returns a single string
        
        // your code goes here
    }

    public boolean onlyNumberInRowColOr3x3region(String numbr, int r, int c)
	{	// identifies hidden lonely in a row, a column or 3x3 region
        String strngRow = joinAllStringsInRowR(r,c);
		String strngCol = joinAllStringsInColC(r,c);
		String strng3x3region = joinAllStringsIn3x3region(r,c);

        if (digitAppearsOnlyOnceInString(numbr, strngRow))
		{
			if (explain)
				System.out.println("Row: lonely identified in Row: "+r+" Column: "+c+" Val : "+numbr);
			return true;
		}
		if (digitAppearsOnlyOnceInString(numbr, strngCol))
		{
			if (explain)
				System.out.println("Column: lonely identified in Row: "+r+" Column: "+c+" Val : "+numbr);
			return true;
		}
		if (digitAppearsOnlyOnceInString(numbr, strng3x3region))
		{
			if (explain)
				System.out.println("3x3region: lonely identified in Row: "+r+" Column: "+c+" Val : "+numbr);
			return true;
		}
		else
			return false;
	}

	public void identifyHiddenSinglesInSquare(int r, int c)
	{
		String strngOfNumbrs  = board[r][c]; 
		for (int pos = 0; pos < strngOfNumbrs.length(); pos++)
		{	String digit = extractDigitAtPos(pos, strngOfNumbrs);
            // your code goes here
        }
	}

	public String constructLineNo(int lineNo, String strng)
	{ 	String template = "123456789";
		String line = "";
		String aSpace = " ";
		int strt = 3 * lineNo - 3;
		for (int i = strt; i< strt+3; i++)
		{	String digt = template.substring(i,i+1);
			if (strng.indexOf(digt) != -1)		
				line = line + " "+digt;
			else
				line = line + " "+aSpace;
		}
		return line;
	}

	public void displayBoard()
	{	System.out.println("\t\t------------------------------------------------------------------------------");
		for (int r=0; r<9; r++)
		{	
			String line1 = "\t\t| ";
			String line2 = "\t\t| ";
			String line3 = "\t\t| ";

			for (int c=0; c<9; c++)
			{	 line1 = line1 + constructLineNo(1, board[r][c])  + " |";
				 line2 = line2 + constructLineNo(2, board[r][c]) + " |";
				 line3 = line3 + constructLineNo(3, board[r][c])  + " |";
				 if (( c == 2) || ( c == 5))
				 {	line1 = line1 + "| ";
				 	line2 = line2 + "| ";
				 	line3 = line3 + "| ";
				 }
			}
			System.out.println(line1);
			System.out.println(line2);
			System.out.println(line3);
			if (( r == 2) || ( r == 5))
				System.out.println("\t\t==============================================================================");
			else
				System.out.println("\t\t------------------------------------------------------------------------------");
		}
		System.out.println();
	}

	public void displayFinalBoard()
	{	System.out.println("\t\t Solution");
		for (int r=0; r< board.length; r++)
		{	System.out.print("\t");
			for (int c=0; c<board[r].length; c++)
			{	System.out.print(board[r][c].trim()+" ");
				if ((c == 2) || (c == 5))
					System.out.print("| ");
			}
			System.out.println();
			if ((r == 2) || ( r == 5) || (r == 8))
				System.out.println("\t----------------------");
		}

	}

}