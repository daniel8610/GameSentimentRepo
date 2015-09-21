package GameSentiment.Repository;

import java.util.LinkedList;

import org.bson.Document;

import GameSentiment.GameSentiment.ComplexTweet;
import GameSentiment.GameSentiment.EntitiesUrl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ManagerMongoDb {
private MongoClient mongoClient;
private DBCollection collection;
@SuppressWarnings("deprecation")
public ManagerMongoDb(){
	this.mongoClient=new MongoClient( "localhost" , 27017 );
	this.collection=mongoClient.getDB("test").getCollection("gameSentiment");
	
	
}
public void insertDocument(ComplexTweet tw){
	String s="";
	BasicDBObject doc = new BasicDBObject("topic", tw.getTopic())
	.append("text", tw.getText()) 
    .append("sentiment", tw.getSentiment());
	if(tw.getUrlEntity().size()>0){
		int i=0;
		for(EntitiesUrl e:tw.getUrlEntity()){
			i++;
			doc.append("url:"+i, e.getUrl());
			doc.append("entita:"+i, e.getEntities());
		}
	  
	}
	this.collection.insert(doc);
}

}
