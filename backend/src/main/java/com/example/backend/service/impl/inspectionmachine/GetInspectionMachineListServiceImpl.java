package com.example.backend.service.impl.inspectionmachine;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.InspectionMachineMapper;
import com.example.backend.pojo.InspectionMachine;
import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.inspectionmachine.GetInspectionMachineListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetInspectionMachineListServiceImpl implements GetInspectionMachineListService {
    @Autowired
        private InspectionMachineMapper inspectionMachineMapper;

    @Override
    public List<InspectionMachine> getList(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        Integer machineId = Integer.parseInt(data.get("machine_id"));
        QueryWrapper<InspectionMachine> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("machine_id", machineId);

        return inspectionMachineMapper.selectList(queryWrapper);

    }
}
