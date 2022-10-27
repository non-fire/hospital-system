package com.example.backend.service.impl.inspectionitem;

import com.example.backend.mapper.InspectionItemMapper;
import com.example.backend.pojo.InspectionItem;
import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.inspectionitem.RemoveInspectionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveInspectionItemServiceImpl implements RemoveInspectionItemService {
    @Autowired
    private InspectionItemMapper inspectionItemMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int item_id = Integer.parseInt(data.get("item_id"));
        InspectionItem photo = inspectionItemMapper.selectById(item_id);
        Map<String, String> map = new HashMap<>();

        if (photo == null) {
            map.put("error_message", "检测项目不存在或已被删除");
            return map;
        }

        inspectionItemMapper.deleteById(item_id);

        map.put("error_message", "success");
        return map;
    }
}
