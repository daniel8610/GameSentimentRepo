package GameSentiment.Utility;

public class TweetCleaner {
	
	//regex rimuovi un qualsiasi stringa che inizia con # e contiene 0 (*)o piu lettere presenti in [A-Za-z] o ( | )....
	public static String cleanTweet(String text){
		return text.replaceAll("#[A-Za-z]*|@[A-Za-z]*", "");
	}

}
