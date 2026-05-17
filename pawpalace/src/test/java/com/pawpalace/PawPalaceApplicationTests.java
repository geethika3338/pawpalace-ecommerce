package com.pawpalace;

import com.pawpalace.model.Product;
import com.pawpalace.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@SpringBootTest
class PawPalaceApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
        // Test if the Spring application context loads successfully
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertTrue(products.size() > 0, "There should be default products inserted by schema.sql");
    }

}
