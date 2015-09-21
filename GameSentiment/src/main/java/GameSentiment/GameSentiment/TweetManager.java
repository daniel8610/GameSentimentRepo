package GameSentiment.GameSentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import GameSentiment.Utility.UrlExpander;
import GameSentiment.Utility.TweetCleaner;
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
		int j=0;
		QueryResult result;
		do{
			j++;
	      result=tw.search(query);
		List<Status> tweets=result.getTweets();
		for(Status tweet:tweets){
			if(!tweet.isRetweet()){
				URLEntity[]  urls=tweet.getURLEntities();
				LinkedList<String> expandedURLs=new LinkedList<String>();
				if(urls!=null||urls.length>0){
					for(int i=0;i<urls.length;i++){
						expandedURLs.add(UrlExpander.expandUrl(urls[i].getExpandedURL()));
						}
			   }
				listatweet.add(new SimpleTweet(TweetCleaner.cleanTweet(tweet.getText()),expandedURLs));
			}}}while((query=result.nextQuery())!=null&&j<10);
	} catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Superato limite");
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
		
		
		
		
		return listatweet;
		
	}
	public static void main(String []args){
		List<SimpleTweet> l=TweetManager.getTweets("peace");
		for(SimpleTweet t:l)
			System.out.println(t.getText());
		System.out.println(l.size());
			
	}
}
