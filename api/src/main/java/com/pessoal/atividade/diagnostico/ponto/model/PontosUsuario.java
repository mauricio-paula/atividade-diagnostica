package com.pessoal.atividade.diagnostico.ponto.model;

import org.joda.time.Duration;
import org.joda.time.LocalTime;
import org.joda.time.Period;

import java.util.List;

public class PontosUsuario {
    private final List<RegistroPonto> registroPontos;

    private String totalHoras;

    public PontosUsuario(List<RegistroPonto> registroPontos, LocalTime agora) {
        this.registroPontos = registroPontos;
        this.horasTrabalhadas(agora);
    }

    public List<RegistroPonto> getRegistros() {
        return registroPontos;
    }

    private boolean maisRegistros(int index) {
        return index+1 < registroPontos.size();
    }

    public String totalHoras() {
        return totalHoras;
    }

    private void horasTrabalhadas(LocalTime agora) {
        Period tempo = Period.ZERO;
        for (int index = 0; index < registroPontos.size(); index++) {
            RegistroPonto ponto = registroPontos.get(index);
            if (ponto.entrada()) {
                if (maisRegistros(index)) {
                    RegistroPonto proximoPonto = registroPontos.get(index + 1);
                    if (proximoPonto.saida()) {
                        tempo = new Period(ponto.getDataHoraRegistro(),
                                proximoPonto.getDataHoraRegistro());
                    }
                } else {
                    tempo = new Period(ponto.getDataHoraRegistro(), agora);
                }
            }
        }

        long segundos = tempo.getSeconds();
        this.totalHoras = String.format("%d:%02d:%02d", segundos / 3600, (segundos % 3600) / 60, (segundos % 60));
    }
}
