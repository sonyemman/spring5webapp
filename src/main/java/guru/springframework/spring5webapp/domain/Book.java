package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class Book{

    public Book() {
    }

    public Book(String bookName, String isbnCoode) {
        this.bookName = bookName;
        this.isbnCoode = isbnCoode;
      
    }
    private String bookName; 
    private String isbnCoode; 
   

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name="book_id"), 
        inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
   
    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbnCoode() {
        return this.isbnCoode;
    }

    public void setIsbnCoode(String isbnCoode) {
        this.isbnCoode = isbnCoode;
    }
}