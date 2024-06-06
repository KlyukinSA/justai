package klsa.test.justai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationService {
    @Value("${confirmation.string}")
    private String confirmationString;

    public String getConfirmationString() {
        return confirmationString;
    }
}
