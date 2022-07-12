package ijse.lk.dbp.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    String student_id;
    String student_name;
    String email;
    String contact;
    String address;
    String nic;
}

