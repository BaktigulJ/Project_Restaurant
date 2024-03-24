package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
    @SequenceGenerator(name = "category_gen", sequenceName = "category_seq", allocationSize = 1)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = {REMOVE})
    private List<Subcategory> subcategories;

    @ManyToOne(cascade = {DETACH})
    private Restaurant restaurant;

    public void addSubcategory(Subcategory subcategory){
        if(this.subcategories == null) this.subcategories = new ArrayList<>();
        this.subcategories.add(subcategory);
    }
}
