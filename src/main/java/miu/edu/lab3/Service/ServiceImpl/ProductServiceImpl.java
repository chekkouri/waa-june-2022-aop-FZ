package miu.edu.lab3.Service.ServiceImpl;

import miu.edu.lab3.Dto.ProductDto;
import miu.edu.lab3.Entity.Category;
import miu.edu.lab3.Entity.Product;
import miu.edu.lab3.Repository.CategoryRepo;
import miu.edu.lab3.Repository.ProductRepo;
import miu.edu.lab3.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllMinPrice(float price) {
        List<ProductDto> result = new ArrayList<ProductDto>();
        productRepo.findAllByPriceGreaterThan(price)
                .stream()
                .map(x -> result.add(modelMapper.map(x, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> getAllByname(String name) {
        List<ProductDto> result = new ArrayList<ProductDto>();
        productRepo.findAllProductsByNameIsContaining(name).forEach(x -> {
            if (x != null) {
                ProductDto p = modelMapper.map(x, ProductDto.class);
                result.add(p);
            }
        });

        return result;
    }

    @Override
    public List<ProductDto> getAllProdByCatByMaxPrice(Category category_id, float price) {
        List<ProductDto> result = new ArrayList<ProductDto>();
        productRepo.findProductsByCategoryAndPriceLessThan(category_id, price).stream().map(x -> result.add(modelMapper.map(x, ProductDto.class)));
        return result;
    }

    @Override
    public List<ProductDto> getAllProdByUserId(int id) {

        List<ProductDto> result = new ArrayList<ProductDto>();
        productRepo.findAlProductsByUserid(id).stream().map(x -> result.add(modelMapper.map(x, ProductDto.class)));
        return result;
    }



    @Override
    public ProductDto addProduct(Product product) {
        Optional<Category> cat = categoryRepo.findById(product.getCategory().getId());
        if (cat.isPresent()) {
            product.setCategory(cat.get());
            product.set_deleted(false);
            return modelMapper.map(productRepo.save(product), ProductDto.class);
        }

        return new ProductDto();
    }




    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> result = new ArrayList<ProductDto>();
        productRepo.findAll().forEach(x -> {
            if (!x.is_deleted()) {
                ProductDto p = modelMapper.map(x, ProductDto.class);
                result.add(p);
            }
        });
        return result;
    }

    // hard delete
    //@Override
   // public void deleteById(int id) {
       // productRepo.deleteById(id);
    //}

    // soft delete
    @Override
    public boolean delteByIdSoft(int id) {
        Optional<Product> findProduct = productRepo.findById(id);
        if(findProduct.isPresent()){
            Product loProduct = findProduct.get();
            loProduct.set_deleted(true);
            return true;
        }
        return false;
    }

}