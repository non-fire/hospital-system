package com.example.backend.controller.inspectionmachine;

import com.example.backend.service.inspectionmachine.UpdateInspectionMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateInspectionMachineController {
    @Autowired
    private UpdateInspectionMachineService updateInspectionMachineService;

    @PostMapping("/user/machine/update")
    public Map<String, String> update(@RequestParam Map<String, String> data) {
        return updateInspectionMachineService.update(data);
    }
}
