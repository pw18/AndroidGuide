package com.example.Mydatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseGuide extends SQLiteOpenHelper {
	
	private final static String DB_NAME = "MyDB";
	private static int db_version = 1 ;
	public static String DB_TABLE_ADMIN ="TABLE_ADMIN";
	public static String DB_USERNAME ="Username";
	public static String DB_PASSWORD ="Password";
	
	String SQL_TABLE_ADMIN = "CREATE TABLE"+DB_TABLE_ADMIN+"("+DB_USERNAME+" text (250) primary key autoincrement, "+
																													
																									DB_PASSWORD+" text(250))";
	
	public static String DB_TABLE_Diseases ="TABLE_Diseases";
	public static String DB_Dis_ID ="ID";
	public static String DB_DisName ="DisName";
	public static String DB_DisSysptom ="DisSysptom";
	public static String DB_DisCause ="DisCause";
	public static String DB_DisSysptomInstant ="DisSysptomInstant";
	
	String SQL_TABLE_Diseases = "CREATE TEBLE"+DB_TABLE_Diseases+"("+DB_Dis_ID+"integer primary key autoincrement,"+
	
																									DB_DisName+" text(250), "+
																									DB_DisSysptom+" text(250), "+
																									DB_DisCause+" text(250), "+
																									DB_DisSysptomInstant+" text(250))";
																									
	public static String DB_TABLE_FirstAid ="TABLE_FirstAid";
	public static String DB_FirstAid_ID ="ID";
	public static String DB_FirstAidDetails ="DetailsFirstAid";
	public static 
	
	String SQL_TABLE_FirstAid = "CREATE TEBLE"+DB_TABLE_FirstAid+"("+DB_FirstAid_ID+"integer primary key autoincrement,"+
			
																													DB_FirstAidDetails+" text(250)), ";
																													
	
	public static String DB_TABLE_MedicineModern ="TABLE_MedicineModern";
	public static String DB_Mod_ID ="ID";
	public static String DB_ModName ="ModName";
	public static String DB_ModParallel ="ModParallel";
	public static String DB_ModDetails ="ModDetails";
	public static 
	
	String SQL_TABLE_MedicineModern ="CREATE TABLE"+DB_TABLE_MedicineModern+"("+DB_Mod_ID+"integer primary key autonicrement,"+
																													DB_ModName+ "text(250),"+
																													DB_ModParallel+ "text(250),"+
																													DB_ModDetails+ "text(250))";
																													
	
	public static String DB_TABLE_MedicineTraditional ="TABLE_MedicineTraditional";
	public static String DB_Tra_ID ="ID";
	public static String DB_TraName ="TraName";
	public static String DB_TraParallel ="TraParallel";
	public static String DB_TraDetails ="TraDetails";
	
	
	String SQL_TABLE_MedicineTraditional ="CREATE TABLE"+DB_TABLE_MedicineTraditional+"("+DB_Tra_ID+" integer primary key autonicrement,"+
																													DB_TraName+ "text(250),"+
																													DB_TraParallel+ "text(250),"+
																													DB_TraDetails+ "text(250))";
																											
	
	public static String DB_TABLE_Hospital ="TABLE_Hospital";
	public static String DB_Hos_ID ="ID";
	public static String DB_HosName ="HosName";
	public static String DB_HosAddress ="HosAddress";
	public static String DB_HosProvince ="HosProvince";
	public static String DB_HosArea ="HosArea";
	public static String DB_HosPhone ="HosPhone";
	public static String DB_HosPicture ="HosPicture";
	
	String SQL_TABLE_Hospital="CREATE TEBLE"+DB_TABLE_Hospital+"("+DB_Hos_ID+" integer primary key autonicremment, "+
																													DB_HosName+ "text(250),"+
																													DB_HosAddress+ "text(250),"+
																													DB_HosProvince+ "text(250),"+
																													DB_HosArea+ "text(250),"+
																													DB_HosPhone+ "text(250),"+
																													DB_HosPicture+ "image,";
	
	
	
	
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
