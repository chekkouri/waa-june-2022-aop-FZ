package miu.edu.lab3.Service.ServiceImpl;
import miu.edu.lab3.Dto.ReviewDto;
import miu.edu.lab3.Repository.ReviewRepo;
import miu.edu.lab3.Service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReviewDto> getAllReviewById(int id) {

        List<ReviewDto> result = new ArrayList<ReviewDto>();
        reviewRepo.findAllReviewById(id).stream().map(x-> result.add(modelMapper.map(x,ReviewDto.class)));
        return result;

    }
}
