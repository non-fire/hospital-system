package com.example.backend.controller.inspectionmachine;

import com.example.backend.service.inspectionmachine.RemoveInspectionMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveInspectionMachineController {
    @Autowired
    private RemoveInspectionMachineService removeInspectionMachineService;

    @PostMapping("/user/machine/remove/")
    public Map<String, String> remove(@RequestParam Map<String, String> data) {
        return removeInspectionMachineService.remove(data);
    }
}
