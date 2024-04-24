package sti.maksim.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HttpTest {

    //HttpFetcherImpl fetcher = new HttpFetcherImpl();

   HttpService httpService;

   @BeforeEach
   public void beforeEach () {
       httpService = new HttpService(new HttpFetcherImpl());
   }


    @Test
    public void test1 () {

        String url = "https://jsonplaceholder.typicode.com/posts";
        //
        HttpService httpService = new HttpService(new HttpFetcherImpl());

        String result2 = httpService.fetchData(url);
        System.out.println(result2);

//        String result = fetcher.fetchDataForUrl(url);
//        System.out.println(result);

       assertNotNull(httpService.fetchData(url));
    }

    @Test
    public void test2 () {
        String poorUrl = "https:/jsonplaceholder.typicode.com/posts";

        String result = httpService.fetchData(poorUrl);

        Assertions.assertNull(result);
    }

    @Test
    public void test3 () {

        String nullUrl = null;
        String url = "https://jsonplaceholder.typicode.com/posts";
        String falseUrl = "jsonplaceholder.typicode.com/posts";
        //String result = httpService.fetchData(nullUrl); // Will fail test

        Assertions.assertThrows(IllegalArgumentException.class, () -> {httpService.fetchData(nullUrl);});

        //Assertions.assertThrows(service.fetchData(nullUrl));

    }

    @Test
    public void test4 () {
        String falseUrl = "jsonplaceholder.typicode.com/posts";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {httpService.fetchData(falseUrl);});

    }

    @Test
    public void test5 () {
        String url = "httpsjsonplaceholder.typicode.com/posts";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {httpService.fetchData(url);});
    }

}
