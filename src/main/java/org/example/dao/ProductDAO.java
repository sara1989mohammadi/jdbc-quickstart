package org.example.dao;

import org.example.models.Product;
import org.example.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO extends DataAccessObject<Product> {


    public ProductDAO(Connection connection){
        super(connection);
    }

    public static final String GET_ONE = "SELECT * FROM products WHERE product_id = ?";
    @Override
    public Product findById(long id) {
        Product product = new Product();
        try (PreparedStatement statement = this.connection.prepareStatement(GET_ONE)){
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                product.setProduct_id(resultSet.getLong("product_id"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setUnit(resultSet.getString("unit"));
                product.setCategory_id(resultSet.getLong("category_id"));
                product.setPrice(resultSet.getLong("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product create(Product dto) {
        return null;
    }

    @Override
    public Product update(Product dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
