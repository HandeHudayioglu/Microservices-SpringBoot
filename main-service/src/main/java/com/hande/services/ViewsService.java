package com.hande.services;


import com.hande.repository.ViewsRepository;
import com.hande.repository.entity.Views;
import com.hande.utility.ServiceManager;

public class ViewsService extends ServiceManager<Views,Long> {

    private final ViewsRepository viewsRepository;

    public ViewsService(ViewsRepository viewsRepository) {
        super(viewsRepository);
        this.viewsRepository=viewsRepository;

    }
}
