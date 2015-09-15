package GameSentiment.Repository;

import java.util.LinkedList;

import org.bson.Document;

import GameSentiment.GameSentiment.Tweet;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ManagerMongoDb {
private MongoClient mongoClient;
private DBCollection collection;
@SuppressWarnings("deprecation")
public ManagerMongoDb(){
	this.mongoClient=new MongoClient( "localhost" , 27017 );
	this.collection=mongoClient.getDB("test").getCollection("dbjava");
	
	
}
public void insertDocument(Tweet tw){
	String s="";
	BasicDBObject doc = new BasicDBObject("topic", tw.getTopic())
	.append("text", tw.getText()) 
    .append("sentiment", tw.getSentiment());
	if(tw.getUrl()!=null&&tw.getUrlEntity()!=null){
	  doc.append("url", tw.getUrl());
	  LinkedList<String> lista=tw.getUrlEntity();
	  for(String e:lista){
		  s+=e+",";
	  }
	  doc.append("entita", s);
	}
	this.collection.insert(doc);
}

}
