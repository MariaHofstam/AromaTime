package se.lexicon.maria.aromatime.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String oilName;
	
	public Oil(String oilName) {
		this.oilName = oilName;
	}
	
	protected Oil() {}

	

	public String getOilName() {
		return oilName;
	}

	public void setOilName(String oilName) {
		this.oilName = oilName;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Oil [id=" + id + ", oilName=" + oilName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((oilName == null) ? 0 : oilName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oil other = (Oil) obj;
		if (id != other.id)
			return false;
		if (oilName == null) {
			if (other.oilName != null)
				return false;
		} else if (!oilName.equals(other.oilName))
			return false;
		return true;
	}
	
}
