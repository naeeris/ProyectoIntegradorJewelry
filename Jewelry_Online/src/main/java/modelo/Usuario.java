package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoUsuarios;

public class Usuario {
	
	//Declaro las variables de la clase Usuario
	private int id_usuario; //Esto no aparece en el form pero en la BBDD si, lo asigna la BBDD
	private int permiso_usuario;
	private String nombre;
	private String apellidos;
	private String domicilio;
	private int cod_postal;
	private String pais;
	private String email;
	private int telefono;
	private String contrasenya; //Esto en la vida real no es así
	
	
	/**
	 * Constructor por defecto para generar un objeto vacío de tipo usuario.
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor con todos los atributos del objeto para poder extraer los datos de la base de datos.
	 * @param id_usuario
	 * @param permiso_usuario
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param cod_postal
	 * @param pais
	 * @param email
	 * @param telefono
	 * @param contrasenya
	 */
	public Usuario(int id_usuario, int permiso_usuario, String nombre, String apellidos, String domicilio, int cod_postal, String pais, String email, int telefono, String contrasenya) {
		
		this.id_usuario = id_usuario;
		this.permiso_usuario = permiso_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.cod_postal = cod_postal;
		this.pais = pais;
		this.email = email;
		this.telefono = telefono;
		this.contrasenya = contrasenya;
	}
	
	/**
	 * Constructor sin id_usuario y permiso_usuario para generar el objeto desde un formulario de html.
	 * @param nombre Atributo solo texto...
	 * @param apellidos 
	 * @param domicilio
	 * @param cod_postal
	 * @param pais
	 * @param email
	 * @param telefono
	 * @param contrasenya
	 */
	public Usuario(String nombre, String apellidos, String domicilio, int cod_postal, String pais, String email, int telefono, String contrasenya) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.cod_postal = cod_postal;
		this.pais = pais;
		this.email = email;
		this.telefono = telefono;
		this.contrasenya = contrasenya;
	}
	
	//Creo un método para que me llame a la inserción de datos del DAO
	/**
	 * Método para llamar a la inserción de datos de DaoUsuarios.
	 * @throws SQLException
	 */
	public void insertarUsuario () throws SQLException {
		/*
		//Esto se utiliza en lugar de utilizar el patrón Singelton, pero no sería lo correcto pero es funcional
		 DaoUsuarios dao = new DaoUsuarios();
		 dao.insertarUsuario(this);
		 */
		
		
		//Aplicamos el patrón Singleton
		DaoUsuarios.getInstance().insertarUsuario(this);
		
	}
	
	/**
	 * Método para modificar los datos de usuario.
	 * @param id_usuario
	 * @throws SQLException
	 */
	public void modificarUsuario (int id_usuario) throws SQLException {
		
		DaoUsuarios.getInstance().obtenerUsuario(id_usuario);
		
		this.setId_usuario(id_usuario);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setDomicilio(domicilio);
		this.setCod_postal(id_usuario);
		this.setPais(pais);
		this.setEmail(email);
		this.setTelefono(id_usuario);
		
	}
	
	public String devuelveJson() {
		
		String txtJson = "";
		
		Gson gson = new Gson();
		
		txtJson = gson.toJson(this);
		
		return txtJson;
	}
	
	
	
	//GETTERS Y SETTERS
	
	/**
	 * Método de inclusión del id_usuario en el objeto.
	 * @return Retorna el id_usuario en tipo entero.
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * 
	 * @param id_usuario
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getPermiso_usuario() {
		return permiso_usuario;
	}

	public void setPermiso_usuario(int permiso_usuario) {
		this.permiso_usuario = permiso_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", permiso_usuario=" + permiso_usuario + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", domicilio=" + domicilio + ", cod_postal=" + cod_postal + ", pais="
				+ pais + ", email=" + email + ", telefono=" + telefono + ", contrasenya=" + contrasenya + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
