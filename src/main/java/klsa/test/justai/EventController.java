package klsa.test.justai;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Random;


@RestController
public class EventController {

    @Value("${confirmation.string}")
    private String confirmationString;

    @PostMapping
    public ResponseEntity<String> processRequest(@RequestBody GroupEvent event) throws IOException {
        if (event.getType().equals("confirmation")) {
            return ResponseEntity.ok(confirmationString);
        } else if (event.getType().equals("message_new")) {
            Map<String, Object> object = event.getObject();
            Map<String, Object> message = (Map<String, Object>) object.get("message");
            System.out.println(message);
            sendMessage((int) message.get("from_id"), (String) message.get("text"), (int) message.get("id"));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    private void sendMessage(int to, String origin, int messageId) throws IOException {
//        System.out.println(to);
//        System.out.println(origin);
        String accessToken = "vk1.a.r96nO6xm5s_KyTu7iOnWKEvrB02d3HA2CA1I5fFi-YGjiTSskreBMpd13VbFF66-28L2EeV9Pz2gSvcbd9v3fY6jCl1TvRlNnECYJDETkZWmR7RdqG4HJ4vy2O0ymtfYUzdNAld7Z7dRchMQ2cEwiSMcquLKNzTcHIdnzEqdA9_PQDTD5qfO4wGQsnK6OdFUakgOUMFPONYVw-BhNTnpzQ";
        int user = to;
        String url = "https://api.vk.com/method/messages.send";
        String postBody = "peer_id=" + user + "&message=test&access_token=" + accessToken + "&v=5.199" + "&random_id=" + messageId;
        //new Random().nextInt()
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).post(okhttp3.RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), postBody)).build();
        Response response = client.newCall(request).execute();
//        System.out.println(response.headers());
//        System.out.println(response.body().string());
    }
}
