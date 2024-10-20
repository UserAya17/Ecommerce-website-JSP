package ma.fstm.ilisi.projetcaisse.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstm.ilisi.projetcaisse.metier.bo.Produit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ProduitsServlet
 */
public class ProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
        List<Produit> produits = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "caisse", "123");

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM article WHERE CAT_ID = ?");

            stmt.setInt(1, idCategorie);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) 
            {
                Produit produit = new Produit();
                produit.setIdProd(rs.getInt("IDPROD"));
                produit.setDesignation(rs.getString("DESIGNATION"));
                produit.setIdCategorie(rs.getInt("IDCATEGORIE"));
                produits.add(produit);
                System.out.println("Produit " +produit.getDesignation());
            }

            rs.close();
            stmt.close();
            conn.close();
        } 
        catch(ClassNotFoundException e1)
        {
            System.err.println("chargement de driver échoué");
        }
        catch(SQLException e2)
        {
            System.err.println("Vous n'est pas bien connecte a la base");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        if (!produits.isEmpty()) 
        {
            request.setAttribute("produits", produits);
        }

        request.getRequestDispatcher("/produits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
