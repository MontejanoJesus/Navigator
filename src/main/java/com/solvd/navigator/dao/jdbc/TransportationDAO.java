package com.solvd.navigator.dao.jdbc;

import com.solvd.navigator.connection.ConnectionPool;
import com.solvd.navigator.dao.ITransportationDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportationDAO implements ITransportationDAO {

    private static final Logger logger = LogManager.getLogger("TransportationDAO");
    private static final String SELECT_ALL = "SELECT * FROM Transportation";
    private static final String SELECT_BY_ID = "SELECT * FROM Transportation WHERE id = ?";
    private static final String INSERT = "INSERT INTO Transportation (id, name, driver_id) VALUES (?,?, ?)";
    private static final String UPDATE = "UPDATE Locations SET name=?, driver_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Transportation WHERE id = ?";

    @Override
    public Transportation getById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Transportation transportation;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            resultSet = statement.executeQuery();
            transportation = fillTransportationByResultSet(resultSet);

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
        return transportation;
    }

    @Override
    public List<Transportation> getAll() {
        List<Transportation> transportation = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                transportation.add(fillTransportationByResultSet(resultSet));
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
        return transportation;
    }

    @Override
    public void insert(Transportation transportation) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setLong(1,transportation.getId());
            statement.setString(2, transportation.getName());
            statement.setLong(3,transportation.getDriver().getId());
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

    public void update(Transportation transportation){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, transportation.getName());
            statement.setLong(2, transportation.getDriver().getId());
            statement.setLong(3,transportation.getId());
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
    public void update(long id) {

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
    private Transportation fillTransportationByResultSet(ResultSet resultSet) {
        Transportation transportation= null;
        try {
            transportation= new Transportation();
            transportation.setId(resultSet.getLong(1));
            transportation.setName(resultSet.getString(2));
        } catch (SQLException e) {
            logger.error("SQL Exception"+e.getErrorCode());
        }
        return transportation;
    }
}
