@Entity
public class Cargo extends IdSuperClass {

	private String nome;
	
	@Type(type="true_false")
	private boolean isAdmin;
	
	///cri
	
}
