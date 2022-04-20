package com.lkh.entity.dto;

import com.lkh.entity.bo.HeadLine;
import com.lkh.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
