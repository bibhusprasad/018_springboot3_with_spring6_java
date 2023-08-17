package com.bibhu.springboot.restfulwebservice01.filtering.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@JsonIgnoreProperties("filed1")
public class StaticFilterBean {

    private String filed1;
    @JsonIgnore
    private String filed2;
    private String filed3;
}
