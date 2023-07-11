package com.solvd.navigator.dao.jdbc;

import com.solvd.navigator.dao.IDriverDAO;

import java.util.List;
public class DriverDAO{}
//Tae
/*
public class DriverDAO implements IDriverDAO {
    @Override
    public Driver getById(long id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public void insert(Driver driver) {

    }

    @Override
    public void update(Driver driver) {

    }

    @Override
    public void delete(long id) {

    }
    /*
    @Override
    public Driver getById(long id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public void insert(Driver driver) {

    }

    @Override
    public void update(Driver driver) {

    }

    @Override
    public void delete(long id) {

    }
    /*
    @Override
    public Driver getById(long id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public void insert(Driver driver) {

    }

    @Override
    public void update(Driver driver) {

    }

    @Override
    public void delete(long id) {

    }
   /* private static final Logger logger = LogManager.getLogger("DriverDAO");
    private static final String SELECT_ALL = "SELECT * FROM Drivers";
    private static final String SELECT_BY_ID = "SELECT * FROM Drivers WHERE id = ?";
    private static final String INSERT = "INSERT INTO Drivers (id, name) VALUES (?,?)";
    private static final String UPDATE = "UPDATE Drivers SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Drivers WHERE id = ?";
    @Override
    public Driver getById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Driver driver= null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            driver = fillDriverByResultSet(resultSet);

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
        return driver;
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                drivers.add(fillDriverByResultSet(resultSet));
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
        return drivers;
    }

    @Override
    public void insert(Driver driver) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setLong(1,driver.getId());
            statement.setString(2, driver.getName());
            statement.executeUpdate();
            logger.info("Record created");

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
    public void update(Driver driver) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, driver.getName());
            statement.setLong(2,driver.getId());
            statement.executeUpdate();
            logger.info("Record created");

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

    private Driver fillDriverByResultSet(ResultSet resultSet) {
        Driver driver= null;
        try {
            driver= new Driver();
            driver.setId(resultSet.getLong(1));
            driver.setName(resultSet.getString(2));
        } catch (SQLException e) {
            logger.error("SQL Exception"+e.getErrorCode());
        }
        return driver;
    }

}*/
