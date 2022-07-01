package miu.edu.lab3.Entity.joinedTable;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ReviewJoinTable extends UserJoinTable{
    private int id;
    private String comment;

}
