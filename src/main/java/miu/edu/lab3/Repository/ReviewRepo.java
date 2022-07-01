package miu.edu.lab3.Repository;


import miu.edu.lab3.Dto.ReviewDto;
import miu.edu.lab3.Entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {

    List<ReviewDto> findAllReviewById(int id);
}
