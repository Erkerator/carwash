package yt.company.carwash.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yt.company.carwash.models.Company;
import yt.company.carwash.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<Object> getAllCompanies() {
        List<Company> companiesList = companyService.getAllCompanies();
        return ResponseEntity.ok(companiesList);
    }


    @GetMapping(value="{id}")
    public ResponseEntity<Object> getCompany(@PathVariable(name="id") Long id) {
        try {
            Company company = companyService.getCompany(id);
            return ResponseEntity.ok(company);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Object> createCompany(@RequestBody Company company,
                                                @PathVariable(name="id") Long userId) {

        return ResponseEntity.ok(companyService.createCompany(company, userId));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
    /*@PutMapping("/update/{id}")
    public ResponseEntity<?> updateCompany(@RequestBody Company company,
                                           @PathVariable(name="id") Long id) {
        try {
            Company companiesFromDb = companyService.getCompany(id);
            companyService.updateCompany(company);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
}
