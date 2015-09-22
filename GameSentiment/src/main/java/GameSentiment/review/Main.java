package GameSentiment.review;

public class Main {
	public static void main(String []args){
		
		ReviewCalculator rc=new ReviewCalculator();
		Review r=rc.calculateScores("metal gear");
		System.out.println(r.toString());
		
	}

}
