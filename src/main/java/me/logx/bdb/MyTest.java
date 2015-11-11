package me.logx.bdb;

import java.io.File;
import java.io.UnsupportedEncodingException;
import com.sleepycat.bind.EntityBinding;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.tuple.LongBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

/** 
 * 对java中的内置对象的存储 
 * @author Administrator 
 * 
 */
public class MyTest {
	public static void main(String[] args) {
		Environment env = null;
		Database db = null;
		EnvironmentConfig envconfig = new EnvironmentConfig();
		envconfig.setAllowCreate(true);
		try {
			env = new Environment(new File("D://bdb"), envconfig);
			DatabaseConfig dbconfig = new DatabaseConfig();
			dbconfig.setAllowCreate(true);
			db = env.openDatabase(null, "dbac.db", dbconfig);
			String key = "mykey";
			DatabaseEntry thekey = new DatabaseEntry();
			thekey.setData(key.getBytes("utf-8"));

			Long value = new Long(123456);
			DatabaseEntry thevalue = new DatabaseEntry();
			EntryBinding myBinging = TupleBinding.getPrimitiveBinding(Long.class);
			myBinging.objectToEntry(value, thevalue);
			//LongBinding myLongBinging=(LongBinding)TupleBinding.getPrimitiveBinding(Long.class); 
			//myLongBinging.objectToEntry(value, thevalue); 
			db.put(null, thekey, thevalue);
			DatabaseEntry valueEntry = new DatabaseEntry();
			OperationStatus status = db.get(null, thekey, valueEntry, LockMode.DEFAULT);
			if (status == OperationStatus.SUCCESS) {
				//Long number=myLongBinging.entryToObject(valueEntry); 
				Long number = (Long) myBinging.entryToObject(valueEntry);
				System.out.println(env.getDatabaseNames());
				System.out.println(number);
			}
		} catch (EnvironmentLockedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null) {
				try {
					db.close();
				} catch (DatabaseException e) {
					e.printStackTrace();
				}
			}
			if (env != null) {
				try {
					env.cleanLog();
					env.close();
				} catch (DatabaseException e) {
					e.printStackTrace();
				}
			}
		}
	}
}