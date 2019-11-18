package eu.epitech.cashmanager.service;

import eu.epitech.cashmanager.domain.Product;
import eu.epitech.cashmanager.domain.ProductPicture;
import eu.epitech.cashmanager.exception.NotFoundException;
import eu.epitech.cashmanager.repository.ProductPictureRepository;
import eu.epitech.cashmanager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductPictureRepository productPictureRepository;

    public ProductService(ProductRepository productRepository, ProductPictureRepository productPictureRepository) {
        this.productRepository = productRepository;
        this.productPictureRepository = productPictureRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        this.productRepository.findAll()
                .forEach(products::add);
        return products;
    }

    public Product getProduct(int id) {
        return this.productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Product with id %d", id)));
    }

    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void updateProduct(Product product) {
        this.productRepository.save(product);
    }

    public void deleteProduct(int id) {
        this.productRepository.deleteById(id);
    }

    /*
     * This method inserts mock products in the database.
     * This is for development purposes only and should not be used in production.
     */
    @PostConstruct
    public void init() {
        this.insertProduct("iPhone", "an over expensive smartphone", 1299);
        this.insertProduct("coca-cola bottle", "soda", 1.99f);
        this.insertProduct("Samsung Smart TV", "television", 349.99f);
        this.insertProduct("Tesla Model 3", "electric car", 30815);
        this.insertProduct("Lenovo Thinkpad T480", "portable compute", 1489);
    }

    private void insertProduct(String name, String description, float price) {
        List<ProductPicture> pictures = new ArrayList<>();
        ProductPicture pp1 = this.productPictureRepository.save(new ProductPicture("https://picsum.photos/200/300"));
        ProductPicture pp2 = this.productPictureRepository.save(new ProductPicture("https://picsum.photos/200/300"));

        pictures.add(pp1);
        pictures.add(pp2);
        if (this.productRepository.findByName(name) == null) {
            Product product = this.productRepository.save(new Product(0, name, description, price, pictures));

            pictures.forEach(productPicture -> {
                productPicture.setProduct(product);
                this.productPictureRepository.save(productPicture);
            });
        }
    }
}
