package com.example.backend.service.inspectionmachine;

import com.example.backend.pojo.InspectionMachine;

import java.util.List;
import java.util.Map;

public interface GetInspectionMachineListService {
    List<InspectionMachine> getList(Map<String, String> data);
}
