package com.manager.parcinfo.controller;

import com.manager.parcinfo.model.bo.*;
import com.manager.parcinfo.model.service.*;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/parcInfo")
public class ApplicationController {
    private final AdministratorService adminService;
    private final societeService societeservice;
    private final extensionService extensionservice;
    private final pcService pcservice;
    private final ecranService ecranservice;
    private final printerService printerservice;
    private final tonerService tonerservice;
    private final departementService departementservice;
    private final userService userservice;

    public ApplicationController(AdministratorService adminService, societeService societeservice, extensionService extensionservice, pcService pcservice, ecranService ecranservice, printerService printerservice, tonerService tonerservice, departementService departementservice, userService userservice) {
        this.adminService = adminService;
        this.societeservice = societeservice;
        this.extensionservice = extensionservice;
        this.pcservice = pcservice;
        this.ecranservice = ecranservice;
        this.printerservice = printerservice;
        this.tonerservice = tonerservice;
        this.departementservice = departementservice;
        this.userservice = userservice;
    }

    /***********************administrator management*******************************/
    @GetMapping("allAdmin")
    public ResponseEntity<List<Administrator>> getAllAdministrator(){
        List<Administrator> admins = this.adminService.findAllAdmins();
        return new ResponseEntity<>(admins,HttpStatus.OK);
    }

