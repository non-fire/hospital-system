package com.example.backend.controller.inspectionitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveInspectionItemController {
    @Autowired
    private RemoveInspectionItemController removeInspectionItemController;

    @PostMapping("/user/item/remove/")
    public Map<String, String> remove(@RequestParam Map<String, String> data) {
        return removeInspectionItemController.remove(data);
    }
}
