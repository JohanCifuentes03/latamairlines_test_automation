package co.com.sofka.models;

public class FlightDetails {
    private String from;
    private String to;
    private int daysAhead;
    private int nAdults;
    private int nChildren;

    public FlightDetails() {
    }

    public FlightDetails(String from, String to, int daysAhead, int nAdults, int nChildren) {
        this.from = from;
        this.to = to;
        this.daysAhead = daysAhead;
        this.nAdults = nAdults;
        this.nChildren = nChildren;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDaysAhead() {
        return daysAhead;
    }

    public void setDaysAhead(int daysAhead) {
        this.daysAhead = daysAhead;
    }

    public int getnAdults() {
        return nAdults;
    }

    public void setnAdults(int nAdults) {
        this.nAdults = nAdults;
    }

    public int getnChildren() {
        return nChildren;
    }

    public void setnChildren(int nChildren) {
        this.nChildren = nChildren;
    }

    @Override
    public String toString() {
        return "FlightDetails{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", daysAhead=" + daysAhead +
                ", nAdults=" + nAdults +
                ", nChildren=" + nChildren +
                '}';
    }
}
