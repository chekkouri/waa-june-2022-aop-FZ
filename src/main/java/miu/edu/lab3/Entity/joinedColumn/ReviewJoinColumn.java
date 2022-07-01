package miu.edu.lab3.Entity.joinedColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import miu.edu.lab3.Entity.Product;

import javax.persistence.*;

@Data
@Entity
public class ReviewJoinColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id")
    private Product products;

}
