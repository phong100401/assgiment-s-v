package com.example.restapi.seed;

import com.example.restapi.StreetStatus;
import com.example.restapi.entity.District;
import com.example.restapi.entity.Street;
import com.example.restapi.repository.DistrictRepository;
import com.example.restapi.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class loadData implements CommandLineRunner {
    @Autowired
    StreetRepository streetRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDistrict();
        loadStreet();
    }
    private void loadDistrict(){
        if (districtRepository.count() == 0){
            District district1 = new District("Ba Dinh");
            District district2 = new District("Thanh Xuan");
            District district3 = new District("Hoàn Kiếm");
            District district4 = new District("Tây Hồ");
            District district5 = new District("Cầu Giây");
            districtRepository.save(district1);
            districtRepository.save(district2);
            districtRepository.save(district3);
            districtRepository.save(district4);
            districtRepository.save(district5);
        }
        System.out.println(districtRepository.count());
    }
    private void loadStreet(){
        if (streetRepository.count() == 0){
            Street street1 = new Street("Tân Ấp", LocalDate.now(),"Tân ấp", StreetStatus.USING,1);
            Street street2 = new Street("An Dương", LocalDate.now(),"An Dương", StreetStatus.UNDER_CONSTRUCTION,1);
            Street street3 = new Street("Vương Thừa Vũ", LocalDate.now(),"Vương Thừa Vũ", StreetStatus.FIX,2);
            Street street4 = new Street("Hồ Rùa", LocalDate.now(),"Hồ Rùa", StreetStatus.USING,2);
            Street street5 = new Street("Hàng Buồm", LocalDate.now(),"Hàng Buồm", StreetStatus.UNDER_CONSTRUCTION,3);
            Street street6 = new Street("Tạ Hiện", LocalDate.now(),"Tạ Hiện", StreetStatus.FIX,3);
            Street street7 = new Street("Hàn Quốc", LocalDate.now(),"Hàn Quốc", StreetStatus.USING,4);
            Street street8 = new Street("Nhật Bản", LocalDate.now(),"Nhật Bản", StreetStatus.USING,4);
            Street street9 = new Street("Duy Tân", LocalDate.now(),"Duy Tân", StreetStatus.USING,5);
            Street street10 = new Street("Trần Bình", LocalDate.now(),"Trần Bình", StreetStatus.USING,5);
            streetRepository.save(street1);
            streetRepository.save(street2);
            streetRepository.save(street3);
            streetRepository.save(street4);
            streetRepository.save(street5);
            streetRepository.save(street6);
            streetRepository.save(street7);
            streetRepository.save(street8);
            streetRepository.save(street9);
            streetRepository.save(street10);
        }
        System.out.println(streetRepository.count());
    }
}
