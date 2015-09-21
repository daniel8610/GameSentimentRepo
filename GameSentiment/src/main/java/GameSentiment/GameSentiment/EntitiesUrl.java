package GameSentiment.GameSentiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class EntitiesUrl {
  private String url;
  private HashMap<String,LinkedList<String>>  entities;
  public EntitiesUrl(String url,HashMap<String,LinkedList<String>> e){
	  this.setUrl(url);
	  this.setEntities(e);
	  
  }
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public HashMap<String,LinkedList<String>> getEntities() {
	return entities;
}
public void setEntities(HashMap<String,LinkedList<String>> entities) {
	this.entities = entities;
}
public LinkedList<String> getEntetiesList(){
	LinkedList<String> lista=new LinkedList<String>();
	for(LinkedList<String> l:this.entities.values()){
		lista.addAll(l);
	}
	return lista;
}
public static void main(String []args){
	HashMap<String,LinkedList<String>> e=new HashMap<String,LinkedList<String>>();
	LinkedList<String> a=new LinkedList<String>();
	a.add("casa");
	LinkedList<String> b=new LinkedList<String>();
	b.add("tetto");
	e.put("1", a);
	e.put("3", b);
	
	EntitiesUrl u=new EntitiesUrl("ciao",e);
	System.out.println(u.getEntetiesList());
	
	
}
}
