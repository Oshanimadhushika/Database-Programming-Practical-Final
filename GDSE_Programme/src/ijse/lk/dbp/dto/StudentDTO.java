package ijse.lk.dbp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    String student_id;
    String student_name;
    String email;
    String contact;
    String address;
    String nic;
}
