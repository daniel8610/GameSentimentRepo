package GameSentiment.review;

import java.util.HashMap;

public class Review {
private String gameName;
private double graphics;
private double sound;
private double gameplay;
private double story;
private HashMap<String,Double> score;

public Review(String name){
	this.gameName=name;
	this.score=new HashMap<String,Double>();
}
public void setScore(String name,double score){
	this.score.put(name, new Double(score));
}
public double getScore(String name){
	return this.score.get(name);
}
public double getGraphics() {
	return graphics;
}

public void setGraphics(double graphics) {
	this.graphics = graphics;
}

public double getSound() {
	return sound;
}

public void setSound(double sound) {
	this.sound = sound;
}

public double getGameplay() {
	return gameplay;
}

public void setGameplay(double gameplay) {
	this.gameplay = gameplay;
}

public double getStory() {
	return story;
}

public void setStory(double story) {
	this.story = story;
}
public String toString(){
	
	return "Game : "+this.gameName+"\n"+"Graphics Score : "+this.score.get("graphics")+"\n"+ "Sound Score : "+this.score.get("sound")+"\n"+"Story Score : "+this.score.get("story")+"\n"+
			"Gameplay Score : "+this.score.get("gameplay")+"\n";
	
}
}
