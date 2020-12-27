package com.order.springorder.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tokenBlackList")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long blackid;

    @Column(name = "blackToken")
    private String blackToken;

    @Column(name = "expiredDate")
    private Timestamp expiredDate;
}
