package com.gustavogonzaga.system_gym.dto;

import jakarta.validation.constraints.NotBlank;

public class AgendamentoDTO {
    private Long id;
    @NotBlank(message = "Data do Agendamento é Obrigatorio")
    private String data;

    public AgendamentoDTO(){

    }

    public AgendamentoDTO(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
