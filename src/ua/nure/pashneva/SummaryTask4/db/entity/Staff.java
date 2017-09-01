package ua.nure.pashneva.SummaryTask4.db.entity;

import java.sql.Date;

/**
 * Objects of this class are strings from the table staff.
 *
 * @author Anastasia Pashneva
 *
 */
public class Staff extends Entity{
    private User user;
    private Post post;
    private Date employmentDate;

    public Staff() {
    }

    /**
     * Constructor of class for creating object without without an identifier.
     *
     * @param user
     * @param post
     * @param employmentDate
     */
    public Staff(User user, Post post, Date employmentDate) {
        this.user = user;
        this.post = post;
        this.employmentDate = employmentDate;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        if (!super.equals(o)) return false;

        Staff staff = (Staff) o;

        if (!getUser().equals(staff.getUser())) return false;
        if (getPost() != staff.getPost()) return false;
        return getEmploymentDate().equals(staff.getEmploymentDate());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getPost().hashCode();
        result = 31 * result + getEmploymentDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "user=" + user +
                ", post=" + post +
                ", employmentDate=" + employmentDate +
                ", id=" + id +
                '}';
    }
}
