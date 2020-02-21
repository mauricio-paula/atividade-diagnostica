package com.pessoal.atividade.diagnostico.ponto.model;

import lombok.Data;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Data
@Entity
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime dataHoraRegistro;

    @Enumerated(EnumType.STRING)
    private TipoRegistro tipoRegistro;

    protected  RegistroPonto(){
    }

    public RegistroPonto(Long id, LocalDateTime dataHoraRegistro, Usuario usuario, TipoRegistro tipoRegistro){
        this.id = id;
        this.dataHoraRegistro = dataHoraRegistro;
        this.usuario = usuario;
        this.tipoRegistro = tipoRegistro;
    }

    public boolean entrada() {
        return this.tipoRegistro.equals(TipoRegistro.ENTRADA);
    }

    public boolean saida() {
        return this.tipoRegistro.equals(TipoRegistro.SAIDA);
    }

    public static class Builder {

        private Long id;

        private LocalDateTime dataHoraRegistro;

        private Usuario usuario;

        private TipoRegistro tipo;

        public Builder(Long id) {
            this.id = id;
        }

        public Builder comUsuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder comTipoRegistro(TipoRegistro tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder comHora(LocalDateTime dataHora) {
            this.dataHoraRegistro = dataHora;
            return this;
        }

        public RegistroPonto build() {
            return new RegistroPonto(this.id, this.dataHoraRegistro, this.usuario, this.tipo);
        }
    }
}
