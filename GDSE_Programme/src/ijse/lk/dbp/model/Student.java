package ijse.lk.dbp.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    String student_id;
    String student_name;
    String email;
    String contact;
    String address;
    String nic;
}

