package GameSentiment.Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class BlackListController {
	private final static String pathlist="blacklist.txt";
	private LinkedList<String> blacklist;
	
	public BlackListController(){
		
	    this.blacklist=new LinkedList<String>();
		this.init();
		
	}
	private void init(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.pathlist));
			String url = reader.readLine();
	        while(url!=null) {
	            this.blacklist.add(url);
	            url = reader.readLine();
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   
	}
	public boolean urlCheck(String url){
		boolean check=false;
		for(String urlblacklist:this.blacklist ){
			url.contains(urlblacklist);
			if(url.contains(urlblacklist)){
				check=true;
			     break;
			}
		}
		
		return  check;
	}
	
public static void main(String []args){
	BlackListController b=new BlackListController();
	System.out.println(b.urlCheck("http://youtu.be/V1JvRbcP5ag?a"));
	
	
	
}
	
   
}
