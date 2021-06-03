/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.adsi2141449b;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Josarta
 */
@Entity
@Table(name = "tbl_roles")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_rol_id")
    private Integer rolRolId;
    @Size(max = 45)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Size(max = 45)
    @Column(name = "rol_descripcion")
    private String rolDescripcion;
    @JoinTable(name = "tbl_usuario_has_roles", joinColumns = {
        @JoinColumn(name = "fk_rol_rol_id", referencedColumnName = "rol_rol_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_usu_ususario_id", referencedColumnName = "usu_usuario_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;

    public Rol() {
    }

    public Rol(Integer rolRolId) {
        this.rolRolId = rolRolId;
    }

    public Integer getRolRolId() {
        return rolRolId;
    }

    public void setRolRolId(Integer rolRolId) {
        this.rolRolId = rolRolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolRolId != null ? rolRolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolRolId == null && other.rolRolId != null) || (this.rolRolId != null && !this.rolRolId.equals(other.rolRolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.adsi2141449b.Rol[ rolRolId=" + rolRolId + " ]";
    }
    
}
