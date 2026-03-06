package com.gustavogonzaga.system_gym.dto;

import jakarta.validation.constraints.NotBlank;

public class AulaDTO {
    private Long id;
    @NotBlank(message = "Nome da Aula É obrigatorio")
    private String aulas;
    @NotBlank(message = "Tipo funcional é Obrigatorio")
    private String funcional;

    public AulaDTO(){

    }
    public AulaDTO(Long id, String aulas, String funcional) {
        this.id = id;
        this.aulas = aulas;
        this.funcional = funcional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAulas() {
        return aulas;
    }

    public void setAulas(String aulas) {
        this.aulas = aulas;
    }

    public String getFuncional() {
        return funcional;
    }

    public void setFuncional(String funcional) {
        this.funcional = funcional;
    }
}
