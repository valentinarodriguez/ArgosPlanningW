package com.suricata.argos.logica;

import com.suricata.argos.exception.ArgosWebServiceException;
import com.suricata.argos.exception.FaltanDatosException;
import com.suricata.argos.vo.UsuarioVo;
import java.util.List;

/**
 * Realiza las validaciones de negocio e invoca a la capa DAO para poder acceder a
 * la base de datos relacionado con el modulo de seguridad, pero m�s precisamente
 * con los usuarios del sistema.
 * @version 1.0
 * @created 16-Jun-2010 01:17:47
 */
public interface UsuarioManager {

	/**
	 * Retorna un usuario a trav�s de un id elegido.
	 * 
	 * @param idUsuario
	 */
	 UsuarioVo buscarUsuario(Integer idUsuario) throws ArgosWebServiceException;

	/**
	 * Crea un nuevo usuario en el sistema. Antes debo verificar que no exista un
	 * mismo usuario con el mismo username en un estado !=Cancelado.
	 * 
	 * @param usuarioVO
	 */
	 void crearUsuario(UsuarioVo usuario) throws ArgosWebServiceException, FaltanDatosException ;

	/**
	 * Se listan los usuarios del sistema mediante criterios de b�squeda.
	 * 
	 * @param criterioBusqueda
	 */
	 List<UsuarioVo> listarUsuarios() throws ArgosWebServiceException;

	/**
	 * Se modifican los datos del usuario puede modificarse el estado. No se puede
	 * modificar el nombre del usuario y as� tampoco no el tipo de usuario. Antes de
	 * grabar debo verificar que no exista un mismo usuario con el mismo username en
	 * un estado !=Cancelado.
	 * 
	 * @param usuarioVO
	 */
	 void modificarUsuario(UsuarioVo usuario) throws ArgosWebServiceException, FaltanDatosException;

	/**
	 * Es el m�todo encargado de realizar todo el proceso de login. Este m�todo
	 * utilizar� los m�todos: autenticar y validar usuario. El usuario deber� tener al
	 * menos una empresa activa y un permiso activo.
	 * 
	 * @param userName
	 * @param password
	 */
	//public UsuarioSessionVo validarUsuarioLogin(String userName, String password);

         UsuarioVo buscarUsuario(String nombre, String contrasena) throws ArgosWebServiceException, FaltanDatosException;

}