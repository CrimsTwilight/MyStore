package by.crims.mystore.service;

import by.crims.mystore.entity.CategoryOfProduct;
import by.crims.mystore.entity.Product;
import by.crims.mystore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean save(Product product) {
        Optional<Product> productOpt = productRepository.findById(product.getId());
        if (productOpt.isPresent()) {
            return false;
        } else {
            productRepository.save(product);
            return true;
        }
    }

    public boolean updateName(Product product, String newName) {
        if(product.getName().equals(newName)) {
            return false;
        } else {
            Optional<Product> productOpt = productRepository.findById(product.getId());
            if (productOpt.isPresent()) {
                Product productBase = productOpt.get();
                productBase.setName(newName);
                productRepository.save(productBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateDescription(Product product, String newDescription) {
        if(product.getDescription().equals(newDescription)) {
            return false;
        } else {
            Optional<Product> productOpt = productRepository.findById(product.getId());
            if (productOpt.isPresent()) {
                Product productBase = productOpt.get();
                productBase.setDescription(newDescription);
                productRepository.save(productBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateProductPicture(Product product, String picture) {
        if(product.getPicture().equals(picture)) {
            return false;
        } else {
            Optional<Product> productOpt = productRepository.findById(product.getId());
            if (productOpt.isPresent()) {
                Product productBase = productOpt.get();
                productBase.setPicture(picture);
                productRepository.save(productBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateTypeProduct(Product product, CategoryOfProduct newCategory) {
        if(product.getCategory().equals(newCategory)) {
            return false;
        } else {
            Optional<Product> productOpt = productRepository.findById(product.getId());
            if (productOpt.isPresent()) {
                Product productBase = productOpt.get();
                productBase.setCategory(newCategory);
                productRepository.save(productBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updatePrice(Product product, double newPrice) {
        Optional<Product> productOpt = productRepository.findById(product.getId());
        if (productOpt.isPresent()) {
            Product productBase = productOpt.get();
            productBase.setPrice(newPrice);
            productRepository.save(productBase);
            return true;
        } else {
            return false;
        }
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getById(long id) {
        return Optional.of(productRepository.getById(id));
    }

    public Optional<Product> getProductById(long productId){
        return productRepository.findById(productId);
    }
}
