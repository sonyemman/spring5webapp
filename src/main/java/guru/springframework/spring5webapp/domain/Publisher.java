package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Publisher {

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Publisher)) {
            return false;
        }
        Publisher publisher = (Publisher) o;
        return Objects.equals(pubName, publisher.pubName) && Objects.equals(state, publisher.state) && Objects.equals(city, publisher.city) && Objects.equals(books, publisher.books) && Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pubName, state, city, books, id);
    }

    public Publisher() {
    }



    private String pubName;
    private String state; 
    private String city; 

    public String getPubName() {
        return this.pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Publisher(String pubName, String state, String city, Set<Book> books, Long id) {
        this.pubName = pubName;
        this.state = state;
        this.city = city;
        this.books = books;
        this.id = id;
    }

    
   

    @ManyToMany(mappedBy = "publishers")
    private Set<Book> books = new HashSet<>();



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   
   
}
