/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cajuinabits.gerenciaaplifinanc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Entity

public class Acoes implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AcoesPK acoesPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sigla")
    private String sigla;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Tipo")
    private String tipo;
    
    @JoinColumn(name = "idCotacoes", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cotacoes cotacoes;

    public Acoes() {
    }

    public Acoes(AcoesPK acoesPK) {
        this.acoesPK = acoesPK;
    }

    public Acoes(AcoesPK acoesPK, String sigla, String descricao, String tipo) {
        this.acoesPK = acoesPK;
        this.sigla = sigla;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Acoes(long id, long idCotacoes) {
        this.acoesPK = new AcoesPK(id, idCotacoes);
    }

    public AcoesPK getAcoesPK() {
        return acoesPK;
    }

    public void setAcoesPK(AcoesPK acoesPK) {
        this.acoesPK = acoesPK;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cotacoes getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(Cotacoes cotacoes) {
        this.cotacoes = cotacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acoesPK != null ? acoesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acoes)) {
            return false;
        }
        Acoes other = (Acoes) object;
        if ((this.acoesPK == null && other.acoesPK != null) || (this.acoesPK != null && !this.acoesPK.equals(other.acoesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.cajuinabits.gerenciaaplifinanc.Acoes[ acoesPK=" + acoesPK + " ]";
    }
    
}
