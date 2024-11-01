package base.pojos.createEmail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmailRequest {
    private Integer sender;
    private String recipient;
    private String subject;
    private String message;
}
