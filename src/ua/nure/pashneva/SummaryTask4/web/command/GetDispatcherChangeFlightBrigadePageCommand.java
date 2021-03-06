package ua.nure.pashneva.SummaryTask4.web.command;

import org.apache.log4j.Logger;
import ua.nure.pashneva.SummaryTask4.db.dao.DAOFactory;
import ua.nure.pashneva.SummaryTask4.db.entity.Brigade;
import ua.nure.pashneva.SummaryTask4.db.entity.Flight;
import ua.nure.pashneva.SummaryTask4.db.entity.Language;
import ua.nure.pashneva.SummaryTask4.exception.AppException;
import ua.nure.pashneva.SummaryTask4.web.util.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.List;

/**
 * Command for obtaining dispatcherChangeFlightBrigadeView.jsp.
 *
 * @author Anastasia Pashneva
 */
public class GetDispatcherChangeFlightBrigadePageCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetDispatcherChangeFlightBrigadePageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        LOG.debug("Command starts");

        String locale = (String) Config.get(request.getSession(), Config.FMT_LOCALE);
        if (locale == null) {
            locale = request.getLocale().getLanguage();
            LOG.trace("Current locale --> " + locale);
        }

        String flightId = request.getParameter("flight_id");
        LOG.trace("Parameter flight_id --> " + flightId);

        try {
            Language language = DAOFactory.getInstance().getLanguageDAO().readByPrefix(locale);

            Flight flight = new Flight();
            if (flightId != null && !(flightId.isEmpty())) {
                flight = DAOFactory.getInstance().getFlightDAO().read(Integer.parseInt(flightId), language);
            }

            LOG.trace("Attribute flight --> " + flight);
            request.setAttribute("flight", flight);

            List<Brigade> brigades = DAOFactory.getInstance().getBrigadeDAO().getAvailableBrigades(flight.getDate(), language);
            LOG.trace("Attribute brigades --> " + brigades);
            request.setAttribute("brigades", brigades);

            LOG.info("Flight to change brigade --> " + flight);
        } catch (Exception e) {
            throw new AppException(e.getMessage(), e);
        }
        LOG.debug("Command finished");
        request.getRequestDispatcher(Path.PAGE_DISPATCHER_CHANGE_FLIGHT_BRIGADE).forward(request, response);
    }
}
