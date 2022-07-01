package miu.edu.lab3.Service;

import miu.edu.lab3.Dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getAllReviewById(int id);
}
