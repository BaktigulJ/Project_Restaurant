package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "cheques")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cheque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cheque_gen")
    @SequenceGenerator(name = "cheque_gen", sequenceName = "cheque_seq", allocationSize = 1)
    private Long id;
    private BigDecimal priceAverage;
    private ZonedDateTime createdAt;

    @ManyToOne(cascade = {DETACH})
    private User user;

    @ManyToMany(cascade = {MERGE, DETACH})
    private List<MenuItem> menuItems = new ArrayList<>();

    @PrePersist
    private void prePersist(){
        this.createdAt= ZonedDateTime.now();
    }

    public void addMenuItem(MenuItem menuItem){
        if(this.menuItems == null) this.menuItems = new ArrayList<>();
        this.menuItems.add(menuItem);
    }
}
