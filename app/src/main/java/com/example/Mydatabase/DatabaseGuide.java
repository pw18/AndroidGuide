package com.example.Mydatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseGuide extends SQLiteOpenHelper {
	
	private final static String DB_NAME = "MyDB";
	private static int db_version = 1 ;
	public static String DB_TABLE_ADMIN ="TABLE_ADMIN";
	public static String DB_Feild_ID = "Id";
	public static String DB_USERNAME ="Username";
	public static String DB_PASSWORD ="Password";
	
	String SQL_TABLE_ADMIN = "CREATE TABLE " + DB_TABLE_ADMIN + "(" +
			DB_Feild_ID+" integer primary key autoincrement, "+
			DB_USERNAME+" text(10), "+
			DB_PASSWORD+" integer (5))";


	public static String DB_TABLE_Diseases ="TABLE_Diseases";
	public static String DB_Dis_ID ="Dis_ID";
	public static String DB_DisName ="Dis_Name";
	public static String DB_DisSysptom ="Dis_Sysptom";
	public static String DB_DisCause ="Dis_Cause";
	public static String DB_DisSysptomInstant ="Dis_SysptomInstant";
	
	String SQL_TABLE_Diseases = "CREATE TEBLE " + DB_TABLE_Diseases + "(" +
			DB_Dis_ID+" integer primary key autoincrement,"+
			DB_DisName+" text(255), "+
			DB_DisSysptom+" text(255), "+
			DB_DisCause+" text(255), "+
			DB_DisSysptomInstant+" text(255))";

																									
	public static String DB_TABLE_FirstAid ="TABLE_FirstAid";
	public static String DB_FirstAid_ID ="FirstAid_ID";
	public static String DB_FirstAidDetails ="FirstAid_Details";

	String SQL_TABLE_FirstAid = "CREATE TEBLE " + DB_TABLE_FirstAid + "(" +
			DB_FirstAid_ID+"integer primary key autoincrement,"+
			DB_FirstAidDetails+" text(255))";
																													
	
	public static String DB_TABLE_MedicineModern ="TABLE_MedicineModern";
	public static String DB_Mod_ID ="Mod_ID";
	public static String DB_ModName ="Mod_Name";
	public static String DB_ModParallel ="Mod_Parallel";
	public static String DB_ModDetails ="Mod_Details";

	String SQL_TABLE_MedicineModern = "CREATE TABLE " + DB_TABLE_MedicineModern + "(" +
			DB_Mod_ID+"integer primary key autoincrement,"+
			DB_ModName+ "text(255), "+
			DB_ModParallel+ "text(255), "+
			DB_ModDetails+ "text(255))";
																													
	
	public static String DB_TABLE_MedicineTraditional ="TABLE_MedicineTraditional";
	public static String DB_Tra_ID ="Tra_ID";
	public static String DB_Tra_Name ="Tra_Name";
	public static String DB_Tra_Details ="Tra_Details";

	String SQL_TABLE_MedicineTraditional = "CREATE TABLE " + DB_TABLE_MedicineTraditional + "(" +
			DB_Tra_ID+" integer primary key autoincrement,"+
			DB_Tra_Name+ "text(255), "+
			DB_Tra_Details+ "text(255))";

																											
	
	public static String DB_TABLE_Hospital ="TABLE_Hospital";
	public static String DB_Hos_ID ="Hos_ID";
	public static String DB_Hos_Name ="Hos_Name";
	public static String DB_Hos_Address ="Hos_Address";
	public static String DB_Hos_Province ="Hos_Province";
	public static String DB_Hos_Area ="Hos_Area";
	public static String DB_Hos_Phone ="Hos_Phone";
	
	String SQL_TABLE_Hospital = "CREATE TEBLE " + DB_TABLE_Hospital + "(" +
			DB_Hos_ID+" integer primary key autoincrement, "+
			DB_Hos_Name+ "text(255), "+
			DB_Hos_Address+ "text(255), "+
			DB_Hos_Province+ "text(255), "+
			DB_Hos_Area+ "text(255), "+
			DB_Hos_Phone+ "text(255))";
	
	
	
	
	public  DatabaseGuide (Context context) {
		super(context, DB_NAME, null, db_version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_TABLE_ADMIN);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE_ADMIN);
		onCreate(db);
	}
	
																									
	
	
	
}
