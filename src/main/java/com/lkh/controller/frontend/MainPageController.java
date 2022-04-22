package com.lkh.controller.frontend;

import com.lkh.entity.dto.MainPageInfoDTO;
import com.lkh.entity.dto.Result;
import com.lkh.service.combine.HeadLineShopCategoryCombineService;
import com.lkh.service.combine.impl.HeadLineShopCategoryCombineServiceImpl;
import lombok.Getter;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Getter
public class MainPageController {
    @Autowired("HeadLineShopCategoryCombineServiceImpl")
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;
    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse rep) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
