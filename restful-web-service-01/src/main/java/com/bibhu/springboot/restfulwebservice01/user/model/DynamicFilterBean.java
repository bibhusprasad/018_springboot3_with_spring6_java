package com.bibhu.springboot.restfulwebservice01.user.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonFilter("DynamicFilterBean")
public class DynamicFilterBean {

    private String filed1;
    private String filed2;
    private String filed3;
}
