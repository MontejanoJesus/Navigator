package com.solvd.navigator.dao.jdbc;

import com.solvd.navigator.connection.ConnectionPool;
import com.solvd.navigator.dao.IDAO;
import com.solvd.navigator.model.DriverLicense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverLicenseDAO implements IDAO<DriverLicense> {
    private static final Logger logger = LogManager.getLogger("DriverLicenseDAO");
    private static final String SELECT_ALL = "SELECT * FROM Driver_License";
    private static final String SELECT_BY_ID = "SELECT * FROM Driver_License WHERE id = ?";
    private static final String INSERT = "INSERT INTO Driver_License ( id ,number) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE Driver_License SET number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Driver_License WHERE id = ?";
    @Override
    public DriverLicense getById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        DriverLicense driverLicense= null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            driverLicense = fillDriverLicenseByResultSet(resultSet);

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
        return driverLicense;
    }



    @Override
    public List<DriverLicense> getAll() {
        List<DriverLicense> driverLicenses = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                driverLicenses.add(fillDriverLicenseByResultSet(resultSet));
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
        return driverLicenses;
    }

    @Override
    public void insert(DriverLicense driverLicense) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT);

            statement.setLong(1, driverLicense.getId());
            statement.setString(2,driverLicense.getNumber());

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
    public void update(DriverLicense driverLicense) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);

            statement.setString(1, driverLicense.getNumber());
            statement.setLong(2,driverLicense.getId());
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
    private DriverLicense fillDriverLicenseByResultSet(ResultSet resultSet) {
        DriverLicense driverLicense= null;
        try {
            driverLicense= new DriverLicense();
            driverLicense.setId(resultSet.getLong(1));

            driverLicense.setNumber(resultSet.getString(2));
        } catch (SQLException e) {
            logger.error("SQL Exception"+e.getErrorCode());
        }
        return driverLicense;
    }
}
