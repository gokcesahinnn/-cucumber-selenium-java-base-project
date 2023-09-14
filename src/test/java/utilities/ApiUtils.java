package utilities;

import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiUtils {
    public static class RestApiUtil {

        public static String getRequest(String uri, String path) throws Exception {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uri + path);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            httpClient.close();
            return result;
        }

        public static String getRequest(String uri, String path, Map<String, String> header) throws Exception {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uri + path);
            if (header != null) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            httpClient.close();
            return result;
        }


        public static String getRequestWithAllResponse(String uri, String path, Map<String, String> options) throws Exception {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            RequestBuilder requestBuilder = RequestBuilder.get(uri + path);
            for (Map.Entry<String, String> entry : options.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
            CloseableHttpResponse response = httpClient.execute(requestBuilder.build());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            httpClient.close();
            return result;
        }

        public static String getRequestWithQuery(String uri, String path, String query, Map<String, String> header) throws Exception {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uri + path + "?" + query);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            httpClient.close();
            return result;
        }

        public static String postRequest(String uri, String path, String body, Map<String, String> options) throws Exception {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri + path);
            StringEntity stringEntity = new StringEntity(body);
            httpPost.setEntity(stringEntity);
            for (Map.Entry<String, String> entry : options.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            httpClient.close();
            return result;
        }

        // Diğer metodları da aynı şekilde dönüştürebilirsiniz
    }
}

