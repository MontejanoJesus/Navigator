package com.solvd.navigator.dao.jdbc;

import com.solvd.navigator.connection.ConnectionPool;
import com.solvd.navigator.dao.IReviewDAO;
import com.solvd.navigator.model.Review;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements IReviewDAO {
    private static final Logger logger = LogManager.getLogger("ReviewDAO");
    private static final String SELECT_ALL = "SELECT * FROM Reviews";
    private static final String SELECT_BY_ID = "SELECT * FROM Reviews WHERE id = ?";
    private static final String INSERT = "INSERT INTO Reviews ( id, content, location_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE Reviews SET content=?, location_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM Reviews WHERE id = ?";

    @Override
    public Review getById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Review review= null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            review = fillReviewByResultSet(resultSet);

        } catch (SQLException | InterruptedException | IOException e)  {
            logger.error("Error query: "+ SELECT_BY_ID+ " cause: "+e.getCause());
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                logger.error("Error closing statement. Error code: "+e.getErrorCode());
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return review;
    }



    @Override
    public List<Review> getAll() {
        List<Review> reviews = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                reviews.add(fillReviewByResultSet(resultSet));
            }

        } catch (SQLException | InterruptedException | IOException e) {
            logger.error("Error executing query: "+SELECT_ALL+ "error cause: "+ e.getCause());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Error closing statement. Error code: "+e.getErrorCode());
            }

            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return reviews;
    }

    @Override
    public void insert(Review review) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setString(2, review.getContent());
            statement.setLong(3, review.getLocation().getId());
            statement.setLong(1, review.getId());
            statement.executeUpdate();
            logger.info("Record created");
            statement.close();
        } catch (SQLException | InterruptedException | IOException e)  {
            logger.error("Error query: "+ INSERT+ " error cause: "+e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("Error closing statement. Error code: "+e.getErrorCode());
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void update(Review review) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //"UPDATE Reviews SET content=?, location_id=?  WHERE id=?";
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, review.getContent());
             statement.setLong(2, review.getLocation().getId());
            statement.setLong(3,review.getId());

            statement.executeUpdate();
            logger.info("Record created");
            statement.close();
        } catch (SQLException | InterruptedException | IOException e)  {
            logger.error("Error query: "+ UPDATE+ " error cause: "+e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("Error closing statement. Error code: "+e.getErrorCode());
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void delete(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            logger.info("Record deleted");

        } catch (SQLException | InterruptedException | IOException e) {
            logger.error("Error query: "+ DELETE+ " error cause: "+e.getCause());
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Error closing statement. Error code: "+e.getErrorCode());
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
    private Review fillReviewByResultSet(ResultSet resultSet) {
        Review review= null;
        try {
            review= new Review();
            review.setId(resultSet.getLong(1));
            review.setContent(resultSet.getString(2));
        } catch (SQLException e) {
            logger.error("SQL Exception"+e.getErrorCode());
        }
        return review;
    }
}
