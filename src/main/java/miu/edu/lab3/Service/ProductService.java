package miu.edu.lab3.Service;


import miu.edu.lab3.Dto.ProductDto;
import miu.edu.lab3.Entity.Category;
import miu.edu.lab3.Entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllMinPrice(float price);
    List<ProductDto> getAllByname(String name);
    List<ProductDto> getAllProdByCatByMaxPrice(Category category_id, float price);
    List<ProductDto> getAllProdByUserId(int id);
    ProductDto addProduct(Product product);
    List<ProductDto> getAll();
    boolean delteByIdSoft(int id);



}
