/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.adsi2141449b;

import edu.sena.entity.adsi2141449b.Usuario;
import edu.sena.facade.adsi2141449b.UsuarioFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Josarta
 */
@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String correoIn = "";
    private String claveIn = "";
    private String mensajes = "";
    private Usuario usuLogin = new Usuario();
    private Usuario usuReg = new Usuario();

    public UsuarioSession() {
    }

    public void cerrarSession() throws IOException {
        usuLogin = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().redirect("../index.xhtml");

    }

    public void ingresarUsuario() {
        if (usuarioFacadeLocal.crearUsuario(usuReg)) {
            mensajes = "usuOk";
            System.out.println("Usuario - Creado");
        } else {
            mensajes = "usuErr";
            System.out.println("Error - Creando usuario");
        }

    }

    public void validarUsuario() throws IOException {
        usuLogin = usuarioFacadeLocal.validarUsuario(correoIn, claveIn);

        if (usuLogin == null) {
            mensajes = "ErVal";
            System.out.println("Error - Validacion");
        } else {
            if (usuLogin.getUsuEstado()) {
                System.out.println("Usuario - ok");
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("usuario/index.xhtml");
            } else {
                System.out.println("Usuario - bloqueado");
                mensajes = "ErBloq";
            }
        }

    }

    public String getCorreoIn() {
        return correoIn;
    }

    public void setCorreoIn(String correoIn) {
        this.correoIn = correoIn;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

}
