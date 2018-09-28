package library.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

	public enum Tip {
		ROLE_USER, ROLE_ADMIN
	}
	
	@Enumerated(EnumType.STRING)
	public Tip tip;

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
}
