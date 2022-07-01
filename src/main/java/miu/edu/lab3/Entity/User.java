package miu.edu.lab3.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @OneToMany(mappedBy = "users")
    List<Review> reviews;

    @OneToOne(mappedBy = "users")
    Address address;





}
