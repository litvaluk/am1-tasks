package cz.fit.litvaluk.am1.asyncdeleteservice.entity;

import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

public class TourDeleteRequest extends RepresentationModel<TourDeleteRequest> {

    private int id;
    private String status;
    private Date issuedAt;
    private int tourId;

    public TourDeleteRequest(int id, String status, Date issuedAt, int tourId) {
        this.id = id;
        this.status = status;
        this.issuedAt = issuedAt;
        this.tourId = tourId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTour(int tourId) {
        this.tourId = tourId;
    }

}
