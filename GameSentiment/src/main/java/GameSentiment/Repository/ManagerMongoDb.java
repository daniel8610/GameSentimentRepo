package GameSentiment.Repository;

import java.util.LinkedList;

import org.bson.Document;

import GameSentiment.GameSentiment.ComplexTweet;
import GameSentiment.GameSentiment.EntitiesUrl;
import GameSentiment.review.Review;
import GameSentiment.review.ReviewCalculator;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

public class ManagerMongoDb {
private MongoClient mongoClient;
private MongoCollection<Document> collection;
@SuppressWarnings("deprecation")
public ManagerMongoDb(){
	this.mongoClient=new MongoClient( "localhost" , 27017 );
	this.collection=mongoClient.getDatabase("test").getCollection("gameSentiment");
	
	
}
public void insertDocument(ComplexTweet tw){
	String s="";
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
public static void main(String []args){
	ManagerMongoDb m=new ManagerMongoDb();
	System.out.println(m.count("metal gear graphics"));
	ReviewCalculator rc=new ReviewCalculator();
	Review r=rc.calculateScores("metal gear");
	System.out.println(r.getScore("graphics"));
	
}
}
