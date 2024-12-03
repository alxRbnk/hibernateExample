package org.rbnk.dealership.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@NamedEntityGraph(
        name = "Car.withShowroom",
        attributeNodes = @NamedAttributeNode("carShowroom")
)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "production_year")
    private LocalDate productionYear;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "show_room_id")
    private CarShowroom carShowroom;

    @ManyToMany(mappedBy = "cars")
    private List<Client> clients;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Review> review;
}
