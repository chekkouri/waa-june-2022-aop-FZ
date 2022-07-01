package miu.edu.lab3.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {
        private int id;
        private String email;
        private String firstName;
        private String lastName;
}
