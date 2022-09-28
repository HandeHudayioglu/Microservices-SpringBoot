package com.hande.repository.entity;


import com.hande.repository.enums.StateOfAttendance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "attendance_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long yarismaId;
    Long date;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    StateOfAttendance stateOfAttendance = StateOfAttendance.UNAPPROVED;
    @Embedded
    TableAdd tableAdd;
}
