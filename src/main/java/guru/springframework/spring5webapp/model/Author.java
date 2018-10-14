package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public final class Author
{
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    private String firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastName;

    public Author()
    {
        books = new HashSet<>();
    }

    public Author(final String firstName, final String lastName)
    {
        this();

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(final String firstName, final String lastName, final Set<Book> books)
    {
        this(firstName, lastName);

        this.books = books;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if( this == obj )
        {
            return true;
        }

        if( obj == null || getClass() != obj.getClass() )
        {
            return false;
        }

        final Author otherAuthor = (Author)obj;
        if( id == null )
        {
            return otherAuthor.id == null;
        }

        return id.equals(otherAuthor.id);
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public Long getId()
    {
        return id;
    }

    public String getLastName()
    {
        return lastName;
    }

    @Override
    public int hashCode()
    {
        if( id == null )
        {
            return 0;
        }

        return id.hashCode();
    }

    public void setBooks(final Set<Book> books)
    {
        this.books = books;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return "Author [books=" + books + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }
}