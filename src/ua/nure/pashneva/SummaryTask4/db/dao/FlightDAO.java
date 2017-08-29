package ua.nure.pashneva.SummaryTask4.db.dao;

import ua.nure.pashneva.SummaryTask4.db.entity.*;
import ua.nure.pashneva.SummaryTask4.exception.DBException;

import java.util.Date;
import java.util.List;

/**
 * The data manipulation interface in the table flights.
 *
 * @author Anastasia Pashneva
 *
 */
public interface FlightDAO {

    /**
     * Method of creating a flight in the database. <br/>
     * After the method is executed the flight object contains the value of the identifier (id),
     * this information comes from the DBMS side.
     *
     * @param flight object that contains information about a flight without an identifier.
     * @return true - flight was successfully inserted into database, otherwise - false.
     * @throws DBException
     */
    boolean create(Flight flight) throws DBException;

    /**
     * Method of obtaining a flight from the database.
     *
     * @param id flight identifier (primary unique key).
     * @return object which contains values of all fields from table flights.
     * @throws DBException
     */
    Flight read(Integer id) throws DBException;

    /**
     * Method of obtaining a flight from the database.
     *
     * @param departure flight point of departure (city name).
     * @return collection (List) of flights with adjusted point of departure.
     * @throws DBException
     */
    List<Flight> read(String departure) throws DBException;

    /**
     * Method of obtaining a flight from the database.
     *
     * @param date an instance of Date class,
     *                  which contains a value of flight date and time.
     * @return collection (List) of flights with adjusted date and time.
     * @throws DBException
     */
    List<Flight> read(Date date) throws DBException;

    /**
     * Method of obtaining a flight from the database.
     *
     * @param brigade an instance of Brigade class,
     *                  which contains data of flight brigade.
     * @return collection (List) of flights with adjusted brigade.
     * @throws DBException
     */
    List<Flight> read(Brigade brigade) throws DBException;

    /**
     * Method of obtaining a flight from the database.
     *
     * @param brigade an instance of Brigade class,
     *                  which contains data of flight brigade.
     * @param staff   an instance of Staff class,
     *                  which contains data of the staff from adjusted brigade.
     * @return collection (List) of flights with adjusted brigade and stuff.
     * @throws DBException
     */
    List<Flight> read(Brigade brigade, Staff staff) throws DBException;

    /**
     * Method of obtaining a flight from the database.
     *
     * @param flightStatus an instance of FlightStatus enum,
     *                  which contains data of flight status.
     * @return collection (List) of flights with adjusted flight status.
     * @throws DBException
     */
    List<Flight> read(FlightStatus flightStatus) throws DBException;

    /**
     * Method of obtaining all flights from the database.
     *
     * @return collection (List) of all flights.
     * @throws DBException
     */
    List<Flight> readAll() throws DBException;

    /**
     * Method of updating flight data in database. <br/>
     * All fields are updated except the flightStatus and brigade fields.
     *
     * @param flight object that contains flight data.
     *             The identifier must be present.
     * @return true - flight data was successfully updated in database, otherwise - false.
     * @throws DBException
     */
    boolean update(Flight flight) throws DBException;

    /**
     * Method of updating user flight status and brigade in database. <br/>
     * Only flightStatus and brigade fields are updated.
     *
     * @param flightStatus object that contains flight status data.
     *             The identifier must be present.
     * @param brigade object that contains brigade data.
     *             The identifier must be present.
     * @return true - flight status was successfully updated in database, otherwise - false.
     * @throws DBException
     */
    boolean update(FlightStatus flightStatus, Brigade brigade) throws DBException;

    /**
     * Method of deleting flight from database.
     *
     * @param flight object that contains information about a flight which must be deleted.
     * @return true - flight was successfully deleted from database, otherwise - false.
     * @throws DBException
     */
    boolean delete(Flight flight) throws DBException;
}