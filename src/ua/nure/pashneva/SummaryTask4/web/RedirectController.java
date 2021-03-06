package ua.nure.pashneva.SummaryTask4.web;

import org.apache.log4j.Logger;
import ua.nure.pashneva.SummaryTask4.web.command.Command;
import ua.nure.pashneva.SummaryTask4.web.command.CommandContainer;
import ua.nure.pashneva.SummaryTask4.web.util.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet controller for executing redirect to command.
 *
 * @author Anastasia Pashneva
 *
 */
public class RedirectController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(RedirectController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Main method of this controller.
     */
    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Controller starts");

        String commandName = request.getParameter("command");
        LOG.trace("Parameter command --> " + commandName);

        Command command = CommandContainer.get(commandName);
        LOG.trace("Obtained command --> " + command);

        StringBuilder path = new StringBuilder(Path.COMMAND + commandName);

        String compare = request.getParameter("compare");
        if (compare != null && !(compare.isEmpty())) {
            path.append("&compare=").append(compare);
        }

        String fromCity = request.getParameter("from_city");
        if (fromCity != null && (!fromCity.isEmpty())) {
            path.append("&from_city=").append(fromCity);
        }

        String toCity = request.getParameter("to_city");
        if (toCity != null && (!toCity.isEmpty())) {
            path.append("&to_city=").append(toCity);
        }

        String date = request.getParameter("departure_date");
        if (date != null && (!date.isEmpty())) {
            path.append("&departure_date=").append(date);
        }

        String flightId = request.getParameter("flight_id");
        if (flightId != null && (!flightId.isEmpty())) {
            path.append("&flight_id=").append(flightId);
        }

        String flightStatusId = request.getParameter("flight_status_id");
        if (flightStatusId != null && (!flightStatusId.isEmpty())) {
            path.append("&flight_status_id=").append(flightStatusId);
        }

        String brigadeId = request.getParameter("brigade_id");
        if (brigadeId != null && (!brigadeId.isEmpty())) {
            path.append("&brigade_id=").append(brigadeId);
        }

        String requestNumber = request.getParameter("request_number");
        if (requestNumber != null && (!requestNumber.isEmpty())) {
            path.append("&request_number=").append(requestNumber);
        }

        String requestId = request.getParameter("request_id");
        if (requestId != null && (!requestId.isEmpty())) {
            path.append("&request_id=").append(requestId);
        }

        String staffId = request.getParameter("staff_id");
        if (staffId != null && (!staffId.isEmpty())) {
            path.append("&staff_id=").append(staffId);
        }

        String postId = request.getParameter("post_id");
        if (postId != null && (!postId.isEmpty())) {
            path.append("&post_id=").append(postId);
        }

        LOG.trace("Path --> " + path);
        LOG.debug("Controller finished");
        response.sendRedirect(path.toString());
    }
}