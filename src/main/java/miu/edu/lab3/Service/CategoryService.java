package miu.edu.lab3.Service;


import miu.edu.lab3.Dto.CategoryDto;
import miu.edu.lab3.Entity.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category cat);
    List<CategoryDto> getAllCategory();
    void deleteById( int id);
    boolean deleteBySoft(int id);

}
