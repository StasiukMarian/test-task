package base.pojos.currentUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUser {
    private Integer id;
    private String username;
    private String email;
}
