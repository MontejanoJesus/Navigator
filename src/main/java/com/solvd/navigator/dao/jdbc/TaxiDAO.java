package com.solvd.navigator.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaxiDAO  {
    private static final Logger logger = LogManager.getLogger("TaxiDAO");
    private static final String SELECT_ALL = "SELECT * FROM Taxis";
    private static final String SELECT_BY_ID = "SELECT * FROM Taxis WHERE id = ?";
    private static final String INSERT = "INSERT INTO Taxis (taxi_number, cost, driver_id) VALUES (?,?, ?)";
    private static final String UPDATE = "UPDATE Taxis SET taxi_number=?, cost=?, driver_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Taxis WHERE id = ?";
/*
    @Override
    public Taxi getById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Taxi taxi= null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            taxi = fillTaxiByResultSet(resultSet);

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
        return taxi;
    }



    @Override
    public List<Taxi> getAll() {
        List<Taxi> taxis = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                taxis.add(fillTaxiByResultSet(resultSet));
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
        return taxis;
    }

    @Override
    public void insert(Taxi taxi) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, taxi.getNumber());
            statement.setInt(2, taxi.getCost());
            statement.setLong(3, taxi.getDriver().getId());
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
    public void update(Taxi taxi) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, taxi.getNumber());
            statement.setInt(2, taxi.getCost());
            statement.setLong(3,taxi.getDriver().getId());
            statement.setLong(4,taxi.getId());
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
    private Taxi fillTaxiByResultSet(ResultSet resultSet) {
        Taxi taxi= null;
        try {
            taxi= new Taxi();
            taxi.setId(resultSet.getLong(1));
            taxi.setNumber(resultSet.getInt(2));
            taxi.setCost(resultSet.getInt(3));
            taxi.getDriver.setId(resultSet.getLong(4));

        } catch (SQLException e) {
            logger.error("SQL Exception"+e.getErrorCode());
        }
        return taxi;
    } */
}
