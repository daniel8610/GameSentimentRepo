package GameSentiment.Utility;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;

public class HtmlCleaner {
public static String getAndCleanHtml(String url){
	Document doc;
	String text="";
	try {
		doc = Jsoup.connect(url).get();
		text = ArticleExtractor.INSTANCE.getText(doc.html());
	} catch (IOException e) {
		System.out.println(url +" pagina offline");
		return null;
	}catch (BoilerpipeProcessingException e) {
		e.printStackTrace();
	}catch (IllegalArgumentException e){
		System.out.println(url +" url malformed");
		return null;
	}
	
	return text;
}
}
