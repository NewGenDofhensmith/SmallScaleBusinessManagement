package com.retail.retailManagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Vendors")
@Getter
@Setter
public class Vendors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VendorId")
    private int VendorId;

    @Column(name="VenderName")
    private String VenderName;

    @Column(name="Email")
    private String email;

    @Column(name="GST")
    double GST;

    @Column(name="AcStatus")
    boolean AcStatus;

}
