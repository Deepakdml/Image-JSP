package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/ServletCon")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 
		maxFileSize = 1024 * 1024 * 50, 
		maxRequestSize = 1024 * 1024 * 50) 
public class ServletCon extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String connectionURL = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String pass = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(connectionURL, user, pass);

			Part part = request.getPart("file");
			InputStream is = part.getInputStream();

			PreparedStatement ps = con.prepareStatement("insert into images(filename) values(?)");
			ps.setBlob(1, is);

//			request.setAttribute("message", "image uploaded successfully");

//			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

			ps.executeUpdate();

			ps.close();
			con.close();

			response.sendRedirect("index.jsp?message=Image Uploaded Successfully");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
