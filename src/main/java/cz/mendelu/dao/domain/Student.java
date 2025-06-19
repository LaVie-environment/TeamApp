package cz.mendelu.dao.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String personalNumber;
    private String phone;
    private int age;
    @OneToMany(fetch = FetchType.EAGER,
    mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> address;

    public Student(Long id, String name, String surname, String personalNumber, String phone, int age, List<Address> address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
        this.phone = phone;
        this.age = age;

        this.address = address;
    }
    
    public Student(String name) {
        this.name = name;
    }

    public Student() {

    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getId() { return id; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getPersonalNumber() { return personalNumber; }
    public void setPersonalNumber(String personalNumber) { this.personalNumber = personalNumber; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public List<Address> getAddress() { return address; }
    public void setAddress(List<Address> address) { this.address = address; }
    public void setId(Long id) { this.id = id; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public boolean isNull() {
        return false;
    }

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.personalNumber = builder.personalNumber;
        this.phone = builder.phone;
        this.age = builder.age;

        this.address = builder.address;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private String personalNumber;
        private String phone;
        private int age;

        private List<Address> address;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder personalNumber(String personalNumber) {
            this.personalNumber = personalNumber;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(List<Address> address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
