package ijse.lk.dbp.view.tdm;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentTM {
    String student_id;
    String student_name;
    String email;
    String contact;
    String address;
    String nic;
}
