package miu.edu.lab3.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class ActivityLog {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String operation;
    private  String duration;
}
