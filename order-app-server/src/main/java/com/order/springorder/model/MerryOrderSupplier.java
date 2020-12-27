package com.order.springorder.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "MerryOrder_Supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MerryOrderSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long suppId;

    @Column(name = "suppName")
    private String suppName;

    @Column(name = "tel")
    private String tel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "address")
    private String address;

    @Column(name = "org")
    private String org;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "createDate", columnDefinition = "datetime")
    private Timestamp createDate;

    @Column(name = "createPerson")
    private String createPerson;

    @Column(name = "updateDate", columnDefinition = "datetime")
    private Timestamp updateDate;

    @Column(name = "updatePerson")
    private String updatePerson;

}
