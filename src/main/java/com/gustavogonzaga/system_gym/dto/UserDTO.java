package com.gustavogonzaga.system_gym.dto;

import com.gustavogonzaga.system_gym.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    private Long id;
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    public UserDTO(){

    }

    public UserDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UserDTO(User user) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
