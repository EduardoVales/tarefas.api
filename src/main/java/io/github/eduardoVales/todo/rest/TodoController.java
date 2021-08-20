package io.github.eduardoVales.todo.rest;

import io.github.eduardoVales.todo.model.Todo;
import io.github.eduardoVales.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController  //FAZ COM QUE A CLASSE SEJA UM COMPONENTE DO SPRING
@RequestMapping("/api/todos") //MAPEAR URL QUE SERÁ FEITA AS REQUISIÇÕES
@CrossOrigin("http://localhost:4200/") //RECEBER REQUISIÇÕES DO DOMINIO :4200
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @PostMapping //operação de salvar
    public Todo save(@RequestBody Todo todo){
        return  repository.save(todo);
    }

    @GetMapping
    public List<Todo> getAll(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }


    @PatchMapping("{id}/done")
    public  Todo markAsDone(@PathVariable Long id){
        return repository.findById(id).map(todo ->{
            todo.setDone(true);
            todo.setDoneDate(LocalDateTime.now());
            repository.save(todo);
            return todo;
        }).orElse(null);
    }

}
