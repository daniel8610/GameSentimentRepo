package GameSentiment.Repository;

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
//Da finire fa schifo devi gestire quando non cè url
public void insertDocument(Tweet tw){
	BasicDBObject doc = new BasicDBObject("user", tw.getUser()) 
    .append("text", tw.getText())
    .append("sentiment", tw.getSentiment());
	this.collection.insert(doc);
}

}
