package com.bibhu.springboot.learnjpaandhibernate01.dao.jdbc;

import com.bibhu.springboot.learnjpaandhibernate01.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseJdbcRepository {

    private static final String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values(1, 'Learn AWS', 'in28min');
            """;

    private static final String INSERT_QUERY_PLACE_HOLDER =
            """
                insert into course (id, name, author)
                values(?, ?, ?);
            """;

    private static final String DELETE_BY_ID =
            """
                delete from course
                where id = ?;
            """;

    private static final String SELECT_QUERY =
            """
                select * from course;
            """;

    private static final String SELECT_BY_ID =
            """
                select * from course
                where id = ?;
            """;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertQuery() {
        jdbcTemplate.update(INSERT_QUERY);
    }

    public void insertCourse(Course course) {
        jdbcTemplate.update(INSERT_QUERY_PLACE_HOLDER, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    public List<Course> fetchAllCourse() {
        return jdbcTemplate.query(SELECT_QUERY, new BeanPropertyRowMapper(Course.class));
    }

    public Course fetchCourseById(long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
