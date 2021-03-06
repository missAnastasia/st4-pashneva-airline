package ua.nure.pashneva.SummaryTask4.db.entity;

/**
 * Objects of this class are strings from the table aircraft.
 *
 * @author Anastasia Pashneva
 */
public class Aircraft extends Entity {

    private String typeName;

    public Aircraft() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;

        Aircraft aircraft = (Aircraft) o;

        return getTypeName().equals(aircraft.getTypeName());
    }

    @Override
    public int hashCode() {
        return getTypeName().hashCode();
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "typeName='" + typeName + '\'' +
                ", id=" + id +
                '}';
    }
}
