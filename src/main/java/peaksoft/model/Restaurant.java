package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.RestType;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.MERGE;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_gen")
    @SequenceGenerator(name = "restaurant_gen", sequenceName = "restaurant_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String location;
    @Enumerated(EnumType.STRING)
    private RestType restType;
    private int numberOfEmployees;
    private int service;

    @OneToMany(mappedBy = "restaurant", cascade = {PERSIST, REMOVE, MERGE})
    private List<User> users;

    @OneToMany(mappedBy = "restaurant", cascade = {REMOVE, MERGE})
    private List<MenuItem> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = {REMOVE})
    private List<Employee> employees;

    @OneToMany(cascade = {REMOVE}, mappedBy = "restaurant")
    private List<Category> categories;

    public void addUsers(User user){
        if(this.users == null) this.users = new ArrayList<>();
        this.users.add(user);
    }

    public void addMenuItems(MenuItem menuItem){
        if(this.menuItems == null) this.menuItems = new ArrayList<>();
        this.menuItems.add(menuItem);
    }
    public void addEmployees(Employee employee){
        if(this.employees == null) this.employees = new ArrayList<>();
        this.employees.add(employee);

    }

    public void addCategories(Category category){
        if(this.categories == null) this.categories = new ArrayList<>();
        this.categories.add(category);
    }

}
