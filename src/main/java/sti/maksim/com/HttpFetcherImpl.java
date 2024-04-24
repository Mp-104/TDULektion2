package sti.maksim.com;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class HttpFetcherImpl implements HttpFetcher {

    private HttpClient httpClient = HttpClients.createDefault();

    @Override
    public String fetchDataForUrl(String url) {

        String responseData = null;
        try{
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            responseData = EntityUtils.toString(response.getEntity(), "UTF-8");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return responseData;
    }



}
