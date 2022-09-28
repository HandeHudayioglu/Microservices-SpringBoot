package com.hande.services;


import com.hande.repository.DegreeHoldersRepository;
import com.hande.repository.entity.DegreeHolders;
import com.hande.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class DegreeHoldersService extends ServiceManager<DegreeHolders,Long> {

    private final DegreeHoldersRepository degreeHoldersRepository;

    public DegreeHoldersService(DegreeHoldersRepository degreeHoldersRepository) {
        super(degreeHoldersRepository);
        this.degreeHoldersRepository=degreeHoldersRepository;
    }
}
