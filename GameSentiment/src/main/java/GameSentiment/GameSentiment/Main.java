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


public class Main 
{
    public static void main( String[] args )
    {

    	String topic="metal gear gameplay";
    	BlackListController bl=new BlackListController();
    	GameSentiment gs=new GameSentiment();
    	LinkedList<ComplexTweet> output=gs.exec(topic,bl,true);
        ManagerMongoDb m=new ManagerMongoDb();
        for(ComplexTweet t:output){
        	m.insertDocument(t);
        	
        }
        System.out.println(output.size());

        
        }	
 
        
 
        

}
