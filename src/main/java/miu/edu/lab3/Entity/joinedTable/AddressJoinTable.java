package miu.edu.lab3.Entity.joinedTable;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class AddressJoinTable extends UserJoinTable {
    private int id;
    private String street;
    private int zip;
    private String city;

}
