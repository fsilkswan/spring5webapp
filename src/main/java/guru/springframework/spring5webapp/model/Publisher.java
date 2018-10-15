package guru.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class Publisher
{
    private String addressLineOne;
    private String city;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String state;
    private int    zipCode;

    public Publisher(final String name, final String addressLineOne, final int zipCode, final String city, final String state)
    {
        this.name = name;
        this.addressLineOne = addressLineOne;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public String getAddressLineOne()
    {
        return addressLineOne;
    }

    public String getCity()
    {
        return city;
    }

    public String getName()
    {
        return name;
    }

    public String getState()
    {
        return state;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setAddressLineOne(final String addressLineOne)
    {
        this.addressLineOne = addressLineOne;
    }

    public void setCity(final String city)
    {
        this.city = city;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setState(final String state)
    {
        this.state = state;
    }

    public void setZipCode(final int zipCode)
    {
        this.zipCode = zipCode;
    }
}