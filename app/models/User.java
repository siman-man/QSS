package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class User extends Model {
	@Id
	public Long id;
	
	public String name;
	
	public String password;
}
