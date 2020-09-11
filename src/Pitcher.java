
public class Pitcher 
{
	private String name;

	private double average;
	
	/**
	 * Constructor - Creates a pitcher with the following information: name and average
	 * 
	 * @param name    - the pitcher's name
	 * @param average - the pitcher's average
	 */

	public Pitcher(String name, double average) 
	{
		this.name = name;

		this.average = average;
	}

	/**
	 * This function uses the pitcher's average to determine whether a strike or a ball is thrown
	 * 
	 * @return true if pitcher throws a strike; false if pitcher throws a ball
	 */

	public boolean pitch() 
	{
		if (Math.random() <= average) 
		{
			return true;
		} 
		else 
		{
			return false;
		}

	}
	
	/**
	 * The get method is used to get the pitcher's name
	 * 
	 * @return A string representing the pitcher's name
	 */

	public String getName() 
	{
		return name;
	}

}