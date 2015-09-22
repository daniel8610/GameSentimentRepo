package GameSentiment.review;

import java.util.LinkedList;

import GameSentiment.Repository.ManagerMongoDb;

public class ReviewCalculator {
	private ManagerMongoDb repository;
	private  LinkedList<String> review;
	public ReviewCalculator(){
		this.repository=new ManagerMongoDb();
		this.review=new LinkedList<String>();
		review.add("graphics");
		review.add("sound");
		review.add("story");
		review.add("gameplay");
		
		
	}
public  Review calculateScores(String name){	
	double tot,positive,score;
	Review r= new Review(name);
	for(String s: this.review ){
		tot=this.repository.count(name+" "+s);
		positive=this.repository.countGreaterThan(name+" "+s);
		score=(positive/tot)*100;
		r.setScore(s, score);
		}
	
	return r;
	
	
	
}
}
