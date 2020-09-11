
public class Batter 
{
	private String name;

	private double average;
	
	/**
	 * Constructor - Creates a batter with the following information: name and average
	 * 
	 * @param name    - batter's name
	 * @param average - batter's average
	 */

	public Batter(String name, double average) 
	{
		this.name = name;

		this.average = average;
	}


	/**
	 * This function uses batter's average to determine whether they hit the pitch
	 * or swings and misses (assuming a strike is thrown by pitcher)
	 * 
	 * @return true if batter hits; false if batter swings and misses
	 */

	public boolean hit() 
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
	 * The get method is used to get the batter's name
	 * 
	 * @return A string representing the batter's name
	 */

	public String getName() 
	{
		return name;
	}

}