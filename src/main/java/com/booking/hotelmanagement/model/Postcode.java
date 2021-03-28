package com.booking.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
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
public class Postcode implements Serializable {
    @Column(nullable = false)
    @Pattern(regexp = "[0-9]{4}", message = "Postcode must be 4 digits")
    @NotNull(message = "required")
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postcode postcode = (Postcode) o;
        return Objects.equals(value, postcode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Postcode{" +
                "value='" + value + '\'' +
                '}';
    }
}
