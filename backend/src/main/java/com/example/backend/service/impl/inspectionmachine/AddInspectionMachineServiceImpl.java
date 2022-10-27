package com.example.backend.service.impl.inspectionmachine;

import com.example.backend.mapper.InspectionMachineMapper;
import com.example.backend.pojo.InspectionMachine;
import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.inspectionmachine.AddInspectionMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddInspectionMachineServiceImpl implements AddInspectionMachineService {
    @Autowired
    private InspectionMachineMapper inspectionMachineMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        String name = data.get("machine_name");
        Integer number = Integer.parseInt(data.get("machine_number"));
        String inspectionItemId = data.get("item_id");
        Integer time = Integer.parseInt(data.get("time"));
        String postion = data.get("postion");
        String working_date = data.get("working_date");

        Map<String, String> map = new HashMap<>();

        if (name == null || name.length() == 0) {
            map.put("error_message", "标题不能为空");
            return map;
        }

        if (name.length() > 100) {
            map.put("error_message", "标题长度不能大于100");
            return map;
        }

        InspectionMachine inspectionMachine = new InspectionMachine(null, name, number, inspectionItemId, time, postion, working_date);

        inspectionMachineMapper.insert(inspectionMachine);
        map.put("error_message", "success");

        return map;
    }
}
