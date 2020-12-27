package com.order.springorder.controller;

import com.order.springorder.model.MerryOrderSupplier;
import com.order.springorder.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
//@CrossOrigin(value = "http://localhost:8080/api")
public class SupplierRestController {

    @Autowired
    SupplierService supplierService;



    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value= "/getSupplier", method=RequestMethod.GET)
    // @CrossOrigin("http://localhost:8080/api")
    public ResponseEntity<List<MerryOrderSupplier>> getSupplier(@RequestParam("org") String org){
        try {
            return new ResponseEntity(supplierService.getSupplier(org), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("not ok"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value= "/postSupplier", method=RequestMethod.POST)
    public ResponseEntity createEmployee( @RequestBody MerryOrderSupplier employee) {
        try {
            //System.out.println(employee.getSuppName());
            supplierService.addMerryOrderSupplier(employee);
            return new ResponseEntity("ok", HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("post"+e);
            return new ResponseEntity("not ok", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value= "/deleteSupplier/{id}", method=RequestMethod.POST)
    public ResponseEntity deleteSupplier(@PathVariable(value="id") long id) {
        try {
           supplierService.deletSupplierById(id);
           return new ResponseEntity("ok", HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("del"+e);
            return new ResponseEntity("not ok", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value= "/putSupplier", method=RequestMethod.POST)
    public ResponseEntity putSupplier(@RequestBody MerryOrderSupplier supplier){
        try {
            supplierService.putSupplier(supplier);
            return new ResponseEntity("ok", HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("put"+e);
            return new ResponseEntity("not ok", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value= "/getSuppByCondi", method=RequestMethod.GET)
    public ResponseEntity<List<MerryOrderSupplier>> getSuppByCondi(@RequestParam("org") String org, @RequestParam("suppNM") String suppNM){
        try {

            return new ResponseEntity(supplierService.getSuppByCondi(org,suppNM), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("not ok", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value= "/getSupplierBySuppId", method=RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getSupplierBySuppId(@RequestParam("suppId") long suppId){
        try {

            return new ResponseEntity(supplierService.getSupplierBySuppId(suppId), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("not ok"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
