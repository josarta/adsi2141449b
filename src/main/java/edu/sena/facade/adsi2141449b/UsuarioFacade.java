/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.adsi2141449b;

import edu.sena.entity.adsi2141449b.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Josarta
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_adsi2141449b_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario validarUsuario(String correoIn, String claveIn){
        try {
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.usuClave = :claveIn AND u.usuCorreo = :correoIn");
            qt.setParameter("claveIn", claveIn);
            qt.setParameter("correoIn", correoIn);
            return (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error::validarUsuario -> " + e.getMessage());
            return null;
        }
    }
    
    

     @Override
    public boolean crearUsuario(Usuario usuReg){
        try {
            Query q = em.createNativeQuery("INSERT INTO  tbl_usuario (usu_tipo_documento, usu_documento, usu_nombres, usu_apellidos, usu_correo, usu_clave) VALUES (?, ?, ?, ?, ?, ?)");
            q.setParameter(1, usuReg.getUsuTipoDocumento());
            q.setParameter(2, usuReg.getUsuDocumento());
            q.setParameter(3, usuReg.getUsuNombres());
            q.setParameter(4, usuReg.getUsuApellidos());
            q.setParameter(5, usuReg.getUsuCorreo());
            q.setParameter(6, usuReg.getUsuClave());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
              System.out.println("Error::crearUsuario -> " + e.getMessage());
            return false;
        }
    
    }
    
    
    @Override
    public List<Usuario> leertodos(){
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createQuery("SELECT u FROM Usuario u");
            return q.getResultList();
        } catch (Exception e) {
             System.out.println("Error::leertodos -> " + e.getMessage());
            return null;
        }
    }
}
