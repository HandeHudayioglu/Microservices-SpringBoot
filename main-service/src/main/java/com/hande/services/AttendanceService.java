package com.hande.services;


import com.hande.repository.AttendanceRepository;
import com.hande.repository.entity.Attendance;
import com.hande.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService extends ServiceManager<Attendance,Long> {

    private final AttendanceRepository attendanceRepository;


    public AttendanceService(AttendanceRepository attendanceRepository) {
        super(attendanceRepository);
        this.attendanceRepository=attendanceRepository;
    }
}
