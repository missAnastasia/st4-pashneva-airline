package ua.nure.pashneva.SummaryTask4.web.util;

/**
 * Class which contains paths to jsp pages and commands.
 */
public class Path {

    public static final String HOST = "localhost:8080";

    // pages
    public static final String PAGE_LOGIN = "/loginView.jsp";
    public static final String PAGE_REGISTER_CLIENT = "/registerClientView.jsp";
    public static final String PAGE_STAFF_FLIGHTS = "/WEB-INF/jsp/staff/staffFlightsView.jsp";
    public static final String PAGE_DISPATCHER_BRIGADES = "/WEB-INF/jsp/dispatcher/dispatcherBrigadesView.jsp";
    public static final String PAGE_DISPATCHER_BRIGADE_INFO = "/WEB-INF/jsp/dispatcher/dispatcherBrigadeInfoView.jsp";
    public static final String PAGE_DISPATCHER_REQUESTS = "/WEB-INF/jsp/dispatcher/dispatcherRequestsView.jsp";
    public static final String PAGE_ADMIN_REQUESTS = "/WEB-INF/jsp/admin/adminNewRequestsView.jsp";
    public static final String PAGE_DISPATCHER_FLIGHTS = "/WEB-INF/jsp/dispatcher/dispatcherFlightsView.jsp";
    public static final String PAGE_ADMIN_FLIGHTS = "/WEB-INF/jsp/admin/adminFlightsView.jsp";
    public static final String PAGE_DISPATCHER_FLIGHT_INFO = "/WEB-INF/jsp/dispatcher/dispatcherFlightInfoView.jsp";
    public static final String PAGE_ADMIN_FLIGHT_INFO = "/WEB-INF/jsp/admin/adminFlightInfoView.jsp";
    public static final String PAGE_DISPATCHER_REQUEST_INFO = "/WEB-INF/jsp/dispatcher/dispatcherRequestInfoView.jsp";
    public static final String PAGE_ADMIN_STAFF_INFO = "/WEB-INF/jsp/admin/adminStaffInfoView.jsp";
    public static final String PAGE_ADMIN_REQUEST_INFO = "/WEB-INF/jsp/admin/adminRequestInfoView.jsp";
    public static final String PAGE_ADMIN_STAFF = "/WEB-INF/jsp/admin/adminStaffView.jsp";
    public static final String PAGE_ADMIN_EDIT_STAFF = "/WEB-INF/jsp/admin/adminEditStaffView.jsp";
    public static final String PAGE_ADMIN_ADD_STAFF = "/WEB-INF/jsp/admin/adminAddStaffView.jsp";
    public static final String PAGE_ADMIN_ADD_FLIGHT = "/WEB-INF/jsp/admin/adminAddFlightView.jsp";
    public static final String PAGE_ADMIN_EDIT_FLIGHT = "/WEB-INF/jsp/admin/adminEditFlightView.jsp";
    public static final String PAGE_DISPATCHER_EDIT_REQUEST = "/WEB-INF/jsp/dispatcher/dispatcherEditRequestView.jsp";
    public static final String PAGE_DISPATCHER_ADD_REQUEST = "/WEB-INF/jsp/dispatcher/dispatcherAddRequestView.jsp";
    public static final String PAGE_DISPATCHER_ADD_BRIGADE = "/WEB-INF/jsp/dispatcher/dispatcherAddBrigadeView.jsp";
    public static final String PAGE_STAFF_FLIGHT_INFO = "/WEB-INF/jsp/staff/staffFlightInfoView.jsp";
    public static final String PAGE_EDIT_USER = "/WEB-INF/jsp/admin/editUserView.jsp";
    public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/errorMessageView.jsp";
    public static final String PAGE_SUCCESS_PAGE = "/WEB-INF/jsp/successMessageView.jsp";
    public static final String PAGE_LIST_MENU = "/WEB-INF/jsp/client/list_menu.jsp";
    public static final String PAGE_LIST_ORDERS = "/WEB-INF/jsp/admin/list_orders.jsp";
    public static final String PAGE_ADMIN_USER_ACCOUNTS = "/WEB-INF/jsp/admin/adminStaffView.jsp";
    public static final String PAGE_USER_INFO = "/WEB-INF/jsp/userInfoView.jsp";
    public static final String PAGE_CHANGE_USER_DATA = "/WEB-INF/jsp/changeUserDataView.jsp";
    public static final String PAGE_CHANGE_PASSWORD = "/WEB-INF/jsp/changePasswordView.jsp";
    public static final String PAGE_CHANGE_LOCALE = "/WEB-INF/jsp/changeLocale.jsp";
    public static final String PAGE_HOME = "/homeView.jsp";
    public static final String PAGE_CONTACTS = "/contactsView.jsp";
    public static final String PAGE_ABOUT_US = "/aboutView.jsp";
    public static final String PAGE_SETTINGS = "/settingsView.jsp";
    public static final String PAGE_PRODUCTS = "/WEB-INF/jsp/client/productsView.jsp";

