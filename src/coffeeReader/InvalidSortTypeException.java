package coffeeReader;

public class InvalidSortTypeException extends Exception 
{
	private static final long serialVersionUID = 0;
	
	public InvalidSortTypeException()
	{
		super();
	}
	
	public InvalidSortTypeException(String message)
	{
		super(message);
	}
}