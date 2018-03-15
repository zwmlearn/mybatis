package model;

import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Student selectStudentById(int id);
    List<Student> selectAllStudent();
    @MapKey("id")
    Map<Integer, Student> selectAllStudentWithMap();
}
