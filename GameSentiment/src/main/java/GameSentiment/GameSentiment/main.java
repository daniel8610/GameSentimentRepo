package GameSentiment.GameSentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;

import GameSentiment.Utility.HtmlCleaner;
import GameSentiment.Utility.TweetCleaner;
import GameSentiment.Utility.URLextractor;


public class main 
{
    public static void main( String[] args )
    {
    	/*String topic="Metal gear graphics";
    	LinkedList<Tweet> output=new LinkedList<Tweet>();
    	LinkedList<String> entita=null;
    	ArrayList<String> tweets=TweetManager.getTweets(topic);
        System.out.println( tweets.size() );
        WrapperSentimentStanford.init();
        INamedEntityRecognition NERlibrary=NERFactory.getIstance().getStanfordNLP();
        for(String text:tweets){
        	if(text.length()>0){
        	int sentiment=WrapperSentimentStanford.findSentiment(text);
        	String url=URLextractor.extractURL(text);
        	if(url!=null){
        	String testopag=HtmlCleaner.getAndCleanHtml(url);
        	entita=NERlibrary.getEntities(testopag);
        	}
        	Tweet tweet=new Tweet(topic,text,sentiment,url,entita);
        	output.add(tweet);
        	}
        					
        	}
        
        	WriterTweets wt=new WriterTweets("target/outputTweet10.txt");
            try {
    			wt.writeTweet(output);
    			wt.closeWriter();
    		} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
        
        }	
   */
    	
        
        
        
        
        /*Per scrivere su file
         WriterTweets wt=new WriterTweets("target/outputTweet3.txt");
        try {
			wt.writeTweet(tweet);
			wt.closeWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
    	String f="I liked a @YouTube http://t.co/tSphXPehfR video from @candylandgs http://t.co/tSphXPehfR Metal Gear Solid 5 The Phantom Pain – PS3 vs. PS4 Graphics http://t.co/tSphXPehfR";
    	
    	System.out.println(TweetCleaner.cleanTweet(f));
    	WrapperSentimentStanford.init();
    	System.out.println(WrapperSentimentStanford.findSentiment2("I liked a  video from  Metal Gear Solid 5 The Phantom Pain – PS3 vs. PS4 Graphics"));
        
}
}
