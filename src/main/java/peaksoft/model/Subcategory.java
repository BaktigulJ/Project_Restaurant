package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "subcategories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcategory_gen")
    @SequenceGenerator(name = "subcategory_gen", sequenceName = "subcategory_seq", allocationSize = 1)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "subcategory", cascade ={REMOVE})
    private List<MenuItem> menuItems;

    @ManyToOne(cascade ={DETACH})
    private Category category;

    public void addMenuItem(MenuItem menuItem){
       if(this.menuItems == null) this.menuItems = new ArrayList<>();
       this.menuItems.add(menuItem);
    }
}
