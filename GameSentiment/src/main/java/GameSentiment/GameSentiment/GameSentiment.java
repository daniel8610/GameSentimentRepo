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
	LinkedList<SimpleTweet> tweets=TweetManager.getTweets(topic);
	 for(SimpleTweet tw:tweets){
     	if(tw.getText().length()>0){
        String cleanText=TweetCleaner.cleanTweet(tw.getText());
     	int sentiment=WrapperSentimentStanford.findSentiment(cleanText);
     	if(tw.hasUrl()==true){
     	//String testopag=HtmlCleaner.getAndCleanHtml(url);
     	//entita=NERlibrary.getEntities(testopag);
     	}
     	//Tweet tweet=new Tweet(topic,cleanText,sentiment,url,entita);
     	//output.add(tweet);
     	}
     					
     	}
	
	return output;
	
}
}
