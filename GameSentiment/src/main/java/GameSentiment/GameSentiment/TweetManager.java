package GameSentiment.GameSentiment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;


public class TweetManager {

	public static LinkedList<SimpleTweet> getTweets(String q){
		Twitter tw=new TwitterFactory().getInstance();
		LinkedList<SimpleTweet> listatweet=new LinkedList<SimpleTweet>();
		try {
		Query query=new Query(q);
		query.setLang("en");
		QueryResult result;
		do{
	      result=tw.search(query);
		List<Status> tweets=result.getTweets();
		for(Status tweet:tweets){
			if(!tweet.isRetweet()){
				URLEntity[]  urls=tweet.getURLEntities();
				LinkedList<String> expandedURLs=new LinkedList<String>();
				if(urls!=null){
					for(int i=0;i<urls.length;i++)
						expandedURLs.add(urls[i].getExpandedURL());
				
				
			}
				listatweet.add(new SimpleTweet(tweet.getText(),expandedURLs));
			}
		}
		
			
			
		}while((query=result.nextQuery())!=null);
	} catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Superato limite");
    }	
		
		
		
		
		
		return listatweet;
		
	}
}
