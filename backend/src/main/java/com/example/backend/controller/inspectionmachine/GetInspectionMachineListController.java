package com.example.backend.controller.inspectionmachine;

import com.example.backend.pojo.InspectionMachine;
import com.example.backend.service.inspectionmachine.GetInspectionMachineListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetInspectionMachineListController {
    @Autowired
    private GetInspectionMachineListService getInspectionMachineListService;

    @GetMapping("/user/machine/getlist")
    public List<InspectionMachine> getList(Map<String, String> data) {
        return getInspectionMachineListService.getList(data);
    }
}
