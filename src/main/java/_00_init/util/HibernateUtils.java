package _00_init.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// SessionFactory非常佔記憶體，因此絕對不要重複建立SessionFactory
public class HibernateUtils {
	// 靜態變數，意謂buildSessionFactory()只做一次
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	//建立Session工廠，但不用研究怎麼寫，Sprint不用寫
	private static SessionFactory buildSessionFactory() {
		try {
			// Hibernate 5.x 的寫法
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			// configure("主態檔(去 src/main/resources 中的 hibernate.cfg.xml 的 Properties 複製路徑貼上)")

			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			return sessionFactory;

		} catch (Throwable ex) {
			System.err.println("新建SessionFactory失敗:" + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

	// 外界呼叫此靜態方法來取得 SessionFactory物件
	// 只有get沒有set，就代表唯獨
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 外界呼叫此靜態方法來關閉 SessionFactory物件
	public static void close() {
		getSessionFactory().close();
	}

}