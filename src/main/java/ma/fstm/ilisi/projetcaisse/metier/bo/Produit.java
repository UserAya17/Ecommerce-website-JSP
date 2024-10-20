package ma.fstm.ilisi.projetcaisse.metier.bo;

public class Produit 
{
	private int idProd;
    private String designation;
    private int idCategorie;
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public Produit(int idProd, String designation, int idCategorie) {
		super();
		this.idProd = idProd;
		this.designation = designation;
		this.idCategorie = idCategorie;
	}
	public Produit() {
		super();
	}
    
    
}
