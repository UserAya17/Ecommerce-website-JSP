package ma.fstm.ilisi.projetcaisse.controleur;

import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.util.*;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class CaisseServlet
 */
public class CaisseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaisseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "jee";
        String password = "jee";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(dbURL, username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorie");

            List<String> categories = new ArrayList<>();
            while (rs.next()) 
                categories.add(rs.getString(1));

            request.setAttribute("categories", categories);
            RequestDispatcher rd = request.getRequestDispatcher("categorie.jsp");
            rd.forward(request, response);

            con.close();
        } 
        catch (Exception e) 
        {
            out.println(e);
        }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
