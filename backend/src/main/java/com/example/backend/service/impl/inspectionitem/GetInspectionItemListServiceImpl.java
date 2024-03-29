package com.example.backend.service.impl.inspectionitem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.InspectionItemMapper;
import com.example.backend.pojo.InspectionItem;
import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.inspectionitem.GetInspectionItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetInspectionItemListServiceImpl implements GetInspectionItemListService {
    @Autowired
        private InspectionItemMapper inspectionItemMapper;

    @Override
    public List<InspectionItem> getList() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        QueryWrapper<InspectionItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("id");
        return inspectionItemMapper.selectList(queryWrapper);

    }
}
