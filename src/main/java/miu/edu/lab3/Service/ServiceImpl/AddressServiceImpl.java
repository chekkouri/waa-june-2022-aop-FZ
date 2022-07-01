package miu.edu.lab3.Service.ServiceImpl;

import miu.edu.lab3.Dto.AddressDto;
import miu.edu.lab3.Entity.Address;
import miu.edu.lab3.Repository.AddressRepo;
import miu.edu.lab3.Service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Address addAddress(Address address) {
        address.set_deleted(false);
        return null;
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<AddressDto> result = new ArrayList<AddressDto>();
        addressRepo.findAll().forEach(x->{
            if(!x.is_deleted()){
                AddressDto ad = modelMapper.map(x, AddressDto.class);
               result.add(ad);
            }
        });

        return result;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean deleteBySoft(int id) {
        return false;
    }
}
