package GameSentiment.GameSentiment;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;


public class TweetManager {

	public static ArrayList<String> getTweets(String q){
		Twitter tw=new TwitterFactory().getInstance();
		ArrayList<String> listatweet=new ArrayList<String>();
		try {
		Query query=new Query(q);
		query.setLang("en");
		QueryResult result;
		do{
	      result=tw.search(query);
		List<Status> tweets=result.getTweets();
		for(Status tweet:tweets){
			if(!tweet.isRetweet())
			listatweet.add(tweet.getText());
		}
		
			
			
		}while((query=result.nextQuery())!=null);
	} catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Superato limite");
    }	
		
		
		
		
		
		return listatweet;
		
	}
}
