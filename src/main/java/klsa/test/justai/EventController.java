package klsa.test.justai;

import klsa.test.justai.dto.GroupEvent;
import klsa.test.justai.dto.Message;
import klsa.test.justai.service.ConfirmationService;
import klsa.test.justai.service.QuoteService;
import lombok.RequiredArgsConstructor;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class EventController {
    private final ConfirmationService confirmationService;
    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<String> processRequest(@RequestBody GroupEvent event) throws IOException {
        if (event.getType().equals("confirmation")) {
            return ResponseEntity.ok(confirmationService.getConfirmationString());
        } else if (event.getType().equals("message_new")) {
            quoteService.reply(event.getObject().getMessage());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
