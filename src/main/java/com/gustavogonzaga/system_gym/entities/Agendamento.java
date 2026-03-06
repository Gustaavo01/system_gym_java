package com.gustavogonzaga.system_gym.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Entity
public class Agendamento implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String data;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "agendamento",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Aulas> aulas;


    public Agendamento(){
    }

    public Agendamento(Long id, String data, User user, List<Aulas> aulas) {
        this.id = id;
        this.data = data;
        this.user = user;
        this.aulas = aulas;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        this.aulas = aulas;
    }
}