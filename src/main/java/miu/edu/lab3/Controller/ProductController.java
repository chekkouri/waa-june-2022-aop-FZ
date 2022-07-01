package miu.edu.lab3.Controller;


import miu.edu.lab3.Dto.ProductDto;
import miu.edu.lab3.Entity.Category;
import miu.edu.lab3.Entity.Product;
import miu.edu.lab3.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDto>> getAllMin(@RequestParam float price){
        return ResponseEntity.ok(productService.getAllMinPrice(price));
    }

    @GetMapping("/name")
    public ResponseEntity<List<ProductDto>> getAllNames(@RequestParam String name){
        return ResponseEntity.ok(productService.getAllByname(name));
    }


    @GetMapping("/category/price")
    public ResponseEntity<List<ProductDto>> getAllProductByCategory(@RequestParam Category category_id, @RequestParam float price){
            return ResponseEntity.ok(productService.getAllProdByCatByMaxPrice(category_id, price ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDto>> getProdByUserId(@PathVariable int id){
        return ResponseEntity.ok(productService.getAllProdByUserId(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }
    @PostMapping
    public ResponseEntity<ProductDto> addP(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }



    @DeleteMapping("/{id}")
    public void delete(@RequestParam int p) {
        productService.delteByIdSoft(p);
    }
}


