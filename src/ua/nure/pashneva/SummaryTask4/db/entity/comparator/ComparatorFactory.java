package ua.nure.pashneva.SummaryTask4.db.entity.comparator;

import ua.nure.pashneva.SummaryTask4.db.entity.Flight;
import ua.nure.pashneva.SummaryTask4.db.entity.RequestToAdmin;

import java.util.Comparator;

public class ComparatorFactory {

    /**
     * A private class field that stores the ComparatorFactory object.
     */
    private static ComparatorFactory instance;

    /**
     * Constructor for the ability to extend this class.
     */
    protected ComparatorFactory() {
    }

    /**
     * Method for obtaining the ComparatorFactory object.
     *
     * @return an instance of the ComparatorFactory.
     * @throws Exception
     */
    public static synchronized ComparatorFactory getInstance() throws Exception {
        if (instance == null) {
            instance = new ComparatorFactory();
        }
        return instance;
    }

    public Comparator<Flight> getFlightComparator(String parameter) {
        switch (parameter) {
            case "compare_by_number" : {
                return new FlightNumberComparator();
            }
            case "compare_by_departure_point" : {
                return new FlightDeparturePointComparator();
            }
            case "compare_by_arrival_point" : {
                return new FlightArrivalPointComparator();
            }
            case "compare_by_departure_date" : {
                return new FlightDateComparator();
            }
            default : {
                return null;
            }
        }
    }

    public Comparator<RequestToAdmin> getRequestToAdminComparator(String parameter) {
        switch (parameter) {
            case "compare_by_creation_date" : {
                return new RequestToAdminDateComparator();
            }
            default : {
                return null;
            }
        }
    }
}
