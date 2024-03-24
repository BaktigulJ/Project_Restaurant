package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_item_gen")
    @SequenceGenerator(name = "menu_item_gen", sequenceName = "menu_item_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String image;
    private BigDecimal price;
    private String description;
    private String isVegetarian;

    @ManyToMany(cascade = {MERGE,DETACH}, mappedBy = "menuItems")
    private List<Cheque> cheques;

    @ManyToOne(cascade = {DETACH})
    private Restaurant restaurant;

    @OneToOne(cascade = {MERGE,REMOVE}, mappedBy = "menuItem")
    private StopList stopList;

    @ManyToOne(cascade = {DETACH})
    private Subcategory subcategory;

    public void addCheque(Cheque cheque){
        if(this.cheques == null) this.cheques = new ArrayList<>();
        this.cheques.add(cheque);
    }
}
