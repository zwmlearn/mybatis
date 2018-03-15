package main;

import model.Student;
import model.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String ROOT_PATH = "E:\\Workplace\\idea-workplace\\MyBatisLearnDemo\\";
    public static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {

        String resource = "model/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

//            System.out.println(studentMapper.selectStudentById(1));

//            List<Student> students = studentMapper.selectAllStudent();
//
//            for (Student stut : students) {
//                System.out.println(stut);
//            }

            Map<Integer, Student> studentMap = studentMapper.selectAllStudentWithMap();

            for (int i : studentMap.keySet()) {
                System.out.println(String.format(
                        "%3d: %s", i, studentMap.get(i)
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
    }
}
