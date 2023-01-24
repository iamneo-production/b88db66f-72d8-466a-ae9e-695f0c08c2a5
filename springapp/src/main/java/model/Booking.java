package model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Booking {
    @Id
	private int id;
	private String name;
	private String mname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
}
