/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suricata.argos.constantes.Constantes;
import com.suricata.argos.vo.UsuarioVo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Valentina
 */
public abstract class ArgosAction extends ActionSupport implements SessionAware  {
    private Map session;
    private Map myFieldErrors;
    private Collection myActionErrors;
    private  UsuarioVo usuarioVo;

    public ArgosAction()
    {
        setFieldErrors(new LinkedHashMap<String, List<String>>());
        setActionErrors(new ArrayList<String>());
    }


        public void setSession(Map session)
	{
		this.session = session;
	}

	public Map getSession()
	{
		return session;
	}

        public Map getFieldErrors()
	{
		return myFieldErrors;
	}

	public void setActionErrors(Collection<String> errors)
	{
		myActionErrors = errors;
		super.setActionErrors(errors);
	}

	public Collection<String> getActionErrors()
	{
		return myActionErrors;
	}

	public void setFieldErrors(Map map)
	{
		myFieldErrors = map;
		super.setFieldErrors(map);
	}

    public UsuarioVo getUsuarioVo() {
        usuarioVo = (UsuarioVo) this.getSession().get(Constantes.SESSION_USUARIO);
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }


}
