package miu.edu.lab3.Repository;
import miu.edu.lab3.Dto.ProductDto;
import miu.edu.lab3.Entity.Category;
import miu.edu.lab3.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<ProductDto> findAllByPriceGreaterThan(float price);

    List<ProductDto> findAllProductsByNameIsContaining(String name);

    List<ProductDto> findProductsByCategoryAndPriceLessThan(Category category_id, float price);

    List<ProductDto> findAlProductsByUserid(int id);






}