    @GetMapping("/findAdmin/{id}")
    public ResponseEntity<Optional<Administrator>> getAdmin(@PathVariable("id") Long id){
        Optional<Administrator> admin = this.adminService.getAdmin(id);
        return new ResponseEntity<>(admin,HttpStatus.OK);
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<Administrator> addAdmin(@RequestBody Administrator admin){
        Administrator newadmin = this.adminService.addAdmin(admin);
        return new ResponseEntity<>(newadmin,HttpStatus.CREATED);
    }

    @PutMapping("/updateAdmin")
    public ResponseEntity<Administrator> updateAdmin(@RequestBody Administrator admin){
        Administrator updatedadmin = this.adminService.updateAdmin(admin);
        return new ResponseEntity<>(updatedadmin,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public ResponseEntity<?> addAdmin(@PathVariable("id") Long id){
        this.adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /***********************societe management*******************************/
    @GetMapping("allSocietes")
    public ResponseEntity<List<Societe>> getAllSocietes(){
        List<Societe> societes = this.societeservice.findAllSociete();
        return new ResponseEntity<>(societes,HttpStatus.OK);
    }

    @GetMapping("/findSociete/{id}")
    public ResponseEntity<Optional<Societe>> getSociete(@PathVariable("id") Long id){
        Optional<Societe> societe = this.societeservice.getSociete(id);
        return new ResponseEntity<>(societe,HttpStatus.OK);
    }

    @PostMapping("/addSociete")
    public ResponseEntity<Societe> addSociete(@RequestBody Societe societe){
        Societe newsociete = this.societeservice.addSociete(societe);
        return new ResponseEntity<>(newsociete,HttpStatus.CREATED);
    }

    @PutMapping("/updateSociete")
    public ResponseEntity<Societe> updateSociete(@RequestBody Societe societe){
        Societe updatedsociete = this.societeservice.updateSociete(societe);
        return new ResponseEntity<>(updatedsociete,HttpStatus.OK);
    }

    @DeleteMapping("/deleteSociete/{id}")
    public ResponseEntity<?> addSociete(@PathVariable("id") Long id){
        this.societeservice.deleteSociete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /***********************Extension management*******************************/
    @GetMapping("allExtensions")
    public ResponseEntity<List<Extension>> getAllExtension(){
        List<Extension> extension = this.extensionservice.findAllExtension();
        return new ResponseEntity<>(extension,HttpStatus.OK);
    }

    @GetMapping("/findExtension/{id}")
    public ResponseEntity<Optional<Extension>> getExtension(@PathVariable("id") Long id){
        Optional<Extension> extension = this.extensionservice.getExtension(id);
        return new ResponseEntity<>(extension,HttpStatus.OK);
    }

    @PostMapping("/{id}/addExtension")
    public ResponseEntity<Extension> addExtension(@PathVariable(value = "id") Long id,@RequestBody Extension extension){
        Societe company = new Societe();
        company.setSid(this.societeservice.getSociete(id).get().getSid());
        Extension exten = new Extension(extension.getEname(),extension.getCity(),company);
        Extension newextension = this.extensionservice.addExtension(exten);
        return new ResponseEntity<>(newextension,HttpStatus.CREATED);
    }

    @PutMapping("/{id}/updateExtension")
    public ResponseEntity<Extension> updateExtension(@PathVariable(value = "id") Long id,@RequestBody Extension extension){
        extension.setCompany(this.societeservice.getSociete(id).get());
        Extension updatedextension = this.extensionservice.updateExtension(extension);
        return new ResponseEntity<>(updatedextension,HttpStatus.OK);
    }

    @DeleteMapping("/deleteExtension/{id}")
    public ResponseEntity<?> addExtension(@PathVariable("id") Long id){
        this.extensionservice.deleteExtension(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}/addDeptoExtension")
    public ResponseEntity<Extension> updateDeptoExtension(@PathVariable(value = "id") Long id,@RequestBody Extension extension){
        extension.setCompany(this.societeservice.getSociete(id).get());
        Departement dep = this.departementservice.getDepartement(1L).get();
        Extension updatedextension = this.extensionservice.addDeptoExtension(extension,dep);
        return new ResponseEntity<>(updatedextension,HttpStatus.OK);
    }
    /***********************Pc management*******************************/
    @GetMapping("allPcs")
    public ResponseEntity<List<Pc>> getAllsPc(){
        List<Pc> pcs = this.pcservice.findAllPcs();
        return new ResponseEntity<>(pcs,HttpStatus.OK);
    }

    @GetMapping("/findPc/{id}")
    public ResponseEntity<Optional<Pc>> getPc(@PathVariable("id") Long id){
        Optional<Pc> pc = this.pcservice.getPc(id);
        return new ResponseEntity<>(pc,HttpStatus.OK);
    }
    @PostMapping("/addPc")
    public ResponseEntity<Pc> addPc(@RequestBody Pc pc){
        Pc newpc = this.pcservice.addPc(pc);
        return new ResponseEntity<>(newpc,HttpStatus.CREATED);
    }

    @PutMapping("/updatePc")
    public ResponseEntity<Pc> updatePc(@RequestBody Pc pc){
        Pc updatedpc = this.pcservice.updatePc(pc);
        return new ResponseEntity<>(updatedpc,HttpStatus.OK);
    }

    @DeleteMapping("/deletePc/{id}")
    public ResponseEntity<?> addPc(@PathVariable("id") Long id){
        this.pcservice.deletePc(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /***********************Ecran management*******************************/
    @GetMapping("allEcrans")
    public ResponseEntity<List<Ecran>> getAllEcrans(){
        List<Ecran> ecrans = this.ecranservice.findAllEcrans();
        return new ResponseEntity<>(ecrans,HttpStatus.OK);
    }

    @GetMapping("/findEcran/{id}")
    public ResponseEntity<Optional<Ecran>> getEcran(@PathVariable("id") Long id){
        Optional<Ecran> ecran = this.ecranservice.getEcran(id);
        return new ResponseEntity<>(ecran,HttpStatus.OK);
    }
    @PostMapping("/addEcran")
    public ResponseEntity<Ecran> addEcran(@RequestBody Ecran ecran){
        Ecran newecran = this.ecranservice.addEcran(ecran);
        return new ResponseEntity<>(newecran,HttpStatus.CREATED);
    }

    @PutMapping("/updateEcran")
    public ResponseEntity<Ecran> updateEcran(@RequestBody Ecran ecran){
        Ecran updatedecran = this.ecranservice.updateEcran(ecran);
        return new ResponseEntity<>(updatedecran,HttpStatus.OK);
    }

    @DeleteMapping("/deleteEcran/{id}")
    public ResponseEntity<?> addEcran(@PathVariable("id") Long id){
        this.ecranservice.deleteEcran(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /***********************Printer management*******************************/
    @GetMapping("allPrinters")
    public ResponseEntity<List<Printer>> getAllPrinters(){
        List<Printer> printers = this.printerservice.findAllPrinter();
        return new ResponseEntity<>(printers,HttpStatus.OK);
    }

    @GetMapping("/findPrinter/{id}")
    public ResponseEntity<Optional<Printer>> getPrinter(@PathVariable("id") Long id){
        Optional<Printer> printer = this.printerservice.getPrinter(id);
        return new ResponseEntity<>(printer,HttpStatus.OK);
    }
    @PostMapping("/addPrinter")
    public ResponseEntity<Printer> addPrinter(@RequestBody Printer printer){
        Printer newprinter = this.printerservice.addPrinter(printer);
        return new ResponseEntity<>(newprinter,HttpStatus.CREATED);
    }

    @PutMapping("/updatePrinter")
    public ResponseEntity<Printer> updatePrinter(@RequestBody Printer printer){
        Printer updatedprinter = this.printerservice.updatePrinter(printer);
        return new ResponseEntity<>(updatedprinter,HttpStatus.OK);
    }

    @DeleteMapping("/deletePrinter/{id}")
    public ResponseEntity<?> addPrinter(@PathVariable("id") Long id){
        this.printerservice.deletePrinter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /***********************toner management*******************************/
    @GetMapping("allToners")
    public ResponseEntity<List<Toner>> getAllToners(){
        List<Toner> toners = this.tonerservice.findAllToners();
        return new ResponseEntity<>(toners,HttpStatus.OK);
    }

    @GetMapping("/findToner/{id}")
    public ResponseEntity<Optional<Toner>> getToner(@PathVariable("id") Long id){
        Optional<Toner> toner = this.tonerservice.getToner(id);
        return new ResponseEntity<>(toner,HttpStatus.OK);
    }
    @PostMapping("/addToner")
    public ResponseEntity<Toner> addPrinter(@RequestBody Toner toner){
        Toner newtoner = this.tonerservice.addToner(toner);
        return new ResponseEntity<>(newtoner,HttpStatus.CREATED);
    }

    @PutMapping("/updateToner")
    public ResponseEntity<Toner> updateToner(@RequestBody Toner toner){
        Toner updatedtoner = this.tonerservice.updateToner(toner);
        return new ResponseEntity<>(updatedtoner,HttpStatus.OK);
    }

    @DeleteMapping("/deleteToner/{id}")
    public ResponseEntity<?> addToner(@PathVariable("id") Long id){
        this.tonerservice.deleteToner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /***********************Departement management*******************************/
    @GetMapping("allDeps")
    public ResponseEntity<List<Departement>> getAllDepartements(){
        List<Departement> departements = this.departementservice.findAlldepartements();
        return new ResponseEntity<>(departements,HttpStatus.OK);
    }

    @GetMapping("/findDep/{id}")
    public ResponseEntity<Optional<Departement>> getDepartement(@PathVariable("id") Long id){
        Optional<Departement> departement = this.departementservice.getDepartement(id);
        return new ResponseEntity<>(departement,HttpStatus.OK);
    }
    @PostMapping("/addDep")
    public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement){
        Departement newdepartement = this.departementservice.addDepartement(departement);
        return new ResponseEntity<>(newdepartement,HttpStatus.CREATED);
    }

    @PutMapping("/updateDep")
    public ResponseEntity<Departement> updateDepartement(@RequestBody Departement departement){
        Departement updateddepartement = this.departementservice.updateDepartement(departement);
        return new ResponseEntity<>(updateddepartement,HttpStatus.OK);
    }

    @DeleteMapping("/deleteDep/{id}")
    public ResponseEntity<?> addDepartement(@PathVariable("id") Long id){
        this.departementservice.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /***********************User management*******************************/
    @GetMapping("allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userservice.findAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") Long id){
        Optional<User> user = this.userservice.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PostMapping("/{id}/addUser")
    public ResponseEntity<User> addUser(@PathVariable(value = "id") Long id,@RequestBody User user){
        Departement dep;
        dep = this.departementservice.getDepartement(id).get();
        User user1 = new User(user.getUname(),user.getUlasteName(),user.getUemail(),user.getUtele(),user.getUposte(),dep);
        User newuser = this.userservice.addUser(user1);
        return new ResponseEntity<>(newuser,HttpStatus.CREATED);
    }

    @PutMapping("/{id}/updateUser")
    public ResponseEntity<User> update(@PathVariable(value = "id") Long id,@RequestBody User user){
        Departement dep;
        dep = this.departementservice.getDepartement(id).get();
        user.setWorkers(dep);
        User updateduser = this.userservice.updateUser(user);
        return new ResponseEntity<>(updateduser,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> addUser(@PathVariable("id") Long id){
        this.userservice.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
