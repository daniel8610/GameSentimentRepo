package GameSentiment.GameSentiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import GameSentiment.Utility.HtmlCleaner;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;

public class Prova {
public static void main(String []args){
	/*
	Twitter tw=new TwitterFactory().getInstance();
	ArrayList<String> listatweet=new ArrayList<String>();
	LinkedList<String> expandedURLs=new LinkedList<String>();
	try {
	Query query=new Query("Metal gear graphics");
	query.setLang("en");
	QueryResult result;
	do{
      result=tw.search(query);
	List<Status> tweets=result.getTweets();
	for(Status tweet:tweets){
		if(!tweet.isRetweet()){
			URLEntity[]  urls=tweet.getURLEntities();
			System.out.println(urls.length);
			if(urls.length>0){
				for(int i=0;i<urls.length;i++)
					expandedURLs.add(urls[i].getExpandedURL());
			}
			
		listatweet.add(tweet.getText());
		}
	}
	
		
		
	}while((query=result.nextQuery())!=null);
} catch (TwitterException te) {
    te.printStackTrace();
    System.out.println("Superato limite");
}
	for(String s:expandedURLs)
	 System.out.println(s+"   ");
	 */
	/*
	MongoClient mongoClient=new MongoClient( "localhost" , 27017 );
	DBCollection collection=mongoClient.getDB("test").getCollection("prove");
	BasicDBObject doc = new BasicDBObject();
	HashMap<String,LinkedList<String>> h=new HashMap();
	LinkedList l=new LinkedList();
	l.add("iphone");
	l.add("penna");
	h.put("OGGETTI", l);
	doc.put("nome", "casa");
	doc.put("urls", h);
	collection.insert(doc);
	
	
	String testopag=HtmlCleaner.getAndCleanHtml("http://www.10news.com/about/10news-team/rachel-bianco");
	System.out.println(NERFactory.getIstance().getStanfordNLP().getEntities(testopag).toString());
	*/
	LinkedList<String> l=new LinkedList();
	l.add("http://romanews.eu/2015/giornata-di-celebrazioni-per-florenzi-roma-gia-al-lavoro-per-il-sassuolo-ma-perde-szczesny-per-un-mese/");
	for(String s:l)
	System.out.println(s.contains("romanews.eu"));
	
	
	
	
}
}

