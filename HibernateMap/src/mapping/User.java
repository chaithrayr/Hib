package mapping;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Bank_USERS")
public class User {

	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
	@PrimaryKeyJoinColumn 
	private int id;
	 @Column(name="name")
	private String name;
    @Column(name="email",unique=true)
	private String email;
	@Column(name="mobileno",unique=true)
	private long mobileno;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user", fetch=FetchType.EAGER) 
    private List<Bank> bank;
	
	public List<Bank> getBank() {
		return bank;
	}
	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	

}
