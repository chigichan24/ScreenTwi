import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;


/**
 * Created by chigichan24 on 2018/02/15.
 */

public class TwitterStream {
    public twitter4j.TwitterStream stream = null;

    public TwitterStream() {
        final boolean DEBUG = false;
        final String OAUTH_CONSUMERKEY = System.getenv("OAUTH_CONSUMERKEY");
        final String OAUTH_CONSUMERSECRET = System.getenv("OAUTH_CONSUMERSECRET");
        final String OAUTH_ACCESSTOKEN = System.getenv("OAUTH_ACCESSTOKEN");
        final String OAUTH_ACCESSTOKENSECRET = System.getenv("OAUTH_ACCESSTOKENSECRET");
        Configuration configuration = new ConfigurationBuilder()
                .setDebugEnabled(DEBUG)
                .setOAuthConsumerKey(OAUTH_CONSUMERKEY)
                .setOAuthConsumerSecret(OAUTH_CONSUMERSECRET)
                .setOAuthAccessToken(OAUTH_ACCESSTOKEN)
                .setOAuthAccessTokenSecret(OAUTH_ACCESSTOKENSECRET)
                .build();

        stream = new TwitterStreamFactory(configuration).getInstance();
    }


}
