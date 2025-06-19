package cz.mendelu.dao.domain;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String postcode;
    private String city;
    private String country;

    @ManyToOne
    //@JoinColumn(name="student_id")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private Address(Builder builder) {
        this.street = builder.street;
        this.postcode = builder.postcode;
        this.city = builder.city;
        this.country = builder.country;
    }

    public Address() {

    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getStreet() { return street; }
    public String getPostcode() { return postcode; }
    public String getCity() { return city; }
    public String getCountry() { return country; }

    public void setStreet(String street) { this.street = street; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setCity(String city) { this.city = city; }
    public void setCountry(String country) { this.country = country; }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static class Builder {
        private String street;
        private String postcode;
        private String city;
        private String country;

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
