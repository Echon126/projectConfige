package com.example.demo.controller;

import com.example.demo.configuration.ApplicationConfiguration;
import com.example.demo.entity.DataMap;
import com.example.demo.service.SystemService;
import com.example.demo.utils.DownFile;
import com.example.demo.utils.ExportMemberVo;
import com.example.demo.utils.FileDown;
import com.wen.excel.configuration.BuilderConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author admin
 * @date 2019-2-12 15:09
 */
@Controller
public class DownFileController {
    @RequestMapping(value = "/down", method = RequestMethod.GET)
    public ModelAndView download() {

        List<ExportMemberVo> list = new ArrayList<ExportMemberVo>();
        for (int i = 0; i < 5; i++) {
            ExportMemberVo exportMemberVo = new ExportMemberVo();
            exportMemberVo.setName("Kent" + i);
            @SuppressWarnings("unchecked")
            int gender = ThreadLocalRandom.current().nextInt(0, 2);
            exportMemberVo.setGender(gender);
            exportMemberVo.setPhone("182xxxxxxxx");
            exportMemberVo.setBankNo("建设银行");
            list.add(exportMemberVo);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("members", list);
        DownFile excelView = new DownFile();
        excelView.setFileName("魅力城市xxxxxx");
        excelView.setTitles(new String[]{"姓名","性别","手机号","身份证号","银行卡号"});
        return new ModelAndView(excelView, map);
    }

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/downLoadFile", method = RequestMethod.GET)
    public void downLoadFile(HttpServletRequest requst,
                             HttpServletResponse response) {
        String file = this.systemService.systemUser();
        //FileDown.downloadWrite(requst, response, file);
    }

    @Autowired
    ApplicationConfiguration app;

    @Autowired
    BuilderConfiguration configuration;

    @RequestMapping(value = "/customLoad", method = RequestMethod.GET)
    public void CustomDownLoadFile(HttpServletRequest requst,
                                   HttpServletResponse response) throws IOException, URISyntaxException {
        String path = this.getClass().getClassLoader().getResource("").toURI().getPath() + "forerunner";
        String filename = this.configuration.builderUtils("systemUser", this.systemService.systemUserData());
        FileDown.downloadWrite(requst, response, app.getDownDir(), filename);
    }


    @GetMapping("/importExcel")
    public void importExcel() throws Exception {
        DataMap ddmm = new DataMap();
        ddmm.put("minfo-pathFileName","test.xlsx");
        ddmm.put("minfo-path","E:\\test\\test.xlsx");
        this.systemService.systemUserExcel(ddmm);
    }

}
