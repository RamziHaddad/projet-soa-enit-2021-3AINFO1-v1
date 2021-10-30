package enit.bank.service;
import io.smallrye.mutiny.Multi;
import javax.inject.Inject;
import enit.bank.domain.Product;
import enit.bank.repository.ProductRepository;

public class ProductService {
    
    @Inject
    ProductRepository productRepository;
    
    public ProductService(ProductRepository prodRepo){
        this.productRepository= prodRepo;
    }

    public Multi<Product> getProds(){
        return productRepository.getProducts();
    }

    public Product getById(Integer id){
        return productRepository.getById(id);
    }

    public Product update (Product prod){
        return productRepository.update(prod);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

}
