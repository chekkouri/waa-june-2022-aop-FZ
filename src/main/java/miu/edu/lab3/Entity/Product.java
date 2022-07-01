package miu.edu.lab3.Entity;
import lombok.*;

import javax.persistence.*;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private String rating;
    private boolean is_deleted;

    @ManyToOne
    private Category category;



}
