package com.hfv.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class UserDto {

    private long id;

    private String name;

    private String surname;

    private List<String> addressList;
}