    // commands
    public static final String COMMAND = "/controller?command=";
    public static final String COMMAND_CONFIRM_PASSWORD = "/controller?command=confirmNewPasswordCommand&login=";
    public static final String COMMAND_HOME = "/controller?command=getHomePageCommand";
    public static final String COMMAND_DISPATCHER_FLIGHT_INFO = "/redirect?command=getDispatcherFlightInfoPageCommand";
    public static final String COMMAND_DISPATCHER_REQUEST_INFO = "/controller?command=getDispatcherRequestInfoPageCommand&request_id=";
    public static final String COMMAND_ADMIN_REQUEST_INFO = "/controller?command=getAdminRequestInfoPageCommand&request_id=";
    public static final String COMMAND_ADMIN_FLIGHTS = "/controller?command=getAdminFlightsPageCommand";
    public static final String COMMAND_ADMIN_FLIGHT_INFO = "/controller?command=getAdminFlightInfoPageCommand&flight_id=";
    public static final String COMMAND_LOGIN = "/controller?command=loginCommand";
    public static final String COMMAND_USER_INFO = "/redirect?command=getUserInfoPageCommand";
    public static final String COMMAND_STAFF_FLIGHTS = "/redirect?command=getStaffFlightsPageCommand";
    public static final String COMMAND_DISPATCHER_FLIGHTS = "/redirect?command=getDispatcherFlightsPageCommand";
    public static final String COMMAND_DISPATCHER_REQUESTS = "/controller?command=getDispatcherRequestsPageCommand";
    public static final String COMMAND_ADMIN_STAFF = "/controller?command=getAdminStaffPageCommand";
    public static final String COMMAND_ADMIN_STAFF_INFO = "/controller?command=getAdminStaffInfoPageCommand&staff_id=";
    public static final String COMMAND_DISPATCHER_ADD_REQUEST = "/controller?command=getDispatcherAddRequestPageCommand";
    public static final String COMMAND_DISPATCHER_BRIGADES = "/redirect?command=getDispatcherBrigadesPageCommand";
    public static final String COMMAND_PRODUCTS = "/controller?command=getProductsPageCommand";
    public static final String COMMAND_ADMIN_USER_ACCOUNTS = "/redirect?command=getUserAccountsPageCommand";
    /*public static final String COMMAND_HOME = "controller?command=getHomePageCommand";*/

    public static final String COMMAND_MESSAGE_SUCCESS = "/controller?command=getSuccessMessagePageCommand&message=";
    public static final String COMMAND_MESSAGE_ERROR = "/controller?command=getErrorMessagePageCommand&message=";

    private Path() {
    }
    /*public static final String COMMAND_LIST_ORDERS = "/controller?command=listOrders";
    public static final String COMMAND_LIST_MENU = "/controller?command=listMenu";*/
}
