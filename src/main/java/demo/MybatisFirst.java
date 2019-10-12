package demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import po.User;

public class MybatisFirst {
	//�Ự����
		private SqlSessionFactory sqlSessionFactory;

		@Before
		public void createSqlSessionFactory() throws IOException {
			// �����ļ�
			String resource = "SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// ʹ��SqlSessionFactoryBuilder��xml�����ļ��д���SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		}

		// ���� id��ѯ�û���Ϣ
		@Test
		public void testFindUserById() {
			// ���ݿ�Ựʵ��
			SqlSession sqlSession = null;
			try {
				// �������ݿ�Ựʵ��sqlSession
				sqlSession = sqlSessionFactory.openSession();
				// ��ѯ������¼�������û�id��ѯ�û���Ϣ
				User user = sqlSession.selectOne("test.findUserById", 10);
				// ����û���Ϣ
				System.out.println(user);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}

		}
	}