package com.example.backend.controller.inspectionmachine;

import com.example.backend.service.inspectionmachine.AddInspectionMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddInspectionMachineController {
    @Autowired
    private AddInspectionMachineService addInspectionMachineService;

    @PostMapping("/user/machine/add/")
    public Map<String, String> add(@RequestParam Map<String, String> data){
        return addInspectionMachineService.add(data);
    }
}
