package com.hfv;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet Class", description = "Pet Class has id name and date")
public class Pet {


    @ApiModelProperty(value = "Pet Object Id")
    private int id;
    @ApiModelProperty(value = "Pet Object Name")
    private String name;
    @ApiModelProperty(value = "Pet Object Date")
    private Date date;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
