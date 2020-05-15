package es.upm.dit.isst.tfg.model;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable {
	
	//operador de Eclipse no entra en la examen
	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String password;
	private String name;

	@OneToMany(mappedBy = "advisor",fetch = FetchType.EAGER)
	private Collection<TFG> advisedTFGs;

	public Professor() {
		super();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the advisedTFGs
	 */
	public Collection<TFG> getAdvisedTFGs() {
		return advisedTFGs;
	}

	/**
	 * @param advisedTFGs the advisedTFGs to set
	 */
	public void setAdvisedTFGs(Collection<TFG> advisedTFGs) {
		this.advisedTFGs = advisedTFGs;
	}

	@Override
	public String toString() {
		return "Professor [email=" + email + ", password=" + password + ", name=" + name + ", advisedTFGs="
				+ advisedTFGs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Professor other = (Professor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}


}
