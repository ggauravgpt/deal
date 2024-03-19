package com.example.demo.dbo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dealDetails", schema = "pharmacy_search")

public class Deal  implements Serializable {
    @Id
    @Column(name = "deal_id", nullable = false)
    private Long dealId;

    private List<String> sku;
    private String userID;
    private boolean expire;
    private String price;
    private Date DateTime;
    private Integer qty;



}

