package top.summus.notionmiddleware.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HttpUtil {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static ResponseEntity postJson(String url, Map<String, String> header, String body) throws IOException {
        header= Optional.ofNullable(header).orElse(new HashMap<>());
        header.put("ContentType","application/json");
        return post(url,header,body);
    }

    public static ResponseEntity post(String url, Map<String, String> header, String body)
            throws IOException {
        HttpPost httpPost = new HttpPost(url);
        header.forEach(httpPost::setHeader);

        StringEntity bodyEntity=new StringEntity(body,"UTF-8");
        httpPost.setEntity(bodyEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() != 200) {
            response.close();
            return new ResponseEntity(response.getStatusLine().getStatusCode(), null);
        }
        String responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");

        response.close();

        return new ResponseEntity(200, responseContent);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ResponseEntity {
        private int code;
        private String content;
    }
}
