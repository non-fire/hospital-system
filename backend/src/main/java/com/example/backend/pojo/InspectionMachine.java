package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectionMachine {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer number;
    private String inspectionItemId;
    private Integer time;
    private String postion;
    private String working_date;
}
