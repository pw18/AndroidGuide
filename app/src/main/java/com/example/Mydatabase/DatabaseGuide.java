package com.example.Mydatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseGuide extends SQLiteOpenHelper {
	
	private final static String DB_NAME = "mydatabase.db";
	private static int db_version = 1 ;
	public static String DB_TABLE_ADMIN ="TABLE_ADMIN";
	public static String DB_Feild_ID = "Id";
	public static String DB_USERNAME ="Username";
	public static String DB_PASSWORD ="Password";
	public static int Realm = 1;
	public static int Central = 2;
	public static int North = 3;
	public static int South = 4;
	public static int East = 5;
	public static int West = 6;
	public static int NorthEast = 7;

	String SQL_TABLE_ADMIN = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_ADMIN + "(" +
			DB_Feild_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_USERNAME+" TEXT, "+
			DB_PASSWORD+" integer)";

	public static String DB_TABLE_Diseases ="TABLE_Diseases";
	public static String DB_Dis_ID ="Dis_ID";
	public static String DB_DisName ="Dis_Name";
	public static String DB_DisSysptom ="Dis_Sysptom";
	public static String DB_DisCause ="Dis_Cause";
	public static String DB_DisSysptomInstant ="Dis_Sysptom_Instant";
	
	String SQL_TABLE_Diseases = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_Diseases + "(" +
			DB_Dis_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
			DB_DisName+" TEXT, "+
			DB_DisSysptom+" TEXT, "+
			DB_DisCause+" TEXT, "+
			DB_DisSysptomInstant+" TEXT)";

	public static String DB_TABLE_FirstAid ="TABLE_FirstAid";
	public static String DB_FirstAid_ID ="FirstAid_ID";
	public static String DB_FirstName ="FirstName";
	public static String DB_FirstAidDetails ="FirstAid_Details";

	String SQL_TABLE_FirstAid = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_FirstAid + "(" +
			DB_FirstAid_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
			DB_FirstName+" TEXT ,"+
			DB_FirstAidDetails+" TEXT)";

	public static String DB_TABLE_MedicineModern ="TABLE_MedicineModern";
	public static String DB_Mod_ID ="Mod_ID";
	public static String DB_ModName ="Mod_Name";
	public static String DB_ModParallel ="Mod_Parallel";
	public static String DB_ModDetails ="Mod_Details";

	String SQL_TABLE_MedicineModern = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_MedicineModern + "(" +
			DB_Mod_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
			DB_ModName+ " TEXT, "+
			DB_ModParallel+ " TEXT, "+
			DB_ModDetails+ " TEXT)";

	public static String DB_TABLE_MedicineTraditional ="TABLE_MedicineTraditional";
	public static String DB_Tra_ID ="Tra_ID";
	public static String DB_Tra_Name ="Tra_Name";
	public static String DB_Tra_Details ="Tra_Details";

	String SQL_TABLE_MedicineTraditional = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_MedicineTraditional + "(" +
			DB_Tra_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
			DB_Tra_Name+ " TEXT, "+
			DB_Tra_Details+ " TEXT)";

	public static String DB_TABLE_AREA ="TABLE_AREA";
	public static String DB_AREA_id ="id";
	public static String DB_AREA_AREA ="area";

	String SQL_TABLE_AREA = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_AREA + "(" +
			DB_AREA_id+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
			DB_AREA_AREA+ " TEXT) ";


	public static String DB_TABLE_Province ="TABLE_Province";
	public static String DB_Province_id ="id";
	public static String DB_Province_area_id ="area_id";
	public static String DB_Province_Province ="province";

	String SQL_TABLE_Province = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_Province + "(" +
			DB_Province_id+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"+
			DB_Province_area_id+ "INTEGER, "+
			DB_Province_Province+ " TEXT) ";


	public static String DB_TABLE_HospitalWest ="TABLE_HospitalWest";
	public static String DB_HospitalWest_ID ="Hos_ID";
	public static String DB_HospitalWest_province_id ="Hos_Province_id";
	public static String DB_HospitalWest_Name ="Hos_Name";
	public static String DB_HospitalWest_Address ="Hos_Address";
	public static String DB_HospitalWest_Province ="Hos_Province";
	public static String DB_HospitalWest_Area ="Hos_Area";
	public static String DB_HospitalWest_Phone ="Hos_Phone";
	public static String DB_HospitalWest_Lat ="Hos_Lat";
	public static String DB_HospitalWest_Long ="Hos_Long";
	
	String SQL_TABLE_HospitalWest = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_HospitalWest + "(" +
			DB_HospitalWest_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_HospitalWest_province_id+ "INTEGER, "+
			DB_HospitalWest_Name+ " TEXT, "+
			DB_HospitalWest_Address+ " TEXT, "+
			DB_HospitalWest_Province+ " TEXT, "+
			DB_HospitalWest_Area+ " TEXT, "+
			DB_HospitalWest_Phone+ " TEXT,"+
			DB_HospitalWest_Lat+ "TEXT, "+
			DB_HospitalWest_Long+ "TEXT) ";



	public static String DB_TABLE_HospitalCentralRegion ="TABLE_HospitalCentralRegion";
	public static String DB_HospitalCentralRegion_ID ="Hos_ID";
	public static String DB_HospitalCentralRegion_province_id ="Hos_Province_id";
	public static String DB_HospitalCentralRegion_Name ="Hos_Name";
	public static String DB_HospitalCentralRegion_Address ="Hos_Address";
	public static String DB_HospitalCentralRegion_Province ="Hos_Province";
	public static String DB_HospitalCentralRegion_Area ="Hos_Area";
	public static String DB_HospitalCentralRegion_Phone ="Hos_Phone";
	public static String DB_HospitalCentralRegion_Lat ="Hos_Lat";
	public static String DB_HospitalCentralRegion_Long ="Hos_Long";

	String SQL_TABLE_HospitalCentralRegion = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_HospitalCentralRegion + "(" +
			DB_HospitalCentralRegion_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_HospitalCentralRegion_province_id+ "INTEGER, "+
			DB_HospitalCentralRegion_Name+ " TEXT, "+
			DB_HospitalCentralRegion_Address+ " TEXT, "+
			DB_HospitalCentralRegion_Province+ " TEXT, "+
			DB_HospitalCentralRegion_Area+ " TEXT, "+
			DB_HospitalCentralRegion_Phone+ " TEXT, "+
			DB_HospitalCentralRegion_Lat+ "TEXT, "+
			DB_HospitalCentralRegion_Long+ "TEXT) ";

	public static String DB_TABLE_HospitalEast ="TABLE_HospitalEast";
	public static String DB_HospitalEast_ID ="Hos_ID";
	public static String DB_HospitalEast_province_id ="Hos_Province_id";
	public static String DB_HospitalEast_Name ="Hos_Name";
	public static String DB_HospitalEast_Address ="Hos_Address";
	public static String DB_HospitalEast_Province ="Hos_Province";
	public static String DB_HospitalEast_Area ="Hos_Area";
	public static String DB_HospitalEast_Phone ="Hos_Phone";
	public static String DB_HospitalEast_Lat ="Hos_Lat";
	public static String DB_HospitalEast_Long ="Hos_Long";


	String SQL_TABLE_HospitalEast = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_HospitalEast + "(" +
			DB_HospitalEast_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_HospitalEast_province_id+ "INTEGER, "+
			DB_HospitalEast_Name+ " TEXT, "+
			DB_HospitalEast_Address+ " TEXT, "+
			DB_HospitalEast_Province+ " TEXT, "+
			DB_HospitalEast_Area+ " TEXT, "+
			DB_HospitalEast_Phone+ " TEXT, "+
			DB_HospitalEast_Lat+ "TEXT, "+
			DB_HospitalEast_Long+ "TEXT) ";


	public static String DB_TABLE_HospitalNorth="TABLE_HospitalNorth";
	public static String DB_HospitalNorth_ID ="Hos_ID";
	public static String DB_HospitalNorth_province_id ="Hos_Province_id";
	public static String DB_HospitalNorth_Name ="Hos_Name";
	public static String DB_HospitalNorth_Address ="Hos_Address";
	public static String DB_HospitalNorth_Province ="Hos_Province";
	public static String DB_HospitalNorth_Area ="Hos_Area";
	public static String DB_HospitalNorth_Phone ="Hos_Phone";
	public static String DB_HospitalNorth_Lat ="Hos_Lat";
	public static String DB_HospitalNorth_Long ="Hos_Long";

	String SQL_TABLE_HospitalNorth = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_HospitalNorth+ "(" +
			DB_HospitalNorth_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_HospitalNorth_province_id+ "INTEGER, "+
			DB_HospitalNorth_Name+ " TEXT, "+
			DB_HospitalNorth_Address+ " TEXT, "+
			DB_HospitalNorth_Province+ " TEXT, "+
			DB_HospitalNorth_Area+ " TEXT, "+
			DB_HospitalNorth_Phone+ " TEXT, "+
			DB_HospitalNorth_Lat+ "TEXT, "+
			DB_HospitalNorth_Long+ "TEXT) ";

	public static String DB_TABLE_HospitalRealm="TABLE_HospitalRealm";
	public static String DB_HospitalRealm_ID ="Hos_ID";
	public static String DB_HospitalRealm_province_id ="Hos_Province_id";
	public static String DB_HospitalRealm_Name ="Hos_Name";
	public static String DB_HospitalRealm_Address ="Hos_Address";
	public static String DB_HospitalRealm_Province ="Hos_Province";
	public static String DB_HospitalRealm_Area ="Hos_Area";
	public static String DB_HospitalRealm_Phone ="Hos_Phone";
	public static String DB_HospitalRealm_Lat ="Hos_Lat";
	public static String DB_HospitalRealm_Long ="Hos_Long";

	String SQL_TABLE_HospitalRealm = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_HospitalRealm+ "(" +
			DB_HospitalRealm_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_HospitalRealm_province_id+ "INTEGER, "+
			DB_HospitalRealm_Name+ " TEXT, "+
			DB_HospitalRealm_Address+ " TEXT, "+
			DB_HospitalRealm_Province+ " TEXT, "+
			DB_HospitalRealm_Area+ " TEXT, "+
			DB_HospitalRealm_Phone+ " TEXT, "+
			DB_HospitalRealm_Lat+ "TEXT, "+
			DB_HospitalRealm_Long+ "TEXT) ";

	public static String DB_TABLE_HospitalSouth="TABLE_HospitalSouth";
	public static String DB_HospitalSouth_ID ="Hos_ID";
	public static String DB_HospitalSouth_province_id ="Hos_Province_id";
	public static String DB_HospitalSouth_Name ="Hos_Name";
	public static String DB_HospitalSouth_Address ="Hos_Address";
	public static String DB_HospitalSouth_Province ="Hos_Province";
	public static String DB_HospitalSouth_Area ="Hos_Area";
	public static String DB_HospitalSouth_Phone ="Hos_Phone";
	public static String DB_HospitalSouth_Lat ="Hos_Lat";
	public static String DB_HospitalSouth_Long ="Hos_Long";

	String SQL_TABLE_HospitalSouth = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_HospitalSouth+ "(" +
			DB_HospitalSouth_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_HospitalSouth_province_id+ "INTEGER ,"+
			DB_HospitalSouth_Name+ " TEXT, "+
			DB_HospitalSouth_Address+ " TEXT, "+
			DB_HospitalSouth_Province+ " TEXT, "+
			DB_HospitalSouth_Area+ " TEXT, "+
			DB_HospitalSouth_Phone+ " TEXT,"+
			DB_HospitalSouth_Lat+ "TEXT, "+
			DB_HospitalSouth_Long+ "TEXT) ";


	public static String DB_TABLE_HospitalNorthEast="TABLE_HospitalNorthEast";
	public static String DB_HospitalNorthEast_ID ="Hos_ID";
	public static String DB_HospitalNorthEast_province_id ="Hos_Province_id";
	public static String DB_HospitalNorthEast_Name ="Hos_Name";
	public static String DB_HospitalNorthEast_Address ="Hos_Address";
	public static String DB_HospitalNorthEast_Province ="Hos_Province";
	public static String DB_HospitalNorthEast_Area ="Hos_Area";
	public static String DB_HospitalNorthEast_Phone ="Hos_Phone";
	public static String DB_HospitalNorthEast_Lat ="Hos_Lat";
	public static String DB_HospitalNorthEast_Long ="Hos_Long";

	String SQL_TABLE_HospitalNorthEast = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_HospitalNorthEast+ "(" +
			DB_HospitalNorthEast_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
			DB_HospitalNorthEast_province_id+ "INTEGER, "+
			DB_HospitalNorthEast_Name+ " TEXT, "+
			DB_HospitalNorthEast_Address+ " TEXT, "+
			DB_HospitalNorthEast_Province+ " TEXT, "+
			DB_HospitalNorthEast_Area+ " TEXT, "+
			DB_HospitalNorthEast_Phone+ " TEXT, "+
			DB_HospitalNorthEast_Lat+ "TEXT, "+
			DB_HospitalNorthEast_Long+ "TEXT) " ;


	public DatabaseGuide (Context context) {
		super(context, DB_NAME, null, db_version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_TABLE_ADMIN);
		db.execSQL(SQL_TABLE_Diseases);
		db.execSQL(SQL_TABLE_FirstAid);
		db.execSQL(SQL_TABLE_MedicineModern);
		db.execSQL(SQL_TABLE_MedicineTraditional);
		db.execSQL(SQL_TABLE_HospitalWest);
		db.execSQL(SQL_TABLE_HospitalCentralRegion);
		db.execSQL(SQL_TABLE_HospitalEast);
		db.execSQL(SQL_TABLE_HospitalNorth);
		db.execSQL(SQL_TABLE_HospitalRealm);
		db.execSQL(SQL_TABLE_HospitalSouth);
		db.execSQL(SQL_TABLE_HospitalNorthEast);
		db.execSQL(SQL_TABLE_AREA);
		db.execSQL(SQL_TABLE_Province);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE_ADMIN);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_Diseases);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_FirstAid);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_MedicineModern);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_MedicineTraditional);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_HospitalWest);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_HospitalCentralRegion);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_HospitalEast);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_HospitalNorth);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_HospitalRealm);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_HospitalSouth);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_HospitalNorthEast);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_AREA);
		db.execSQL("DROP TABLE IF EXISTS "+SQL_TABLE_Province);

		onCreate(db);
	}
}
