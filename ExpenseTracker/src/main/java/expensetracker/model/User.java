package expensetracker.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity

public class User {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String username;
	    private String password;
	    
	    @OneToMany(fetch = FetchType.EAGER)
	   
	    private Set<Expense> exp = new HashSet<>();
	    public User() {}

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

		public int getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Set<Expense> getExp() {
			return exp;
		}

		public void setExp(Set<Expense> exp) {
			this.exp = exp;
		}
		
	    
}
