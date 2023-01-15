package application;
/**
 * This class holds a collection of color codes for use in 
 * setting background colors for buttons.
 * @author DC
 * @version 12/12/22
 */
public interface ColorCodes 
{
	/** stores the color code string for red */
	public static final String CODE_RED = "-fx-background-color: #ED1C24; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; ";
	
	/** stores the color code string for orange */
	public static final String CODE_ORANGE = "-fx-background-color: #FF7F27; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; ";

	/** stores the color code string for yellow */
	public static final String CODE_YELLOW = "-fx-background-color: #FFF200; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; "; 
	
	/** stores the color code string for green */
	public static final String CODE_GREEN = "-fx-background-color: #22B14C; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; ";
	
	/** stores the color code string for blue */
	public static final String CODE_BLUE = "-fx-background-color: #3F48CC; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; ";

	/** stores the color code string for brown */
	public static final String CODE_PURPLE = "-fx-background-color: #A349A4; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; ";

	/** stores the color code string for white */
	public static final String CODE_WHITE = "-fx-background-color: #FFFFFF; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; ";

	/** stores the color code string for black */
	public static final String CODE_BLACK = "-fx-background-color: #000000; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; ";

	/** creates a black border around a button */
	public static final String CODE_BORDER = "-fx-border-color: #000000; \n-fx-pref-width: 20px; \n-fx-pref-height: 25px; \n"
			+ "-fx-border-width: 1px; \n-fx-border-style: solid; \n-fx-background-color: #FFFFFF; ";
}