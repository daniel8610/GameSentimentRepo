package GameSentiment.GameSentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;

import GameSentiment.Repository.ManagerMongoDb;
import GameSentiment.Utility.BlackListController;
import GameSentiment.Utility.HtmlCleaner;
import GameSentiment.Utility.TweetCleaner;
import GameSentiment.Utility.URLextractor;


public class main 
{
    public static void main( String[] args )
    {

    	String topic="Metal gear graphics";
    	BlackListController bl=new BlackListController();
    	GameSentiment gs=new GameSentiment();
    	LinkedList<ComplexTweet> output=gs.exec(topic,bl,true);
        ManagerMongoDb m=new ManagerMongoDb();
        for(ComplexTweet t:output){
        	m.insertDocument(t);
        	
        }

        
        }	
 
        
 
        

}
