package GameSentiment.GameSentiment;

import java.io.IOException;
import java.util.ArrayList;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;


public class main 
{
    public static void main( String[] args )
    {
    	ArrayList<String> tweet=TweetManager.getTweets("Metal gear ");
        System.out.println( tweet.size() );
        WriterTweets wt=new WriterTweets("target/outputTweet3.txt");
        try {
			wt.writeTweet(tweet);
			wt.closeWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
    	/* estrattore link
    	  String input = "Metal Gear Solid 5: The Phantom Pain Graphics Comparison j://t.co/Xf5gbKI5Cv";
    	LinkExtractor linkExtractor = LinkExtractor.builder().build();
    	Iterable<LinkSpan> links = linkExtractor.extractLinks(input);
    	LinkSpan link = links.iterator().next();
    	link.getType();        // LinkType.URL
    	link.getBeginIndex();  // 17
    	link.getEndIndex();    // 32
    	System.out.println(input.substring(link.getBeginIndex(), link.getEndIndex()));  // "http://test.com"
    	*/
    	//WrapperStanfordNLP.init();
    	//System.out.println(WrapperStanfordNLP.findSentiment2("Even with a slightly larger screen, the iPhone remains comfortable to hold. With fast performance, a great display, an elegant new design and a much-needed software update, it's one of the best smartphones you can buy right now. We wish it had the same long battery life as the iPhone 6 Plus (not to mention its optical image stabilization) but even then, the iPhone 6 is still the better choice for most people."));
        
    }
}
