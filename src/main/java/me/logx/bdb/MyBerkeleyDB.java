package me.logx.bdb;

import java.io.File;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

public class MyBerkeleyDB {
	private Environment env;

	public Environment getEnv() {
		return env;
	}

	private Database db;

	public MyBerkeleyDB() {
	}

	/** 
	 * 构建数据库的开发环境 
	 *  
	 * @param path   数据库开发环境的目录 
	 * @param cacheSize  配置缓存大小 
	 */
	public void setUp(String path, long cacheSize) {
		EnvironmentConfig envConfig = new EnvironmentConfig();
		//当设置为true时，说明若没有数据库的环境时，可以打开。否则就不能打开 
		envConfig.setAllowCreate(true);
		//envConfig.setReadOnly(true); 
		envConfig.setCacheSize(cacheSize);
		//设置事务 
		//envConfig.setTransactional(true); 
		//当提交事务的时候是否把缓存中的内容同步到磁盘中去。true 表示不同步，也就是说不写磁盘 
		//envConfig.setTxnNoSync(true); 
		//当提交事务的时候，是否把缓冲的log写到磁盘上,true 表示不同步，也就是说不写磁盘 
		//envConfig.setTxnWriteNoSync(true); 
		try {
			env = new Environment(new File(path), envConfig);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * 构建数据库 
	 *  
	 * @param dbName 数据库的名称 
	 */
	public void open(String dbName) {
		DatabaseConfig dbConfig = new DatabaseConfig();
		//设置数据的是否可以创建的属性 
		dbConfig.setAllowCreate(true);
		try {
			db = env.openDatabase(null, dbName, dbConfig);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * 关闭berkeley db 
	 */
	public void close() {
		try {
			if (db != null) {
				db.close();
			}
			if (env != null) {
				env.cleanLog();
				env.close();
			}
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * 通过key得到数据 
	 * @param key   berkeley db中的key 
	 * @return 
	 * @throws Exception 
	 */
	public String get(String key) throws Exception {
		DatabaseEntry queryKey = new DatabaseEntry();
		DatabaseEntry value = new DatabaseEntry();
		queryKey.setData(key.getBytes("UTF-8"));
		OperationStatus status = db.get(null, queryKey, value, LockMode.DEFAULT);
		if (status == OperationStatus.SUCCESS) {
			return new String(value.getData(), "utf-8");
		}
		return null;
	}

	/** 
	 * 向berkeley db中存入数据 
	 * @param key  存入berkeley db时的键 
	 * @param value  存入berkeley db时的值 
	 * @return 
	 * @throws Exception 
	 */
	public boolean put(String key, String value) throws Exception {
		byte[] theKey = key.getBytes("UTF-8");
		byte[] theValue = value.getBytes("UTF-8");
		/** 
		 * Berkeley DB中的记录包括两个字段，就是键和值， 
		 * 并且这些键和值都必须是com.sleepycat.je.DatabaseEntry类的实例。 
		 */
		OperationStatus status = db.put(null, new DatabaseEntry(theKey), new DatabaseEntry(theValue));
		if (status == OperationStatus.SUCCESS) {
			return true;
		}
		return false;
	}

	/** 
	 * 通过 
	 * @param key 
	 * @return 
	 * @throws Exception 
	 */
	public boolean del(String key) throws Exception {
		DatabaseEntry queryKey = new DatabaseEntry();
		queryKey.setData(key.getBytes("UTF-8"));
		OperationStatus status = db.delete(null, queryKey);
		if (status == OperationStatus.SUCCESS) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyBerkeleyDB mbdb = new MyBerkeleyDB();
		//必须先在你的C盘中创建文件夹bdb 
		mbdb.setUp("D://bdb", 1000000);
		mbdb.open("myDB");
		try {
			System.out.println(mbdb.getEnv().getConfig());
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		System.out.println("开始向Berkeley db 中输入数据...");
		for (int i = 0; i < 20; i++) {
			try {
				String key = "myKey" + i;
				String value = "myValue" + i;
				//System.out.println("[" + key + ":" + value + "]"); 
				mbdb.put(key, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println(mbdb.get("myKey2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (mbdb.del("myKey2")) {
				System.out.println("ture");
			} else {
				System.out.println("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mbdb.close();

	}
}