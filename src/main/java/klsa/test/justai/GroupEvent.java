package klsa.test.justai;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class GroupEvent {
    private String type;
    private Map<String, Object> object;
    private int group_id;
}
