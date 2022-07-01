package miu.edu.lab3.Repository;
import miu.edu.lab3.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
