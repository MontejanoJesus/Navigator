package com.solvd.navigator.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaneDAO {
    private static final Logger logger = LogManager.getLogger("PlaneDAO");
    private static final String SELECT_ALL = "SELECT * FROM Planes";
    private static final String SELECT_BY_ID = "SELECT * FROM Planes WHERE id = ?";
    private static final String INSERT = "INSERT INTO Planes (plane_number, cost, driver_id) VALUES (?,?, ?)";
    private static final String UPDATE = "UPDATE Planes SET plane_number=?, cost=? , driver_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Planes WHERE id = ?";
/*
    @Override
    public Plane getById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Plane plane= null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            plane = fillPlaneByResultSet(resultSet);

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
        return plane;
    }



    @Override
    public List<Plane> getAll() {
        List<Plane> planes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                planes.add(fillPlaneByResultSet(resultSet));
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
        return planes;
    }

    @Override
    public void insert(Plane plane) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, plane.getNumber());
            statement.setInt(2, plane.getCost());
            statement.setLong(3,plane.getDriver().getId());
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
    public void update(Plane plane) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, plane.getNumber());
            statement.setInt(2, plane.getCost());
            statement.setLong(3,plane.getDriver().getId());
            statement.setLong(4,plane.getId());
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
    private Plane fillPlaneByResultSet(ResultSet resultSet) {
        Plane plane= null;
        try {
            plane= new Plane();
            plane.setId(resultSet.getLong(1));
            plane.setNumber(resultSet.getInt(2));
            plane.setCost(resultSet.getInt(3));
        } catch (SQLException e) {
            logger.error("SQL Exception"+e.getErrorCode());
        }
        return plane;
    }*/
}
