package com.hfv.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "adresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_addresses",  allocationSize = 1)
    @GeneratedValue(generator = "seq_addresses", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 500, name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;

    enum AddressType{
        HOME,
        WORK,
        OTHER
    }
}
