package ua.nure.pashneva.SummaryTask4.db.dao.mysql;

import ua.nure.pashneva.SummaryTask4.db.DBConnection;
import ua.nure.pashneva.SummaryTask4.db.dao.AircraftDAO;
import ua.nure.pashneva.SummaryTask4.db.dao.DAOFactory;
import ua.nure.pashneva.SummaryTask4.db.entity.Aircraft;
import ua.nure.pashneva.SummaryTask4.db.entity.Post;
import ua.nure.pashneva.SummaryTask4.db.entity.Staff;
import ua.nure.pashneva.SummaryTask4.exception.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class that implements AircraftDAO interface and all its methods.
 * Implementation for MySQL DBMS.
 *
 * @author Anastasia Pashneva
 *
 */
public class MysqlAircraftDAO implements AircraftDAO {

    /**
     * String fields which contain sql queries to table
     * aircraft of MySQL database.
     */
    private static final String GET_AIRCRAFT_BY_ID = "SELECT * FROM aircraft WHERE id=?";

    /**
     * String fields which contain column names of table aircraft.
     */
    private static final String ENTITY_ID = "id";
    private static final String AIRCRAFT_NAME = "type";

    @Override
    public Aircraft read(Integer id) throws DBException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Aircraft aircraft = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            statement = connection.prepareStatement(GET_AIRCRAFT_BY_ID);

            int k = 1;
            statement.setInt(k++, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                aircraft = extractAircraft(resultSet);
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage(), e);
        } finally {
            DBConnection.getInstance().close(connection, statement, resultSet);
        }
        return aircraft;
    }

    private Aircraft extractAircraft(ResultSet resultSet) throws DBException {
        Aircraft aircraft = new Aircraft();
        try {
            aircraft.setId(resultSet.getInt(ENTITY_ID));
            aircraft.setTypeName(resultSet.getString(AIRCRAFT_NAME));
        } catch (Exception e) {
            throw new DBException(e.getMessage(), e);
        }
        return aircraft;
    }
}