package cz.fit.litvaluk.am1.asyncdeleteservice.entity;

import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

public class Tour extends RepresentationModel<Tour> {

    private int id;
    private Date date;
    private String location;
    private List<String> customers;

    public Tour(int id, Date date, String location, List<String> customers) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

}
