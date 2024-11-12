package glauber.ex1_biblioteca.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import glauber.ex1_biblioteca.Domain.Entity.Book;
import glauber.ex1_biblioteca.app.Service.LibraryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/biblioteca")
public class LibraryController {
    
        @Autowired
        private LibraryService libraryService;
        
    
        @GetMapping("/")
        public String mensagemBiblioteca() {
            return "Bem vindo a nossa biblioteca!";
        }
    
        @GetMapping("/books")
        public List<Book> getLivros() {
            return libraryService.getLivros();
        }
    
        @GetMapping("/books/{id}")
        public Book getLivro(@PathVariable int id) {
            return libraryService.getLivro(id);
        }
    
        @GetMapping("/books/livrosautor/{autor}")
        public List<Book> getLivrosPorAutor(@PathVariable String autor) {
            return libraryService.getLivrosPorAutor(autor);
        }
    
        @GetMapping("/books/titulo/{titulo}")
        public List<Book> getLivrosPorTitulo(@PathVariable String titulo) {
            return libraryService.getLivrosPorTitulo(titulo);
        }
    
        @GetMapping("/books/ano/{ano}")
        public List<Book> getAno(@PathVariable int ano) {
            return libraryService.getAno(ano);
        }
    
        @PostMapping("/newbook")
        public boolean addLivro(@RequestBody final Book book) {
            libraryService.addLivro(book);
            return true;
        }
        
}
