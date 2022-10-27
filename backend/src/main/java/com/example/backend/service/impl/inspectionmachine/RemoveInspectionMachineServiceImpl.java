package com.example.backend.service.impl.inspectionmachine;

import com.example.backend.mapper.InspectionMachineMapper;
import com.example.backend.pojo.InspectionMachine;
import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.inspectionmachine.RemoveInspectionMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveInspectionMachineServiceImpl implements RemoveInspectionMachineService {
    @Autowired
    private InspectionMachineMapper inspectionMachineMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int machine_id = Integer.parseInt(data.get("machine_id"));
        InspectionMachine album = inspectionMachineMapper.selectById(machine_id);
        Map<String, String> map = new HashMap<>();

        if (album == null) {
            map.put("error_message", "相册不存在或已被删除");
            return map;
        }

        inspectionMachineMapper.deleteById(machine_id);

        map.put("error_message", "success");
        return map;
    }
}
