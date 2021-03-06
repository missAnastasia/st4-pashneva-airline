package ua.nure.pashneva.SummaryTask4.db.dao;

import ua.nure.pashneva.SummaryTask4.db.entity.Brigade;
import ua.nure.pashneva.SummaryTask4.db.entity.Language;
import ua.nure.pashneva.SummaryTask4.db.entity.Staff;

import java.sql.Date;
import java.util.List;

/**
 * The data manipulation interface in the table brigades.
 *
 * @author Anastasia Pashneva
 */
public interface BrigadeDAO {

    /**
     * Method of creating a brigade in the database. <br/>
     * After the method is executed the brigade object contains the value of the identifier (id),
     * this information comes from the DBMS side.
     *
     * @param brigade object that contains information about a brigade without an identifier.
     * @return true - brigade was successfully inserted into database, otherwise - false.
     * @throws Exception
     */
    boolean create(Brigade brigade) throws Exception;

    /**
     * Method of obtaining a brigade from the database.
     *
     * @param id brigade identifier (primary unique key).
     * @param language object of Language class which contains data about current locale.
     * @return object which contains values of all fields from table brigades.
     * @throws Exception
     */
    Brigade read(int id, Language language) throws Exception;

    /**
     * Method of obtaining a brigade from the database.
     *
     * @param staff an instance of Staff class,
     *                  which contains data of the stuff.
     * @param language object of Language class which contains data about current locale.
     * @return object which contains values of all fields from table brigades.
     * @throws Exception
     */
    Brigade readByStaff(Staff staff, Language language) throws Exception;

    /**
     * Method of obtaining a brigades from the database
     * which are not set on flight with such date.
     *
     * @param flightDate object of java.sql.Date class,
     *                  which contains date of the flight.
     * @param language object of Language class which contains data about current locale.
     * @return collection (List) of all brigades.
     * @throws Exception
     */
    List<Brigade> getAvailableBrigades(Date flightDate, Language language) throws Exception;

    /**
     * Method of obtaining all brigades from the database.
     *
     * @param language object of Language class which contains data about current locale.
     * @return collection (List) of all brigades.
     * @throws Exception
     */
    List<Brigade> readAll(Language language) throws Exception;

    /**
     * Method of updating brigade data in database. <br/>
     * All fields are updated.
     *
     * @param brigade object that contains brigade data.
     *             The identifier must be present.
     * @return true - brigade data was successfully updated in database, otherwise - false.
     * @throws Exception
     */
    boolean update(Brigade brigade) throws Exception;

    /**
     * Method of deleting brigade from database.
     *
     * @param id brigade identifier (primary unique key).
     * @return true - brigade was successfully deleted from database, otherwise - false.
     * @throws Exception
     */
    boolean delete(int id) throws Exception;
}
