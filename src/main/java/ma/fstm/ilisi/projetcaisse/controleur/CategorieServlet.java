package ma.fstm.ilisi.projetcaisse.controleur;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstm.ilisi.projetcaisse.metier.bo.Categorie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CategorieServlet
 */
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public static Connection getCon()
    {  
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","caisse","123");
        }
        catch(ClassNotFoundException e1)
        {
            System.err.println("chargement de driver échoué");
            return null;
        }
        catch(SQLException e2)
        {
            System.err.println("Vous n'est pas bien connecte a la base");
            return null;
        }
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Categorie> categories = new ArrayList<>();

        try {
        	
            Statement stmt = getCon().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM categorie");
            
            //System.out.println("Nombre de lignes dans le ResultSet : " + rs.getFetchSize());
            while (rs.next()) 
            {
                Categorie categorie = new Categorie();
                categorie.setIdCategorie(rs.getInt("IDCATEGORIE"));
                categorie.setNomCategorie(rs.getString("NOMCATEGORIE"));
                categories.add(categorie);
                System.out.println("Catégorie ajoutée : " + categorie.getIdCategorie() + " - " + categorie.getNomCategorie());
            }

            rs.close();
            stmt.close();
            
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/categorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
