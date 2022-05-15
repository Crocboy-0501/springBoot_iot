package com.example.demo.controller;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.tools.entity.ZipStreamEntity;
import com.example.demo.utils.ZipUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 工具集（乱七八糟的东西）
 * @author cdj
 * @date 2018年8月24日 上午9:13:05
 */
@RestController
@RequestMapping("/ToolsController")
@Api(value="工具集",tags={"工具集"})
public class ToolsController {

    @Autowired
    ZipUtils zipUtils;

    @ApiOperation("文件zip打包")
    @ApiImplicitParams({
    })
    @GetMapping("/ZipTools")
    public void zipTools(HttpServletResponse response, HttpServletRequest request) throws FileNotFoundException {
        String sourceFilePath = "C:\\Users\\Administrator\\Desktop\\test\\123.png";
        String sourceFilePath1 = "C:\\Users\\Administrator\\Desktop\\test\\456.png";
        String fileName = request.getParameter("fileName");
        List<ZipStreamEntity> list = new ArrayList<>();
        fileName += ".zip";
        File file = new File(sourceFilePath);
        InputStream fileInputStream = new FileInputStream(file);
        File file2 = new File(sourceFilePath1);
        InputStream fileInputStream2 = new FileInputStream(file2);
        list.add(new ZipStreamEntity("123.png", fileInputStream));
        list.add(new ZipStreamEntity("456.png", fileInputStream2));

        System.out.println(file.exists());
        ZipUtils.listStreamToZipStream(list, fileName, response);

    }

    @GetMapping("/folderToZip")
    public void folderToZip(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String sourceFilePath = "C:\\Users\\Administrator\\Desktop\\test";
        String fileName = request.getParameter("fileName");

        fileName += ".zip";

        ZipUtils.folderToZip(sourceFilePath, fileName, response);

    }

}