package com.manager.parcinfo.model.service;

import com.manager.parcinfo.model.bo.Printer;
import com.manager.parcinfo.model.dao.printerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class printerService {
    private final printerRepo printerRepo;

    @Autowired
    public printerService(printerRepo printerRepo) { this.printerRepo = printerRepo; }

    public Printer addPrinter(Printer printer){ return this.printerRepo.save(printer); }

    public List<Printer> findAllPrinter(){ return this.printerRepo.findAll(); }

    public Printer updatePrinter(Printer admin){
        return this.printerRepo.save(admin);
    }

    public void deletePrinter(Long id){
        this.printerRepo.deleteById(id);
    }

    public Optional<Printer> getPrinter(Long id){
        return this.printerRepo.findById(id);
    }
}
