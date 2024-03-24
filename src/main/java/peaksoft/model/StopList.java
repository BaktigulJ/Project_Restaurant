package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "stop_lists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StopList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stop_list_gen")
    @SequenceGenerator(name = "stop_list_gen", sequenceName = "stop_list_seq", allocationSize = 1)
    private Long id;
    private String reason;
    private ZonedDateTime date;

    @OneToOne(cascade = {MERGE, DETACH})
    private MenuItem menuItem;

    @PrePersist
    private void prePersist() {
        this.date = ZonedDateTime.now();
    }
}

