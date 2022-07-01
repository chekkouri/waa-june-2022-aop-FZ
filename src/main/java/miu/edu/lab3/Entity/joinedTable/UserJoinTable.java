package miu.edu.lab3.Entity.joinedTable;
import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserJoinTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}