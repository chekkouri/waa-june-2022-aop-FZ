package miu.edu.lab3.Entity.joinedColumn;


import lombok.Data;
import miu.edu.lab3.Entity.Address;

import javax.persistence.*;

@Data
@Entity
public class UserJoinColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
