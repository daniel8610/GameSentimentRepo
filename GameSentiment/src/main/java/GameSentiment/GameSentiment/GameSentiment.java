package GameSentiment.GameSentiment;

import java.util.ArrayList;
import java.util.LinkedList;

import GameSentiment.Utility.HtmlCleaner;
import GameSentiment.Utility.TweetCleaner;
import GameSentiment.Utility.URLextractor;

public class GameSentiment {
	private INamedEntityRecognition NERlibrary;
public GameSentiment(){
	WrapperSentimentStanford.init();
	this.NERlibrary=NERFactory.getIstance().getStanfordNLP();
}
public LinkedList<Tweet> exec(String topic){
	LinkedList<Tweet> output=new LinkedList<Tweet>();
	LinkedList<String> entita=null;
	ArrayList<String> tweets=TweetManager.getTweets(topic);
	 for(String text:tweets){
     	if(text.length()>0){
     	int sentiment=WrapperSentimentStanford.findSentiment(text);
     	String url=URLextractor.extractURL(text);
     	if(url!=null){
     	String testopag=HtmlCleaner.getAndCleanHtml(url);
     	entita=NERlibrary.getEntities(testopag);
     	}
     	text=TweetCleaner.cleanTweet(text);
     	Tweet tweet=new Tweet(topic,text,sentiment,url,entita);
     	output.add(tweet);
     	}
     					
     	}
	
	return output;
	
}
}
