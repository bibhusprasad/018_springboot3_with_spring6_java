package com.bibhu.springboot.restfulwebservice01.user.filtering;

import com.bibhu.springboot.restfulwebservice01.user.model.StaticFilterBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/static-filtering")
    public StaticFilterBean staticFiltering() {
        return new StaticFilterBean("value1", "value2", "value3");
    }

    @GetMapping("/static-filtering-list")
    public List<StaticFilterBean> staticFilteringList() {
        return Arrays.asList(new StaticFilterBean("value1", "value2", "value3"),
                new StaticFilterBean("value11", "value22", "value33"));
    }
}
