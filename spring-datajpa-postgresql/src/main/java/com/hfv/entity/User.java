package com.hfv.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name = "seq_users",  allocationSize = 1)
    @GeneratedValue(generator = "seq_users", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<Address> addressList;

}
