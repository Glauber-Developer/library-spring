package glauber.ex1_biblioteca.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import glauber.ex1_biblioteca.Domain.Entity.Book;
import glauber.ex1_biblioteca.Infrastructure.Repository.BookRepository;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    public String mensagemBiblioteca() {
        return "Bem vindo a nossa biblioteca!";
    }

    public List<Book> getLivros() {
        return bookRepository.findAll();
    }

    public Book getLivro(int id) {
        return bookRepository.findById(id);
    }

    public List<Book> getLivrosPorAutor(String autor) {
        return bookRepository.findByAutor(autor);
    }

    public List<Book> getLivrosPorTitulo(String titulo) {
        return bookRepository.findByTitulo(titulo);
    }

    public List<Book> getAno(int ano) {
        return bookRepository.findByAno(ano);
    }

    public boolean addLivro(Book book) {
        bookRepository.save(book);
        return true;
    }
}
