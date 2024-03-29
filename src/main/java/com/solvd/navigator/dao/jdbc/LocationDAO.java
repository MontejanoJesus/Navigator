package com.solvd.navigator.dao.jdbc;

import com.solvd.navigator.connection.ConnectionPool;
import com.solvd.navigator.dao.ILocationDAO;
import com.solvd.navigator.model.Coordinate;
import com.solvd.navigator.model.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.navigator.model.Location;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements ILocationDAO {
    private static final Logger logger = LogManager.getLogger("LocationDAO");
    private static final String SELECT_ALL = "SELECT * FROM Locations";
    private static final String READ_POINT = "SELECT ST_X(t.coordinates) as x_coordinate, ST_Y(t.coordinates) as y_coordinate, t.* FROM Locations t WHERE id=?";
    private static final String SELECT_BY_ID = "SELECT * FROM Locations WHERE id = ?";
    private static final String INSERT = "INSERT INTO Locations ( id, name, coordinates) VALUES (?,?,POINT(?,?))";
    private static final String UPDATE = "UPDATE Locations SET name=?, coordinates=POINT(?,?) WHERE id=?";
    private static final String DELETE = "DELETE FROM Locations WHERE id = ?";

    @Override
    public Location getById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Location location=null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            location = fillLocationByResultSet(resultSet);

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
        return location;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                locations.add(fillLocationByResultSet(resultSet));
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
        return locations;
    }

    @Override
    public void insert(Location location) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setLong(1,location.getId());
            statement.setString(2, location.getName());
            statement.setDouble(3,location.getCoordinate().getLatitude());
            statement.setDouble(4,location.getCoordinate().getLongitude());
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
    public void update(Location location){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, location.getName());
            statement.setLong(2,location.getId());
            statement.setDouble(3,location.getCoordinate().getLatitude());
            statement.setDouble(4,location.getCoordinate().getLongitude());
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

    private Location fillLocationByResultSet(ResultSet resultSet) {
        Location location= null;
        try {
            location= new Location();
            location.setId(resultSet.getLong(1));
            location.setName(resultSet.getString(2));

            //location.setCoordinate(readPoint(location.getId()));
            try{ location.setCoordinate(readPoint(location.getId()));}
            catch (Exception e){
                location.setCoordinate(null);
            }

        } catch (SQLException e) {
            logger.error("SQL Exception"+e.getErrorCode());
        }
        return location;
    }

    private Coordinate readPoint(Long id){
        Connection connection = null;
        PreparedStatement statement = null;
        Coordinate coordinate = null;
        Double coorX=null;
        Double coorY = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(READ_POINT);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            coorX = resultSet.getDouble(1);
            coorY = resultSet.getDouble(2);

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
        coordinate.setLatitude(coorX);
        coordinate.setLongitude(coorY);
        return coordinate;
    }
}
