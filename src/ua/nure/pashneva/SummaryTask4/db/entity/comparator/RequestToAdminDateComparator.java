package ua.nure.pashneva.SummaryTask4.db.entity.comparator;

import ua.nure.pashneva.SummaryTask4.db.entity.RequestToAdmin;

import java.util.Comparator;

public class RequestToAdminDateComparator implements Comparator<RequestToAdmin> {
    @Override
    public int compare(RequestToAdmin requestToAdmin1, RequestToAdmin requestToAdmin2) {
        return requestToAdmin1.getDate().compareTo(requestToAdmin2.getDate());
    }
}
