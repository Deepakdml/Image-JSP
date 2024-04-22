package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayImage")
public class DisplayImage extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String connectionURL = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String pass = "root";
		List<byte[]> imagesList = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(connectionURL, user, pass);

			PreparedStatement ps = con.prepareStatement("select filename from images order by id desc");
			ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                response.setContentType("image/png");
//                OutputStream out = response.getOutputStream();
//                out.write(rs.getBytes("filename"));
//                out.close();
//            }
			while (rs.next()) {
				byte[] imageBytes = rs.getBytes("filename");
				imagesList.add(imageBytes);
			}

			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("imagesList", imagesList);
		request.getRequestDispatcher("display.jsp").forward(request, response);
	}
}
