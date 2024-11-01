package base.pojos.email;

import lombok.Data;

@Data
public class EmailData {
    private Integer id;
    private Integer sender;
    private String recipient;
    private String subject;
    private String message;
}
