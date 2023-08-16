package com.bibhu.springboot.restfulwebservice01.user.filtering;

import com.bibhu.springboot.restfulwebservice01.user.model.DynamicFilterBean;
import com.bibhu.springboot.restfulwebservice01.user.model.StaticFilterBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue dynamicFiltering() {
        DynamicFilterBean dynamicFilterBean = new DynamicFilterBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilterBean);
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("filed1", "filed3");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("DynamicFilterBean", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue dynamicFilteringList() {
        List<DynamicFilterBean> dynamicFilterBeanList =
                Arrays.asList(new DynamicFilterBean("value1", "value2", "value3"), new DynamicFilterBean("value11", "value22", "value33"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilterBeanList);
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("filed1", "filed3");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("DynamicFilterBean", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
