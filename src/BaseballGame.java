/*
 * A baseball simulation program, which includes simulations of 
 * a full at-bat, a full game (including extra innings), and a best-of-7 series
 * _____________________________________________________________________________
 */

import java.util.ArrayList;

public class BaseballGame {
	public static void main(String[] args) {
		// Create a list of batters for each team using ArrayList
		ArrayList<Batter> t1 = new ArrayList<Batter>();
		ArrayList<Batter> t2 = new ArrayList<Batter>();

		// Create and add batters to each team
		// Use the Batter class to give each batter a name and a randomly generated batting average
		// Add batters to their team using the .add method

		// Use a for loop to generate the names of the 9 batters of each team
		for (int i = 1; i <= 9; i++) {
			t1.add(new Batter("T1 Batter " + i, Math.random() / 3));
			t2.add(new Batter("T2 Batter " + i, Math.random() / 3));
		}

		// Create a pitcher for each team
		// Use the Pitcher class to give each pitcher a name and a randomly generated
		// pitching average
		Pitcher p1 = new Pitcher("T1 Pitcher", 1 - Math.random() / 3);
		Pitcher p2 = new Pitcher("T2 Pitcher", 1 - Math.random() / 3);

		// Keep track of the number of games won in a series for each team
		int t1wins = 0;
		int t2wins = 0;

		// Best-of-7 series
		for (int game = 1; game <= 7; game++) { 
			// balls, strikes, hits, outs Counters
			int balls = 0;
			int strikes = 0;
			int hits = 0;
			int outs = 0;

			// Keep track of the current batter for each team
			int t1currentBatter = 0;
			int t2currentBatter = 0;

			// Keep track of the team's score throughout a game
			int t1score = 0;
			int t2score = 0;

			// inning counter
			int inning = 0;

			System.out.println("Game " + game + " of the series\n");

			while (true) {
				inning++;
				System.out.println("Top of Inning " + inning);
				System.out.println("Current Score T1: " + t1score + " T2: " + t2score);
				while (outs < 3) {
					// use modular arithmetic (% 9) to cycle through the list of batters (1-9)
					// the order resets to batter 1 after all 9 batters have gone
					System.out.println(p1.getName() + " vs " + t2.get(t2currentBatter % 9).getName());

					// if pitcher throws a strike
					if (p1.pitch()) {
						// if batter hits
						if (t2.get(t2currentBatter % 9).hit()) {
							System.out.println("Hit");
							// reset the number of balls and strikes, and get a new batter, add 1 to the
							// number of hits
							balls = 0;
							strikes = 0;
							t2currentBatter++;
							hits++;

							// team scores a point if home plate is reached
							if (hits >= 4) {
								t2score++;
								System.out.println("T2 reaches home plate. Score");
								System.out.println("Game Score is now T1: " + t1score + " T2: " + t2score);
							}
						}
						// batter swings and misses
						else {
							// add 1 to the number of strikes
							strikes++;
							System.out.println("Swing and Miss");
							System.out.println("Strike - Balls: " + balls + " Strikes: " + strikes);
						}
					}
					// pitcher throws a ball
					else {
						// add 1 to the number of balls
						balls++;
						System.out.println("Ball - Balls: " + balls + " Strikes: " + strikes);
					}
					// if number of balls is 4, then it's a walk
					if (balls == 4) {
						// reset number of strikes and balls, get a new batter, add 1 to number of hits
						strikes = 0;
						balls = 0;
						t2currentBatter++;
						hits++;
						System.out.println("Walk");
					}
					// if the number of strikes is 3, then it's a strike-out
					else if (strikes == 3) {
						// reset number of strikes and balls, add 1 to number of outs, get a new batter
						balls = 0;
						strikes = 0;
						outs++;
						t2currentBatter++;
						System.out.println("Strike out");
						System.out.println("T2's Total Outs: " + outs);
					}
					// Every hit is a single. Everyone moves bases after a hit
					// if there is 1 hit, first base is secured
					if (hits == 1) {
						System.out.println("On first");
					}
					// if there are 2 hits, first and second bases are secured
					else if (hits == 2) {
						System.out.println("On first and second");
					}
					// if there are at least 3 hits, first, second and third bases are secured
					else if (hits >= 3) {
						System.out.println("On first, second and third");
					}
				}
				// reset the counters after each inning
				balls = 0;
				strikes = 0;
				hits = 0;
				outs = 0;

				// Since T1 pitched first, if they have the lead after top of 9th,
				// game is over and T1 wins, and bottom of 9th will not be played
				if (inning == 9 && t1score > t2score) {
					System.out.println("Current Score T1: " + t1score + " T2: " + t2score);
					System.out.println("T1 leading after Top of 9th");
					System.out.println("No need to keep playing");
					break;
				}
				System.out.println("Bottom of Inning " + inning);
				System.out.println("Current Score T1: " + t1score + " T2: " + t2score);
				while (outs < 3) {
					// use modular arithmetic (% 9) to cycle through the list of batters (1-9)
					// the order resets to batter 1 after all 9 batters have gone
					System.out.println(p2.getName() + " vs " + t1.get(t1currentBatter % 9).getName());

					// if pitcher throws a strike
					if (p2.pitch()) {
						// if batter hits
						if (t1.get(t1currentBatter % 9).hit()) {
							// reset the number of balls and strikes, and get a new batter, add 1 to the
							// number of hits
							balls = 0;
							strikes = 0;
							t1currentBatter++;
							hits++;
							System.out.println("Hit");

							// team scores a point if home plate is reached
							if (hits >= 4) {
								t1score++;
								System.out.println("T1 reaches home plate. Score");
								System.out.println("Game Score is now T1: " + t1score + " T2: " + t2score);
							}
						}
						// batter swings and misses
						else {
							// add 1 to the number of strikes
							strikes++;
							System.out.println("Swing and Miss");
							System.out.println("Strike - Balls: " + balls + " Strikes: " + strikes);
						}
					}
					// pitcher throws a ball
					else {
						// add 1 to the number of balls
						balls++;
						System.out.println("Ball - Balls: " + balls + " Strikes: " + strikes);
					}
					// if number of balls is 4, then it's a walk
					if (balls == 4) {
						// reset number of strikes and balls, get a new batter, add 1 to number of hits
						balls = 0;
						strikes = 0;
						t1currentBatter++;
						hits++;
						System.out.println("Walk");
					}
					// if the number of strikes is 3, then it's a strike-out
					if (strikes == 3) {
						// reset number of strikes and balls, add 1 to number of outs, get a new batter
						strikes = 0;
						balls = 0;
						outs++;
						t1currentBatter++;
						System.out.println("Strike out");
						System.out.println("T1's Total Outs: " + outs);
					}
					// Every hit is a single. Everyone moves bases after a hit
					// if there is 1 hit, first base is secured
					if (hits == 1) {
						System.out.println("On first");
					}
					// if there are 2 hits, first and second bases are secured
					else if (hits == 2) {
						System.out.println("On first and second");
					}
					// if there are at least 3 hits, first, second and third bases are secured
					else if (hits >= 3) {
						System.out.println("On first, second and third");
					}
				}
				// reset the counters after each inning
				balls = 0;
				strikes = 0;
				hits = 0;
				outs = 0;

				// play extra innings after 9 innings, and keep going until one team is finally
				// ahead at the end of an inning
				if (inning >= 9 && t1score > t2score) {
					break;
				} else if (inning >= 9 && t1score < t2score) {
					break;
				}
			}
			// game over after ... innings
			System.out.println("Game " + game + " is over after " + inning + " innings");
			
			// determines game winner and tally up series score
			// T1 wins
			if (t1score > t2score) {
				t1wins++;
				System.out.println("T1 won game " + game + " " + t1score + " - " + t2score);
				System.out.println("Series Score T1: " + t1wins + " T2: " + t2wins + "\n");
			}
			// T2 wins
			else if (t1score < t2score) {
				t2wins++;
				System.out.println("T2 won game " + game + " " + t2score + " - " + t1score);
				System.out.println("Series Score T1: " + t1wins + " T2: " + t2wins + "\n");
			}
			// determines series winner and print final series score
			// if T1 reaches 4 wins first, they win the series
			if (t1wins == 4) {
				System.out.println("Series is over after " + game + " games");
				System.out.println("T1 won the series " + t1wins + " - " + t2wins);
				break;
			}
			// if T2 reaches 4 wins first, they win the series
			else if (t2wins == 4) {
				System.out.println("Series is over after " + game + " games");
				System.out.println("T2 won the series " + t2wins + " - " + t1wins);
				break;
			}
		}
	}
}
