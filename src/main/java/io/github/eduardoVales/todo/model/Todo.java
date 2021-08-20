package io.github.eduardoVales.todo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity //representar uma tabela do banco de dados
public class Todo {
   //ENTIDADE ABAIXO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //definir que essa coluna é autoincremento
    private Long id;

    @Column
    private String description;

    @Column
    private Boolean done;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdDate;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime doneDate;

    @PrePersist
    public void beforeSave(){
      setCreatedDate(LocalDateTime.now());
    }

}
