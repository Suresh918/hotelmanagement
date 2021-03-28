package com.booking.hotelmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


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
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "room_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @ManyToOne
    private Hotel hotel;


    @NaturalId
    @Column(nullable = false, unique = true)
    private String roomNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private int beds;

    @Column(nullable = false)
    private BigDecimal costPerNight;

   /* @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;*/


   /* public boolean isReserved() {
        return reservation != null;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
