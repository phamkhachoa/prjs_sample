package jp.co.softbrain.esales.employees.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.softbrain.esales.employees.service.EmployeesPackagesService;
import jp.co.softbrain.esales.employees.web.rest.vm.request.GetServicesRequest;
import jp.co.softbrain.esales.employees.web.rest.vm.response.GetServicesByPackageIdsResponse;

/**
 * get service API
 */
@RestController
@RequestMapping("/api")
public class GetServiceResource {

    @Autowired
    private EmployeesPackagesService employeesPackagesService;

    /**
     * get Services API
     *
     * @return GetServicesByPackageIdsResponse : list DTO out of API getServices
     */
    @PostMapping(path = "/get-services", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetServicesByPackageIdsResponse> getServices(@RequestBody GetServicesRequest input) {
        return ResponseEntity.ok(employeesPackagesService.getServices(input.getEmployeeId(), null, null));
    }
}
