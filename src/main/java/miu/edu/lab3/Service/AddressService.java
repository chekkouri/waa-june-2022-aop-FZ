package miu.edu.lab3.Service;


import miu.edu.lab3.Dto.AddressDto;
import miu.edu.lab3.Entity.Address;

import java.util.List;

public interface AddressService {

    Address addAddress(Address address);
    List<AddressDto> getAllAddress();
    void deleteById(int id);
    boolean deleteBySoft(int id);



}
