package GameSentiment.GameSentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;

import GameSentiment.Repository.ManagerMongoDb;
import GameSentiment.Utility.HtmlCleaner;
import GameSentiment.Utility.URLextractor;


public class main 
{
    public static void main( String[] args )
    {
    	String topic="Metal gear graphics";
    	
    	GameSentiment gs=new GameSentiment();
    	LinkedList<Tweet> output=gs.exec(topic);
        ManagerMongoDb m=new ManagerMongoDb();
        for(Tweet t:output){
        	m.insertDocument(t);
        	
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
    	
    	
        
    
}
