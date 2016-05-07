package com.example.Mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.AidModel;
import com.example.model.DiseasesModel;
import com.example.model.PhamaceuticalModel;
import com.example.model.HospitalProvinceModel;
import com.example.model.ProvinceModel;
import com.example.model.TraditionalModel;

import java.util.ArrayList;
import java.util.List;

public class CRUD {
	DatabaseGuide connect_db;
	SQLiteDatabase db;
	
	public CRUD(Context context) {
		connect_db =new DatabaseGuide(context);
		db = connect_db.getWritableDatabase();
	}
	
	public long createUser(String user,String pass){
		ContentValues values = new ContentValues();
		values.put("Username" , user);
		values.put("Password" , pass);
		return db.insert(connect_db.DB_TABLE_ADMIN, null, values);

	}

	public long testInsert(){
		ContentValues values = new ContentValues();
		values.put(DatabaseGuide.DB_DisName , "กระเพาะปัสสาวะอักเสบ (Cystitis)"+
				"อาการ  ถ่ายปัสสาวะบ่อยมาก  กะปริบกะปรอย  เวลาถ่ายปัสสาวะเสร็จแล้วจะรู้สึกปวดตรงหัวเหน่า  ปัสสาวะมีสีขุ่นหรือมีเลือดปน  ปวดหน่วง ๆ  ที่ท้องน้อย  รู้สึกเหมือนปัสสาวะไม่สุดอาจมีไข้ต่ำ");
		values.put(DatabaseGuide.DB_DisSysptom , "อาการ  ถ่ายปัสสาวะบ่อยมาก  กะปริบกะปรอย  เวลาถ่ายปัสสาวะเสร็จแล้วจะรู้สึกปวดตรงหัวเหน่า  ปัสสาวะมีสีขุ่นหรือมีเลือดปน  ปวดหน่วง ๆ  ที่ท้องน้อย  รู้สึกเหมือนปัสสาวะไม่สุดอาจมีไข้ต่ำ");
		values.put(DatabaseGuide.DB_DisCause , "สาเหตุ  ที่พบบ่อยเกิดจากการบาดเจ็บหลังมีเพศสัมพันธ์หรือการติดเชื้อจากการอั้นปัสสาวะ หรือเป็นนิ่ว");
		values.put(DatabaseGuide.DB_DisSysptomInstant , "อาการที่ควรไปพบแพทย์อย่างเร่งด่วน  ไข้สูง  หนาวสั่น ปวดท้องขึ้นมาถึงเอวและหลัง  ปัสสาวะเป็นเลือด  ปัสสาวะสะดุด  ปัสสาวะไม่ออก อาการเป็นซ้ำ ๆ  ซาก ๆ  รักษาแล้วไม่หายภายใน  5  วัน");
		return db.insert(connect_db.DB_TABLE_Diseases, null, values);
	}

	public List<DiseasesModel> selectDiseasesAll(){
		List<DiseasesModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_Diseases;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					DiseasesModel model = new DiseasesModel();
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisName)));
					model.setSysptom(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisSysptom)));
					model.setCause(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisCause)));
					model.setSysptomInstant(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisSysptomInstant)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<PhamaceuticalModel> selectPhamaceuticalAll(){
		List<PhamaceuticalModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_MedicineModern;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					PhamaceuticalModel model = new PhamaceuticalModel();
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_ModName)));
					model.setParallel(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_ModParallel)));
					model.setDetails(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_ModDetails)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<TraditionalModel> selectTraditionalAll(){
		List<TraditionalModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_MedicineTraditional;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					TraditionalModel model = new TraditionalModel();
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_Tra_Name)));
					model.setDetails(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_Tra_Details)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<AidModel> selectAidAll(){
		List<AidModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_FirstAid;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					AidModel model = new AidModel();
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_FirstName)));
					model.setDetails(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_FirstAidDetails)));


					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<ProvinceModel> selectProvince(int area){
		List<ProvinceModel> data = new ArrayList<>();
		String query = "SELECT a."+DatabaseGuide.DB_Province_id+ ", a."+DatabaseGuide.DB_Province_area_id+", a."+DatabaseGuide.DB_Province_Province +
				" FROM "+DatabaseGuide.DB_TABLE_Province + " AS a, "+DatabaseGuide.DB_TABLE_AREA+ " AS b"+
				" WHERE a."+DatabaseGuide.DB_Province_area_id+ " = b."+DatabaseGuide.DB_AREA_id +
				" AND a."+DatabaseGuide.DB_Province_area_id+ " = "+area;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()) {
			if (cursor.getCount() != 0) {
				do {
					ProvinceModel model = new ProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_Province_id)));
					model.setAreaId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_Province_area_id)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_Province_Province)));

					data.add(model);
				} while (cursor.moveToNext());
			}
		}
		return data;
	}

	public List<HospitalProvinceModel> selectHospitalCentralRegion(){
		List<HospitalProvinceModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_HospitalCentralRegion;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					HospitalProvinceModel model = new HospitalProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_HospitalCentralRegion_ID)));
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalCentralRegion_Name)));
					model.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalCentralRegion_Address)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalCentralRegion_Province)));
					model.setArea(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalCentralRegion_Area)));
					model.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalCentralRegion_Phone)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<HospitalProvinceModel> selectHospitalNorth(){
		List<HospitalProvinceModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_HospitalNorth;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					HospitalProvinceModel model = new HospitalProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorth_ID)));
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorth_Name)));
					model.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorth_Address)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorth_Province)));
					model.setArea(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorth_Area)));
					model.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorth_Phone)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<HospitalProvinceModel> selectHospitalEast(){
		List<HospitalProvinceModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_HospitalEast;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					HospitalProvinceModel model = new HospitalProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_HospitalEast_ID)));
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalEast_Name)));
					model.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalEast_Address)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalEast_Province)));
					model.setArea(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalEast_Area)));
					model.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalEast_Phone)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<HospitalProvinceModel> selectHospitalWest(){
		List<HospitalProvinceModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_HospitalWest;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					HospitalProvinceModel model = new HospitalProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_HospitalWest_ID)));
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalWest_Name)));
					model.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalWest_Address)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalWest_Province)));
					model.setArea(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalWest_Area)));
					model.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalWest_Phone)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<HospitalProvinceModel> selectHospitalNorthEast(){
		List<HospitalProvinceModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_HospitalNorthEast;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					HospitalProvinceModel model = new HospitalProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorthEast_ID)));
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorthEast_Name)));
					model.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorthEast_Address)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorthEast_Province)));
					model.setArea(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorthEast_Area)));
					model.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalNorthEast_Phone)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<HospitalProvinceModel> selectHospitalRealm(){
		List<HospitalProvinceModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_HospitalRealm;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					HospitalProvinceModel model = new HospitalProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_HospitalRealm_ID)));
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalRealm_Name)));
					model.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalRealm_Address)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalRealm_Province)));
					model.setArea(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalRealm_Area)));
					model.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalRealm_Phone)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}

	public List<HospitalProvinceModel> selectHospitalSouth(){
		List<HospitalProvinceModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_HospitalSouth;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					HospitalProvinceModel model = new HospitalProvinceModel();
					model.setId(cursor.getInt(cursor.getColumnIndex(DatabaseGuide.DB_HospitalSouth_ID)));
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalSouth_Name)));
					model.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalSouth_Address)));
					model.setProvince(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalSouth_Province)));
					model.setArea(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalSouth_Area)));
					model.setPhone(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_HospitalSouth_Phone)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
		
	}
}
