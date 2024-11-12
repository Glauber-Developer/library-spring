package glauber.ex1_biblioteca.Infrastructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import glauber.ex1_biblioteca.Domain.Entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAutor(String autor);
    List<Book> findByTitulo(String titulo);
    List<Book> findByAno(int ano);
    Book findById(int id);
}
