package GameSentiment.Repository;

import java.util.LinkedList;

import org.bson.Document;

import GameSentiment.GameSentiment.ComplexTweet;
import GameSentiment.GameSentiment.EntitiesUrl;
import GameSentiment.Review.Review;
import GameSentiment.Review.ReviewCalculator;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

public class ManagerMongoDb {
private MongoClient mongoClient;
private MongoCollection<Document> collection;
public ManagerMongoDb(){
	this.mongoClient=new MongoClient( "localhost" , 27017 );
	this.collection=mongoClient.getDatabase("test").getCollection("gameSentiment");
	
	
}
public void insertDocument(ComplexTweet tw){
	Document doc = new Document("topic", tw.getTopic())
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
	this.collection.insertOne(doc);
}
public double countGreaterThan(String query){
	
	return this.collection.count(new Document("topic",query).append("sentiment", new Document("$gt",1)));
	
}
public double count(String query){
	return this.collection.count(new Document("topic",query));
	
}

}
