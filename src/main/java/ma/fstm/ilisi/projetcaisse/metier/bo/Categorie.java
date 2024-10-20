package ma.fstm.ilisi.projetcaisse.metier.bo;

public class Categorie 
{
	private int idCategorie;
    private String nomCategorie;
	public Categorie() {
		super();
	}
	public Categorie(int idCategorie, String nomCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
    
    
}
