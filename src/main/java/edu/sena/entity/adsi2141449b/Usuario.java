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
@Table(name = "tbl_usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_usuario_id")
    private Integer usuUsuarioId;
    @Size(max = 45)
    @Column(name = "usu_tipo_documento")
    private String usuTipoDocumento;
    @Size(max = 45)
    @Column(name = "usu_documento")
    private String usuDocumento;
    @Size(max = 45)
    @Column(name = "usu_nombres")
    private String usuNombres;
    @Size(max = 45)
    @Column(name = "usu_apellidos")
    private String usuApellidos;
    @Size(max = 45)
    @Column(name = "usu_correo")
    private String usuCorreo;
    @Size(max = 8)
    @Column(name = "usu_clave")
    private String usuClave;
    @Column(name = "usu_estado")
    private Boolean usuEstado;
    @ManyToMany(mappedBy = "usuarioCollection", fetch = FetchType.LAZY)
    private Collection<Rol> rolCollection;

    public Usuario() {
    }

    public Usuario(Integer usuUsuarioId) {
        this.usuUsuarioId = usuUsuarioId;
    }

    public Integer getUsuUsuarioId() {
        return usuUsuarioId;
    }

    public void setUsuUsuarioId(Integer usuUsuarioId) {
        this.usuUsuarioId = usuUsuarioId;
    }

    public String getUsuTipoDocumento() {
        return usuTipoDocumento;
    }

    public void setUsuTipoDocumento(String usuTipoDocumento) {
        this.usuTipoDocumento = usuTipoDocumento;
    }

    public String getUsuDocumento() {
        return usuDocumento;
    }

    public void setUsuDocumento(String usuDocumento) {
        this.usuDocumento = usuDocumento;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Boolean getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuUsuarioId != null ? usuUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuUsuarioId == null && other.usuUsuarioId != null) || (this.usuUsuarioId != null && !this.usuUsuarioId.equals(other.usuUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.adsi2141449b.Usuario[ usuUsuarioId=" + usuUsuarioId + " ]";
    }
    
}
