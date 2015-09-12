package GameSentiment.GameSentiment;

import java.io.IOException;
import java.util.ArrayList;


public class main 
{
    public static void main( String[] args )
    {
    	/*ArrayList<String> tweet=TweetManager.getTweets("Metal gear graphics");
        System.out.println( tweet.size() );
        WriterTweets wt=new WriterTweets("target/outputTweet3.txt");
        try {
			wt.writeTweet(tweet);
			wt.closeWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
    	WrapperStanfordNLP.init();
    	System.out.println(WrapperStanfordNLP.findSentiment("Even with a slightly larger screen, the iPhone remains comfortable to hold. With fast performance, a great display, an elegant new design and a much-needed software update, it's one of the best smartphones you can buy right now. We wish it had the same long battery life as the iPhone 6 Plus (not to mention its optical image stabilization) but even then, the iPhone 6 is still the better choice for most people."));
        
    }
}
