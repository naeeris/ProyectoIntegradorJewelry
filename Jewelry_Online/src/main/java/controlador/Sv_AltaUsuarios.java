package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Servlet implementation class Sv_AltaUsuarios
 */
public class Sv_AltaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sv_AltaUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String domicilio = request.getParameter("domicilio");
		int cod_postal = Integer.parseInt(request.getParameter("cod_postal"));
		String pais = request.getParameter("pais");
		String email = request.getParameter("email");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String contrasenya = myMD5(request.getParameter("contrasenya"));
		
		System.out.println("El nombre del usuario es: " + nombre);
		
		//Creo un objeto Usuario para poder insertar todos los datos
		
		Usuario registro_usuario = new Usuario(nombre, apellidos, domicilio, cod_postal, pais, email, telefono, contrasenya);
		
		System.out.println(registro_usuario.toString());
		
		try {
			registro_usuario.insertarUsuario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al insertar.");
		}
		
		response.sendRedirect("index.html");
		
		/*
			//Esto sirve para que nos salgan los datos insertados por el usuario en el explorador
			PrintWriter respuesta = response.getWriter();
			respuesta.print(registro_usuario.toString());
		
		*/
		
	}
	
	public static String myMD5(String contrasenya) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(contrasenya.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
