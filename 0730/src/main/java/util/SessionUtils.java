package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: NewJavaWebProject
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/20 15:40
 */
public class SessionUtils {
   public static SqlSession getSession(boolean autocommit) throws IOException {
         InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         return sqlSessionFactory.openSession(autocommit);
   }

   public static void close(SqlSession sqlSession){
      if (sqlSession != null) {
         sqlSession.close();
      }
   }
}