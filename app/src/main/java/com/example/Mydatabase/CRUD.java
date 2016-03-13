package com.example.Mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CRUD {
	DatabaseGuide connect_db;
	SQLiteDatabase db;
	
	public CRUD(Context context) {
		connect_db =new DatabaseGuide(context);
		db = connect_db.getWritableDatabase();
		
		
	}
	
	public long createUser (String user,String pass){
		ContentValues values = new ContentValues();
		values.put("Username" , user);
		values.put("Password" , pass);
		
		return db.insert(connect_db.DB_TABLE_ADMIN, null, values);
		
	}

}
