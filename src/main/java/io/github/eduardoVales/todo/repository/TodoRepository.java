package io.github.eduardoVales.todo.repository;

import io.github.eduardoVales.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
