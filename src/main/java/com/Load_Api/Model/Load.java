package com.Load_Api.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID shipperId;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;
    private String comment;
    private String date;

    @PrePersist
    private void prePersist() {
        this.shipperId = UUID.randomUUID();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Define your desired date/time format
        this.date = sdf.format(new Date(System.currentTimeMillis()));
    }

}
