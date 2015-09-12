package GameSentiment.GameSentiment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class WriterTweets {
	private BufferedWriter bw;
	
public WriterTweets(String pathFile){
	File fout = new File(pathFile);
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(fout);
		this.bw = new BufferedWriter(new OutputStreamWriter((fos), "UTF-8"));
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
/*METODO ORIGINALE
public void writeEntities(List<String> lista,String url){
	if(lista!=null){
	for(String ent:lista){
		try {
			this.bw.write(url+","+ent);
			this.bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}
	
}*/
//METODO SCRIVE TUTTO IN UNA RIGA
public void writeTweet(ArrayList<String> listaTweet) throws IOException {
	if(listaTweet!=null){
		
	for(String tweet:listaTweet){
		try {
			this.bw.write(tweet);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	}
	
}


public void closeWriter(){
	try {
		this.bw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
