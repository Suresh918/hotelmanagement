package com.booking.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@DynamicUpdate
// @EntityListeners(AuditingEntityListener.class)
// @ServiceClass(ChangeRequestService.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@SpELEvaluationContext(ChangeRequestEvaluationContext.class)
@Getter
@Setter
//@AbacScan({ChangeRequestMyTeam.class})
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "address_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;


    private String business;

    @Column(nullable = false)
    @NotEmpty(message = "required")
    @NotNull(message = "required")
    private String streetLine1;

    private String streetLine2;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(nullable = false)
    private String suburb;

    @Column(nullable = false)
    @Embedded
    @Valid
    private Postcode postcode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(business, address.business) &&
                Objects.equals(streetLine1, address.streetLine1) &&
                Objects.equals(streetLine2, address.streetLine2) &&
                state == address.state &&
                Objects.equals(suburb, address.suburb) &&
                Objects.equals(postcode, address.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(business, streetLine1, streetLine2, state, suburb, postcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "business='" + business + '\'' +
                ", streetLine1='" + streetLine1 + '\'' +
                ", streetLine2='" + streetLine2 + '\'' +
                ", state=" + state +
                ", suburb='" + suburb + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}
