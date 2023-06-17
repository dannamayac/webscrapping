package services;

import connections.MySqlDB;
import entity.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductService
{

    private String sqlQueryUpdateAssociateData = "INSERT INTO products (name, code, price, link) VALUES (?, ?, ?, ?)";

    private MySqlDB connectionDataBase;

    public ProductService()
    {
        this.connectionDataBase = new MySqlDB();
    }

    public int save(Product product) throws SQLException, ClassNotFoundException
    {
        PreparedStatement preparedStatement = this.connectionDataBase.openConnection().prepareStatement(this.sqlQueryUpdateAssociateData);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getCode());
        preparedStatement.setString(3, product.getPrice());
        preparedStatement.setString(4, product.getLink());
        int result = preparedStatement.executeUpdate();

        this.connectionDataBase.closeConnection();

        return result;
    }

}
