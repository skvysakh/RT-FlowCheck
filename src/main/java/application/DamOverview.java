package application;

public class DamOverview {
	private String _id =  "example_id";
	  private String _rev = null;
private String dam_id;
private String dam_name;
private String dam_max_capacity;
private String dam_water_mass;
private String dam_alert_status;

public DamOverview(String id, String name, String capacity, String mass, String status) {
	this._id = id;
	this.dam_id = id;
	this.dam_name = name;
	this.dam_max_capacity = capacity;
	this.dam_water_mass = mass;
	this.dam_alert_status = status;
}


public String getDam_id() {
	return dam_id;
}
public void setDam_id(String dam_id) {
	this.dam_id = dam_id;
}
public String getDam_name() {
	return dam_name;
}
public void setDam_name(String dam_name) {
	this.dam_name = dam_name;
}
public String getDam_max_capacity() {
	return dam_max_capacity;
}
public void setDam_max_capacity(String dam_max_capacity) {
	this.dam_max_capacity = dam_max_capacity;
}
public String getDam_water_mass() {
	return dam_water_mass;
}
public void setDam_water_mass(String dam_water_mass) {
	this.dam_water_mass = dam_water_mass;
}
public String getDam_alert_status() {
	return dam_alert_status;
}
public void setDam_alert_status(String dam_alert_status) {
	this.dam_alert_status = dam_alert_status;
}


public String get_id() {
	return _id;
}


public void set_id(String _id) {
	this._id = _id;
}


public String get_rev() {
	return _rev;
}


public void set_rev(String _rev) {
	this._rev = _rev;
}


public String toString() {
	return "{id:"+dam_id+"}";
}

}
