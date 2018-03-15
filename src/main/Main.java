package main;

import model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.InputStream;

public class Main {
    public static final String ROOT_PATH = "E:\\Workplace\\idea-workplace\\MyBatisLearnDemo\\";
    public static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {

        try {
            String resource = "main/configuration.xml";

//            File file = new File(resource);
//            if (file.exists()) {
//                System.out.println("xml file exists");
//            }

            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            Student student = (Student) sqlSession.selectOne("model.Student.selectStudent", 1);

            System.out.println(student.toString());

            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
