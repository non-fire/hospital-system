package com.example.backend.service.impl.inspectionitem;

import com.example.backend.mapper.InspectionItemMapper;
import com.example.backend.pojo.InspectionItem;
import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.inspectionitem.AddInspectionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddInspectionItemServiceImpl implements AddInspectionItemService {
    @Autowired
    private InspectionItemMapper inspectionItemMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        String name = data.get(("item_name"));;
        Integer fasting = Integer.parseInt(data.get("item_id"));
        Integer InspectionMachine = Integer.parseInt(data.get("item_id"));
        Integer PreconditionId = Integer.parseInt(data.get("item_id"));

        Map<String, String> map = new HashMap<>();

        if (name.length() > 100) {
            map.put("error_message", "检查项目名称不能大于100");
            return map;
        }

        InspectionItem inspectionItem = new InspectionItem(null, name, fasting, InspectionMachine, PreconditionId);

        inspectionItemMapper.insert(inspectionItem);
        map.put("error_message", "success");

        return map;
    }
}
