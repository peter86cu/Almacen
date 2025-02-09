package com.ayalait.stock.dto;

public class PreguntaDTO {
    private String idProducto;
    private String idUsuarioPregunta;
    private String pregunta;

    // Getters y setters
    public String getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    public String getIdUsuarioPregunta() {
        return idUsuarioPregunta;
    }
    public void setIdUsuarioPregunta(String idUsuarioPregunta) {
        this.idUsuarioPregunta = idUsuarioPregunta;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}

