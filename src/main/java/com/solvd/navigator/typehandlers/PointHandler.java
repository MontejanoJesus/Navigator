package com.solvd.navigator.typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import com.solvd.navigator.model.Coordinate;

import java.sql.*;

public class PointHandler extends BaseTypeHandler<Coordinate> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Coordinate parameter, JdbcType jdbcType)
			throws SQLException {
		// Set the Coordinate parameter on the PreparedStatement
		ps.setString(i, String.format("POINT(%s %s)", parameter.getLatitude(), parameter.getLongitude()));
	}

	@Override
	public Coordinate getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// Retrieve the Coordinate value from the ResultSet
		//System.out.println(rs.getString(columnName));
		//return parsePoint(rs.getString(columnName));

		// Retrieve the POINT value as a Blob from the ResultSet
		Blob pointBlob = rs.getBlob(columnName);
		// Convert the Blob to a byte array
		byte[] blobBytes = pointBlob.getBytes(1, (int) pointBlob.length());

		// Convert the byte array to a WKT string
		String wkt = new String(blobBytes);

		return parsePoint(wkt);
	}

	@Override
	public Coordinate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// Retrieve the Coordinate value from the ResultSet
		return parsePoint(rs.getString(columnIndex));
	}

	@Override
	public Coordinate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// Retrieve the Coordinate value from the CallableStatement
		return parsePoint(cs.getString(columnIndex));
	}

	private Coordinate parsePoint(String value) {
		// Implement the logic to parse the Coordinate value from the MySQL format
		// and construct a Coordinate object
		// Example: "POINT(12.34 56.78)" -> new Coordinate(12.34, 56.78)
		if (value != null) {
			String[] coordinates = value.replace("POINT(", "").replace(")", "").split(" ");
			if (coordinates.length == 2) {
				double latitude = Double.parseDouble(coordinates[0]);
				double longitude = Double.parseDouble(coordinates[1]);
				return new Coordinate(latitude, longitude);
			}
		}
		return null;
	}
}