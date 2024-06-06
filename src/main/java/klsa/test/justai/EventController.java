package klsa.test.justai;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;


@RestController
public class EventController {
    @Value("${confirmation.string}")
    private String confirmationString;
    @Value("${access.token}")
    private String accessToken;
    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.version}")
    private String apiVersion;

    @PostMapping
    public ResponseEntity<String> processRequest(@RequestBody GroupEvent event) throws IOException {
        if (event.getType().equals("confirmation")) {
            return ResponseEntity.ok(confirmationString);
        } else if (event.getType().equals("message_new")) {
            Map<String, Object> object = event.getObject();
            Map<String, Object> message = (Map<String, Object>) object.get("message");
            sendMessage((int) message.get("from_id"), (String) message.get("text"), (int) message.get("id"));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    private void sendMessage(int to, String origin, int messageId) throws IOException {
        String postBody = "peer_id=" + to + "&message=You said: " + origin + "&access_token=" + accessToken + "&v=" + apiVersion + "&random_id=" + messageId;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiUrl).post(okhttp3.RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), postBody)).build();
        client.newCall(request).execute();
    }
}
