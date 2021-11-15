/**  
 * @Title:  UsuarioServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:57:46 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Usuario;
import co.edu.usbcali.viajesusb.dto.UsuarioDTO;
import co.edu.usbcali.viajesusb.repository.UsuarioRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: UsuarioServiceImpl
 * @Description: Implementación del servicio para Usuario
 * @author: Reyes98
 * @date: 19/09/2021 9:57:46 a. m.
 * @Copyright: USB
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * <p>
	 * Title: findByLogin
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param login
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#findByLogin(java.lang.String)
	 */
	@Override
	public List<Usuario> findByLogin(String login) throws SQLException, Exception {
		// Verificando contenido
		if (login == null || login.trim().equals("")) {
			throw new Exception("El login está vacio!");
		}

		return usuarioRepository.findByLogin(login);
	}

	/**
	 * <p>
	 * Title: findByLoginAndPassword
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#findByLoginAndPassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Usuario findByLoginAndPassword(String login, String password) throws SQLException, Exception {
		// Verificando contenido
		if (login == null || login.trim() == "") {
			throw new Exception("El login está vacio!");
		}

		if (password == null || password.trim() == "") {
			throw new Exception("La contraseña está vacio!");
		}
		String loginUpper = login.toUpperCase();

		if (usuarioRepository.findByLogin(loginUpper).isEmpty()) {
			throw new Exception("El  usuario con login: " + login + " no existe");
		}

		Usuario usuario = usuarioRepository.findByLoginAndPassword(loginUpper, password);
		if (usuario == null) {
			throw new Exception("Contraseña incorrecta!");
		}
		return usuario;
	}

	/**
	 * <p>
	 * Title: findByIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param identificacion
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#findByIdentificacion(java.lang.String)
	 */
	@Override
	public List<Usuario> findByIdentificacion(String identificacion) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Title: findByNombreLikeIgnoreCase
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#findByNombreLikeIgnoreCase(java.lang.String)
	 */
	@Override
	public List<Usuario> findByNombreLikeIgnoreCase(String nombre) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Title: guardarUsuario
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param usuarioDTO
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#guardarUsuario(co.edu.usbcali.viajesusb.dto.UsuarioDTO)
	 */
	@Override
	public Usuario guardarUsuario(UsuarioDTO usuarioDTO) throws SQLException, Exception {
		Usuario usuario = null;

		// Se valida que el usuario tenga un login
		if (usuarioDTO.getLogin() == null || usuarioDTO.getLogin().trim().equals("")) {
			throw new Exception("Debe ingresar un login de usuario!");
		}

		// Se valida que el login tenga máximo 10 caracteres
		if (usuarioDTO.getLogin().length() > 10) {
			throw new Exception("Debe ingresar un login de maximo de 10 caracteres");
		}

		// Se valida que el usuario tenga el password
		if (usuarioDTO.getPassword() == null || usuarioDTO.getPassword().equals("")) {
			throw new Exception("Debe ingresar una contraseña!");
		}

		// Se valida que el contraseña tenga máximo al menos 8 caracteres
		if (!usuarioDTO.getPassword().matches(Constantes.PATRON_PASSWORD)) {
			throw new Exception("La contraseña debe contener:\r\n"
					+ "* Al menos 8 caracteres\r\n"
					+ "* Al menos un dígito\r\n"
					+ "* Al menos un carácter alfa inferior y un carácter alfa superior\r\n"
					+ "* Sin espacio, tabulador, etc.");
		}

		// Se consulta si existe un usuario con el login ingresado
		if (!findByLogin(usuarioDTO.getLogin().toUpperCase()).isEmpty()) {
			throw new Exception("El usuario con login " + usuarioDTO.getLogin() + " ya existe");
		}

		// Se valida que se ingrese el nombre
		if (usuarioDTO.getNombre() == null || usuarioDTO.getNombre().trim().equals("")) {
			throw new Exception("Debe ingresar un nombre de usuario");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (usuarioDTO.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// validando contenido
		if (usuarioDTO.getIdentificacion() == null || usuarioDTO.getIdentificacion().trim().equals("")) {
			throw new Exception("El numero de identificación está vacío!");
		}
		// validando patrón de la identificacion
		if (!usuarioDTO.getIdentificacion().trim().matches(Constantes.PATRON_NUMERO_IDENTIFICACION)) {
			throw new Exception("El número de identificación debe ser solo números, ej: 110280985");
		}

		// Se valida que se ingrese un usuario creador
		if (usuarioDTO.getUsuCreador() == null || usuarioDTO.getUsuCreador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (usuarioDTO.getUsuCreador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Verificando estado
		if (!(usuarioDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| usuarioDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}
		usuario = new Usuario();

		usuario.setLogin(usuarioDTO.getLogin().toUpperCase());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setIdentificacion(usuarioDTO.getIdentificacion());
		usuario.setEstado(usuarioDTO.getEstado());

		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setUsuCreador(usuarioDTO.getUsuCreador());

		usuarioRepository.save(usuario);

		return usuario;
	}

	/**
	 * <p>
	 * Title: actualizarUsuario
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param usuarioDTO
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#actualizarUsuario(co.edu.usbcali.viajesusb.dto.UsuarioDTO)
	 */
	@Override
	public Usuario actualizarUsuario(UsuarioDTO usuarioDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Title: eliminarUsuario
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param idUsua
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#eliminarUsuario(java.lang.Long)
	 */
	@Override
	public void eliminarUsuario(Long idUsua) throws SQLException, Exception {
		if (idUsua == null) {
			throw new Exception("El id del usuario está vacío");
		}

		Optional<Usuario> usuarioBD = usuarioRepository.findById(idUsua);

		if (usuarioBD.isPresent()) {
			usuarioRepository.delete(usuarioBD.get());
		} else {
			throw new SQLException("El usuario " +idUsua + " no existe!");
		}

	}

	/**
	 * <p>
	 * Title: findById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.UsuarioService#findById(java.lang.Long)
	 */
	@Override
	public Usuario findById(Long id) throws SQLException, Exception {
		// Verificando contenido
		if (id == null) {
			throw new Exception("El id está vacio!");
		}

		if (!usuarioRepository.findById(id).isPresent()) {
			throw new Exception("El  usuario con id: " + id + " no existe");
		}
		return usuarioRepository.findById(id).get();
	}

}
