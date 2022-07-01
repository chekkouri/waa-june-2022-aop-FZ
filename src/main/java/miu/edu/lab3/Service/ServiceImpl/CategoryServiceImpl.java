package miu.edu.lab3.Service.ServiceImpl;

import miu.edu.lab3.Dto.CategoryDto;
import miu.edu.lab3.Entity.Category;
import miu.edu.lab3.Repository.CategoryRepo;
import miu.edu.lab3.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public Category addCategory(Category cat) {
        cat.set_deleted(false);
        return categoryRepo.save(cat);
    }


    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> result = new ArrayList<CategoryDto>();
        categoryRepo.findAll().forEach(x->{
            if(!x.is_deleted()){
                CategoryDto cat = modelMapper.map(x, CategoryDto.class);
                result.add(cat);
            }
        });
        return result;
    }

    //hard delete
    @Override
    public void deleteById(int id) {
        categoryRepo.deleteById(id);

    }

    //soft delete
    @Override
    public boolean deleteBySoft(int id) {
        Optional<Category> findCat = categoryRepo.findById(id);
        if(findCat.isPresent()){
            Category loCategory= findCat.get();
            loCategory.set_deleted(true);
            categoryRepo.save(loCategory);
            return true;
        }
        return false;
    }
}
