package klsa.test.justai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    @JsonProperty("from_id")
    private int fromId;
    private String text;
    private int id;
}
