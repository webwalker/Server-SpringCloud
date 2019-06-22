package com.xujian.upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController //表示该类下的方法的返回值会自动做json格式的转换
public class FileUploadController {
    @Value("${filePath}")
    private String filePath;

    @RequestMapping("/fileUploadController")
    public Map<String, Object> fileUpload(MultipartFile filename) throws Exception {
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("/Users/xujian/Downloads/" + filename.getOriginalFilename()));
        Map<String, Object> map = new HashMap();
        map.put("msg", "ok");
        return map;
    }

    @GetMapping("/upload")
    public String uploading() {
        //跳转到 templates 目录下的 uploading.html
        return "uploading";
    }

    //处理文件上传
    @PostMapping("/uploading")
    public @ResponseBody
    String uploading(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {
        try {
            uploadFile(file.getBytes(), filePath, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件上传失败!");
            return "uploading failure";
        }
        System.out.println("文件上传成功!");
        return "uploading success";
    }


    public void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
