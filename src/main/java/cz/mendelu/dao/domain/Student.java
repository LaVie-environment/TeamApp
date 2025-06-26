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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_role_assignments",
        joinColumns = @JoinColumn(name = "studentId"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    // === Constructors ===
    public Student() {
    }

    public Student(Long id, String name, String surname, String personalNumber, String phone, int age, List<Address> address, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.roles = roles;
    }

    public Student(String name) {
        this.name = name;
    }

    // === Getters & Setters ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

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

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }

    public boolean isNull() {
        return false;
    }

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
            ", roles=" + roles +
            '}';
    }

    // === Builder pattern ===
    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.personalNumber = builder.personalNumber;
        this.phone = builder.phone;
        this.age = builder.age;
        this.address = builder.address;
        this.roles = builder.roles;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private String personalNumber;
        private String phone;
        private int age;
        private List<Address> address;
        private List<Role> roles;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder id(Long id) { this.id = id; return this; }
        public Builder personalNumber(String personalNumber) { this.personalNumber = personalNumber; return this; }
        public Builder phone(String phone) { this.phone = phone; return this; }
        public Builder age(int age) { this.age = age; return this; }
        public Builder address(List<Address> address) { this.address = address; return this; }
        public Builder roles(List<Role> roles) { this.roles = roles; return this; }

        public Student build() {
            return new Student(this);
        }
    }
}
