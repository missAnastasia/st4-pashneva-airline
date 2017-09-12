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

public class GetAdminEditStaffPageCommand extends Command {

    private static final Logger LOG = Logger.getLogger(GetAdminEditStaffPageCommand.class);

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
            String staffId = request.getParameter("staff_id");
            LOG.trace("staffId --> " + staffId);
            Staff staff = new Staff();
            if (staffId != null && !(staffId.isEmpty())) {
                staff = DAOFactory.getInstance().getStaffDAO().read(Integer.parseInt(staffId), language);
            }
            LOG.trace("Staff --> " + staff);
            request.setAttribute("staff_item", staff);
            List<Post> posts = DAOFactory.getInstance().getPostDAO().readAll(language);
            LOG.trace("Posts --> " + posts);
            request.setAttribute("posts", posts);
        } catch (Exception e) {
            throw new AppException(e.getMessage(), e);
        }
        LOG.debug("Command finished");
        request.getRequestDispatcher(Path.PAGE_ADMIN_EDIT_STAFF).forward(request, response);
    }
}