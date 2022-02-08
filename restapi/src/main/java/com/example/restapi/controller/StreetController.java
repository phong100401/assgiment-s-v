package com.example.restapi.controller;

import com.example.restapi.entity.Street;
import com.example.restapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/streets")
@CrossOrigin("*")
public class StreetController {
    @Autowired
    StreetService streetService;

    //Lấy ra danh sách street
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(@RequestParam(name = "districtId", defaultValue = "-1") int districtId,
                                          @RequestParam(name = "name", required = false) String name){// trích xuất dữ liệu từ query parameters, form parameters, và kể cả các tập tin từ request
        return new ResponseEntity<>(streetService.getAll(), HttpStatus.OK);// trả về danh sách + trạng thái
    }

    //Tìm kiếm tên street
    @RequestMapping(method = RequestMethod.GET,path = "search/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        return new ResponseEntity<>(streetService.findByName(name),HttpStatus.OK);
    }

    //Tạo mới street
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Street street){
        return new ResponseEntity<>(streetService.create(street),HttpStatus.CREATED);
    }

    //Lấy ra thông tin của street theo id
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id){
        Optional<Street> optionalStreet = streetService.findById(id);
        if(optionalStreet.isPresent()){
            return new ResponseEntity<>(optionalStreet.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Cập nhật lại street
    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<Object> update(@PathVariable int id,@RequestBody Street street){
        return new ResponseEntity<>(streetService.update(id,street),HttpStatus.ACCEPTED);
    }

}
