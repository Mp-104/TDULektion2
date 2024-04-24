package sti.maksim.com;

import org.apache.http.client.utils.URLEncodedUtils;
import java.net.URL;

public class HttpService {

    private final HttpFetcher httpFetcher;

    public HttpService(HttpFetcher httpFetcher) {
        this.httpFetcher = httpFetcher;
    }

    public static boolean isURL (String url) {
        try {
            new URL(url);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


    public String fetchData (String url) {




        // Kan innehålla logik.
        if(url == null) {
            throw new IllegalArgumentException("Url must not be null");

        } else {
            if (isURL(url) == false) {
                throw new IllegalArgumentException("Must be a valid URL");

            } else {

                // Logik före HTTP hämtningen..
                String result = httpFetcher.fetchDataForUrl (url);
                // Logik efter HTTP hämtningen..
                return result;
            }


        }

    }
}
