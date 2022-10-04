package br.com.sgsistemas.cadastroclientes.model;

import java.time.LocalDate;

public interface ClienteProjection {
    String getNome();
    LocalDate getDatanasc();
}
