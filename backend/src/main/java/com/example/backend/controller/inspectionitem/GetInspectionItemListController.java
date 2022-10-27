package com.example.backend.controller.inspectionitem;

import com.example.backend.pojo.InspectionItem;
import com.example.backend.service.inspectionitem.GetInspectionItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetInspectionItemListController {
    @Autowired
    private GetInspectionItemListService getInspectionItemListService;

    @GetMapping("/user/item/getlist/")
    public List<InspectionItem> getList() {
        return getInspectionItemListService.getList();
    }
}
