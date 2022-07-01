package miu.edu.lab3.Service.ServiceImpl;

import miu.edu.lab3.Dto.Userdto;
import miu.edu.lab3.Repository.UserRepo;
import miu.edu.lab3.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private  UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;




}
