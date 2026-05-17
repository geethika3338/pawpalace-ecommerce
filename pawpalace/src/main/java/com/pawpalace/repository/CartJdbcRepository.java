package com.pawpalace.repository;

import com.pawpalace.model.CartItem;
import com.pawpalace.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CartItem> cartItemRowMapper = new RowMapper<CartItem>() {
        @Override
        public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            CartItem item = new CartItem();
            item.setId(rs.getLong("id"));
            item.setUserId(rs.getLong("user_id"));
            item.setProductId(rs.getLong("product_id"));
            item.setQuantity(rs.getInt("quantity"));
            
            // Map joined product data
            Product product = new Product();
            product.setId(rs.getLong("product_id"));
            product.setName(rs.getString("product_name"));
            product.setPrice(rs.getBigDecimal("product_price"));
            product.setImageUrl(rs.getString("image_url"));
            item.setProduct(product);
            
            return item;
        }
    };

    public List<CartItem> findByUserId(Long userId) {
        String sql = "SELECT c.id, c.user_id, c.product_id, c.quantity, p.name as product_name, p.price as product_price, p.image_url " +
                     "FROM cart c JOIN products p ON c.product_id = p.id WHERE c.user_id = ?";
        return jdbcTemplate.query(sql, cartItemRowMapper, userId);
    }

    public int save(CartItem item) {
        // Check if exists
        String checkSql = "SELECT COUNT(*) FROM cart WHERE user_id = ? AND product_id = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, item.getUserId(), item.getProductId());
        
        if (count != null && count > 0) {
            // Update quantity
            String updateSql = "UPDATE cart SET quantity = quantity + ? WHERE user_id = ? AND product_id = ?";
            return jdbcTemplate.update(updateSql, item.getQuantity(), item.getUserId(), item.getProductId());
        } else {
            // Insert
            String insertSql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
            return jdbcTemplate.update(insertSql, item.getUserId(), item.getProductId(), item.getQuantity());
        }
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM cart WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
    
    public int deleteByUserId(Long userId) {
        String sql = "DELETE FROM cart WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId);
    }
}
