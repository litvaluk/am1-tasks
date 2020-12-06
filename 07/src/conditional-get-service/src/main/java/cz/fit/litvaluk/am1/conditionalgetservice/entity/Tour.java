package cz.fit.litvaluk.am1.conditionalgetservice.entity;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;

public class Tour extends RepresentationModel<Tour> {

    private int id;
    private String name;
    private List<String> customers;

    public Tour(int id, String name, List<String> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tour tour = (Tour) o;
        return id == tour.id &&
                name.equals(tour.name) &&
                customers.equals(tour.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, customers);
    }
}
