package GameSentiment.Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String []args) throws IOException{
		System.out.println("Inserire nome del videogame   ");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String game = br.readLine();
		ReviewCalculator rc=new ReviewCalculator();
		Review r=rc.calculateScores(game);
		System.out.println(r.toString());
		
	}

}
