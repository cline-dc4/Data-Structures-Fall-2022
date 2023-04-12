import java.util.Random;

/** 
 * CSC233 Final Project
 * @author crissy 
 * @version December 1, 2022
 */
public class ColorCode 
{
	/** this is the array for the color code objects */
	public char [] arrayOfColors;
	
	/**
	 * The constructor for the random generated color code objects
	 */
	public ColorCode ()
	{
		arrayOfColors = new char [4];
		Random codeGenerator = new Random();
		for (int index = 0; index < 4; index++)
		{
			arrayOfColors[index] = randomToChar(codeGenerator.nextInt(6));
		}
	}
	
	/**
	 * The constructor that takes in arguments 
	 * @param colorArray The array of four colors for the new ColorCode object
	 */
	public ColorCode (char [] colorArray)
	{
		arrayOfColors = new char [4];
		for (int index = 0; index < 4; index++)
		{
			arrayOfColors[index] = colorArray[index];
		}
	}
	
    /** this is the constant variable for the color red */
	public static final char RED = 'r';
	
    /** this is the constant variable for the color orange */
	public static final char ORANGE = 'o';

    /** this is the constant variable for the color yellow */
	public static final char YELLOW = 'y';

    /** this is the constant variable for the color green */
	public static final char GREEN = 'g';

    /** this is the constant variable for the color blue */
	public static final char BLUE = 'b';

    /** this is the constant variable for the color purple */
	public static final char PURPLE = 'p';
	
	/**
	 * this is the getter for the array of characters of a color code
	 * @return the array to be returned
	 */
	public char [] getArrayOfChars()
	{
		return arrayOfColors;
	}
	
	/**
	 * this is the setter for the color characters in a color code
	 * @param index The location of the char being set
	 * @param colorChar the char corresponding to the color being set
	 */
	public void setColor (int index, char colorChar)
	{
		arrayOfColors[index] = colorChar;
	}
	
	/**
	 * this is the getter for the color char at a specific index
	 * @param index The location of the char being returned
	 * @return The char that is returned
	 */
	public char getColor (int index)
	{
		return arrayOfColors[index];
	}
	
	/**
	 * this method takes in an integer and converts it to a color char
	 * @param randomInt the integer being converted
	 * @return the char corresponding to a color for the code
	 */
	public char randomToChar(int randomInt)
	{
		char returnChar = 'r';
		if (randomInt == 1)
			returnChar = 'o';
		else if (randomInt == 2)
			returnChar = 'y';
		else if (randomInt == 3)
			returnChar = 'g';
		else if (randomInt == 4)
			returnChar = 'b';
		else if (randomInt == 5)
			returnChar = 'p';
		return returnChar;
	}
	
	/**
	 * this is the to string method for color code objects
	 */
	public String toString ()
	{
		String stringToPrint = "";
		for (int index = 0; index < 4; index++)
		{
			if (arrayOfColors[index] == RED)
				stringToPrint += "R ";
			else if (arrayOfColors[index] == ORANGE)
				stringToPrint += "O ";
			else if (arrayOfColors[index] == YELLOW)
				stringToPrint += "Y ";
			else if (arrayOfColors[index] == GREEN)
				stringToPrint += "G ";
			else if (arrayOfColors[index] == BLUE)
				stringToPrint += "B ";
			else if (arrayOfColors[index] == PURPLE)
				stringToPrint += "P ";
		}
		stringToPrint += "\n";
		return stringToPrint;
	}
}
