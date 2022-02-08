package com.example.restapi.controller;

import com.example.restapi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/districts")
@CrossOrigin("*")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    //lấy danh sách
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(districtService.getAll(), HttpStatus.OK);
    }

}
