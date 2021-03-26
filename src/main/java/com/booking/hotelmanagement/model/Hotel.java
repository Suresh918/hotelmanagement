package com.booking.hotelmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;


@Entity
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
// @ServiceClass(ChangeRequestService.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@SpELEvaluationContext(ChangeRequestEvaluationContext.class)
@Getter
@Setter
//@AbacScan({ChangeRequestMyTeam.class})
@NoArgsConstructor
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "hotel_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(optional=true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    @Column(nullable = false)
    private int stars;

    @Column(nullable = false)
    private String email;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;



    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    // Stop bidirectional relationship which cause a cycle.
    @JsonIgnore
    private Set<Room> rooms;

    @Column(nullable = false)
    private LocalTime earliestCheckInTime;

    @Column(nullable = false)
    private LocalTime latestCheckInTime;

    @Column(nullable = false)
    private LocalTime standardCheckOutTime;

    @Column(nullable = false)
    private LocalTime latestCheckOutTime;

    @Column(nullable = false)
    private BigDecimal lateCheckoutFee;

    private final static LocalTime DEFAULT_EARLIEST_CHECK_IN = LocalTime.of(7, 0);
    private final static LocalTime DEFAULT_LATEST_CHECK_IN = LocalTime.of(22, 0);
    private final static LocalTime DEFAULT_STANDARD_CHECKOUT = LocalTime.of(11, 0);
    private final static LocalTime DEFAULT_LATEST_CHECKOUT = LocalTime.of(22, 0);
    private final static BigDecimal DEFAULT_LATE_CHECKOUT_FEE = BigDecimal.valueOf(15.95);

    @Override
    public String toString() {
        return "" + this.id;
    }

}
