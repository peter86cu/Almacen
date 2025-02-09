package com.ayalait.stock.dto;

public class RespuestaDTO {
    private int idPregunta;
    private String idUsuarioRespuesta;
    private String respuesta;

    // Getters y setters
    public int getIdPregunta() {
        return idPregunta;
    }
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public String getIdUsuarioRespuesta() {
        return idUsuarioRespuesta;
    }
    public void setIdUsuarioRespuesta(String idUsuarioRespuesta) {
        this.idUsuarioRespuesta = idUsuarioRespuesta;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
