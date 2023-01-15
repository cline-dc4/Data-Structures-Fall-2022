import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Parser 
{
	/** the stack that will hold all the Symbol objects for parsing */
	private Stack<Symbol> parseStack;

	/**
	 * creates a Parser object with an empty stack.
	 */
	public Parser()
	{
		parseStack = new Stack<Symbol>();
	}

	/**
	 * the parseFile function will take a file as an input and
	 * print out how each opening and closing symbol pair up,
	 * or throw an exception if they don't all match.
	 * @param fileName the name of a .txt file for input
	 * @throws Exception for any mismatch of symbols.
	 */
	public void parseFile(String fileName) throws Exception
	{
		try 
		{
			Scanner inputFile = new Scanner(new File(fileName));
			//stores the line number
			int lineNumber = 1;
			//creates a Symbol object to push onto the stack
			Symbol newSymbol;
			//holds a Symbol object popped off the stack
			Symbol currentSymbol;
			//holds the string being created by the function
			String parseResults = "";

			//the loop that parses the file
			while (inputFile.hasNextLine())
			{
				String line = inputFile.nextLine();
				for (int i = 0; i < line.length(); i++)
				{
					//creating and pushing symbol object if opening symbol
					if(isOpening(line.charAt(i)))
					{
						parseStack.push(newSymbol = new Symbol(line.charAt(i), lineNumber));
						//testing
						//System.out.println("Symbol pushed" + line.charAt(i));
					}
					//checking closing symbol against opening symbol if closing symbol
					if(isClosing(line.charAt(i)))
					{
						//check if not enough opening symbols:
						if(parseStack.size() == 0)
						{
							System.out.println(parseResults);
							throw new Exception("Not enough opening symbols.");
						}
						currentSymbol = parseStack.pop();
						//if symbols match, add to string, if not throw exception
						if(isPair(currentSymbol, line.charAt(i)))
						{
							parseResults += "Closing symbol " + line.charAt(i) + " on line " 
									+ lineNumber + " matches up with " + currentSymbol.getSymbol() +
									" on line " + currentSymbol.getLineNum() + '\n';
						}
						else
						{
							throw new Exception(parseResults += "Closing symbol " + line.charAt(i) + " on line " 
									+ lineNumber + " doesn't match up with " + currentSymbol.getSymbol() +
									" on line " + currentSymbol.getLineNum());
						}
					}
				}

				lineNumber++;
			}
			System.out.println(parseResults);
			//check if not enough closing symbols:
			if(parseStack.size() != 0)
			{
				throw new Exception("Not enough closing symbols.");
			}
		} 
		catch (FileNotFoundException e) {
			throw e;
		}
	}
	

	/**
	 * returns true or false if the opening symbol matches the closing symbol
	 * @param openingSymbol a Symbol object popped off the stack
	 * @param closingSymbol the closing symbol retrieved from the line
	 * @return true if matching, false if not
	 * @throws Exception if Symbol holds invalid character, throw exception.
	 */
	public boolean isPair(Symbol openingSymbol, char closingSymbol)
	{
		//checking (
		if(openingSymbol.getSymbol() == '(' && closingSymbol == ')')
		{
			return true;
		}
		//checking [
		else if(openingSymbol.getSymbol() == '[' && closingSymbol == ']')
		{
			return true;
		}
		//checking {
		else if (openingSymbol.getSymbol() == '{' && closingSymbol == '}')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * checks if a input character is an opening symbol
	 * @param inputChar the char being checked
	 * @return true if opening, false otherwise
	 */
	public boolean isOpening(char inputChar)
	{
		if(inputChar == '(' || inputChar == '[' || inputChar == '{')
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	
	/**
	 * checks if an input character is a closing symbol
	 * @param inputChar the char being checked
	 * @return true if closing, false otherwise.
	 */
	public boolean isClosing(char inputChar)
	{
		if(inputChar == ')' || inputChar == ']' || inputChar == '}')
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
