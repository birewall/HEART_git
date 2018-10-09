package Model;

import java.util.ArrayList;

import com.mysql.jdbc.log.Log;

/*
 * Below data is default. Changing this order may shutdown program
 * Index 0 : Logger
 * Index 1 : Database
 * */
public class MSharedData extends AbsMetaModel{
	private ArrayList<AbsMetaModel> data;
	private ArrayList<String> catalog;
	
	public MSharedData(){
		this.data = new ArrayList<AbsMetaModel>();
		this.catalog = new ArrayList<String>();
		
		/* Add Logger */
		this.data.add(new MLogger());
		this.catalog.add("logger");
		
		/* Add DB */
		this.data.add(new MDatabase());
		this.catalog.add("database");
	}
	
	public AbsMetaModel get(int index) {
		if(index-1 > this.data.size()) return null;
		else return this.data.get(index);
	}
	
	public AbsMetaModel get(String name) {
		int index = getIndex(name);
		if(index < 0) return null;
		else return this.data.get(index);
	}
	
	public MDatabase getDB() {
		return (MDatabase)this.data.get(1);
	}
	
	public MLogger getLogger() {
		return (MLogger)this.data.get(0);
	}
	
	public boolean add(AbsMetaModel data, String name) {
		int index = getIndex(name);
		if(index >= 0) {
			getLogger().error("[MSharedData - add] Same model data exists");
			return false;
		}
		
		this.data.add(data);
		this.catalog.add(name);
		return true;
	}
	
	public String getName(int index) {
		if(index-1 > this.catalog.size()) return null;
		else return this.catalog.get(index);
	}
	
	/*
	 * 	Returns index when the data exists
	 *  else return -1
	 * */
	public int getIndex(String name) {
		int index = -1;
		for(int i = 0 ; i < this.catalog.size() ; i++) {
			if(this.catalog.get(i).equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void remove(int index) {
		if(index-1 > this.catalog.size()) return;
		else{
			this.data.remove(index);
			this.catalog.remove(index);
		}
	}
	
	public void remove(String name) {
		int index = getIndex(name);
		if(index != -1) {
			this.data.remove(index);
			this.catalog.remove(index);
		}
	}

	public boolean isExist(String name) {
		for (String aCatalog : this.catalog) {
			if (aCatalog.equals(name)) return true;
		}
		return false;
	}
}
