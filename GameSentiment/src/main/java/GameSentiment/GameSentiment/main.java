package GameSentiment.GameSentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;

import GameSentiment.Utility.HtmlCleaner;
import GameSentiment.Utility.URLextractor;


public class main 
{
    public static void main( String[] args )
    {
    	String topic="Metal gear graphics";
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
        
        
        
        /*Per scrivere su file
         WriterTweets wt=new WriterTweets("target/outputTweet3.txt");
        try {
			wt.writeTweet(tweet);
			wt.closeWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
    	
    	//WrapperStanfordNLP.init();
    	//System.out.println(WrapperStanfordNLP.findSentiment2("Even with a slightly larger screen, the iPhone remains comfortable to hold. With fast performance, a great display, an elegant new design and a much-needed software update, it's one of the best smartphones you can buy right now. We wish it had the same long battery life as the iPhone 6 Plus (not to mention its optical image stabilization) but even then, the iPhone 6 is still the better choice for most people."));
        
    
}
