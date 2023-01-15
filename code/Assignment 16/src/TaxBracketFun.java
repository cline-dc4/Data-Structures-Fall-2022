
public class TaxBracketFun implements Taxable{

	public double getRate(char a, int b)
	{
		if (a == 'h')
		{
			if (b <= 14200)
				return 10;
			else if (b <= 54200)
				return 12;
			else if (b <= 86350)
				return 22;
			else if (b <= 164900)
				return 24;
			else if (b <= 209400)
				return 32;
			else if (b <= 523600)
				return 35;
			else
				return 37;
		}
		else if (a == 's')
		{
			if (b <= 9950)
				return 10;
			else if (b <= 40525)
				return 12;
			else if (b <= 86375)
				return 22;
			else if (b <= 164925)
				return 24;
			else if (b <= 209600)
				return 32;
			else if (b <= 523600)
				return 35;
			else
				return 37;
		}
		else if (a == 'm')
		{
			if (b <= 19900)
			{
				return 10;
			}
			else if (b <= 81050)
			{
				return 12;
			}
			else if (b <= 172750)
			{
				return 22;
			}
			else if (b <= 329850)
				return 24;
			else if (b <= 418850)
				return 32;
			else if (b <= 628300)
				return 35;
			else
				return 37;
		}
		else
		{
			System.out.println("invalid character");
			return 0;
		}
	}
}

