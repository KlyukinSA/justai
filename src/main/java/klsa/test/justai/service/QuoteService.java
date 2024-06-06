package klsa.test.justai.service;

import klsa.test.justai.dto.Message;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QuoteService {
    @Value("${access.token}")
    private String accessToken;
    @Value("${api.version}")
    private String apiVersion;
    @Value("${api.url}")
    private String apiUrl;

    public void reply(Message message) throws IOException {
        FormBody formBody = new FormBody.Builder()
                .add("peer_id", String.valueOf(message.getFromId()))
                .add("message", quote(message.getText()))
                .add("access_token", accessToken)
                .add("v", apiVersion)
                .add("random_id", String.valueOf(message.getId()))
                .build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiUrl).post(formBody).build();
        client.newCall(request).execute();
    }
    private String quote(String text) {
        return "You said: " + text;
    }
}
