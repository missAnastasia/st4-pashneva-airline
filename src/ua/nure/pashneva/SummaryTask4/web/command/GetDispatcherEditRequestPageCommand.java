package ua.nure.pashneva.SummaryTask4.web.command;

import org.apache.log4j.Logger;
import ua.nure.pashneva.SummaryTask4.db.dao.DAOFactory;
import ua.nure.pashneva.SummaryTask4.db.entity.*;
import ua.nure.pashneva.SummaryTask4.exception.AppException;
import ua.nure.pashneva.SummaryTask4.web.util.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class GetDispatcherEditRequestPageCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetDispatcherRequestInfoPageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        LOG.debug("Command starts");
        try {
            String locale = (String) Config.get(request.getSession(), Config.FMT_LOCALE);
            if (locale == null) {
                locale = request.getLocale().getLanguage();
                LOG.trace("Current locale --> " + locale);
            }
            Language language = DAOFactory.getInstance().getLanguageDAO().readByPrefix(locale);
            LOG.trace("Language --> " + language);
            String requestId = request.getParameter("request_id");
            LOG.trace("requestId --> " + requestId);
            RequestToAdmin requestToAdmin = new RequestToAdmin();
            if (requestId != null && !(requestId.isEmpty())) {
                requestToAdmin = DAOFactory.getInstance().getRequestToAdminDAO().read(Integer.parseInt(requestId), language);
            }
            LOG.trace("RequestToAdmin --> " + requestToAdmin);
            request.setAttribute("request_item", requestToAdmin);
        } catch (Exception e) {
            throw new AppException(e.getMessage(), e);
        }
        LOG.trace("Command finished");
        request.getRequestDispatcher(Path.PAGE_DISPATCHER_EDIT_REQUEST).forward(request, response);
    }
}