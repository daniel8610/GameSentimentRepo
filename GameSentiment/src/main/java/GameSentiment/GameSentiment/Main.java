package GameSentiment.GameSentiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;



import GameSentiment.Repository.ManagerMongoDb;
import GameSentiment.Utility.BlackListController;



public class Main 
{
    public static void main( String[] args ) throws IOException
    {

    	System.out.println("Inserire nome del videogame e argomento (graphics,sound,gameplay,story) su cui fare ricerca   ");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String topic = br.readLine();
    	//String topic="metal gear gameplay";
    	BlackListController bl=new BlackListController();
    	GameSentiment gs=new GameSentiment();
    	LinkedList<ComplexTweet> output=gs.exec(topic,bl,true);
        
    	ManagerMongoDb m=new ManagerMongoDb();
        for(ComplexTweet t:output){
        	m.insertDocument(t);
        	
        }
        

        
        }	
 
        
 
        

}
