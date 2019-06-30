package com.xujian.swagger.group;

import com.xujian.swagger.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "API注释", tags = "API注释")
@RequestMapping(value = "/api/aci")
public class ApiController {

    @PostMapping("/xxx")
    @ApiOperation(value = "ModelAttribute", notes = "ModelAttribute类型参数", tags = {"API注释", "API自定义"})
    public RestMessage reqbody1(@ModelAttribute ReqEntity reqEntity) {
        return new RestMessage(reqEntity);
    }

    @PostMapping("/xxx1")
    @ApiOperation(value = "ModelAttribute1", notes = "ModelAttribute类型参数1", tags = {"API注释", "API自定义"})
    public RestMessage reqbody2(@ModelAttribute ActInteger reqEntity) {
        return new RestMessage(reqEntity);
    }

    @PostMapping("/sendUser")
    @ApiOperation(value = "用户注册", notes = "填写用户信息注册用户")
    public Rest<SendUserRequest> requestRest(@RequestBody SendUserRequest sendUserRequest) {
        Rest<SendUserRequest> requestRest = new Rest<>();
        requestRest.setData(sendUserRequest);
        return requestRest;
    }

    @PostMapping("/listDomain")
    @ApiOperation(value = "listDomain", notes = "针对属性是集合的example")
    public Rest<ListDomain> listDomain(@RequestBody ListDomain sendUserRequest) {
        Rest<ListDomain> requestRest = new Rest<>();
        requestRest.setData(sendUserRequest);
        return requestRest;
    }

    @PostMapping("/sendReciptUser")
    @ApiOperation(value = "用户注册sendReciptUser", notes = "填写用户信息注册用户sendReciptUser")
    public Rest<Recipt> sendReciptUser(@RequestBody Recipt recipt) {
        Rest<Recipt> requestRest = new Rest<>();
        requestRest.setData(recipt);
        return requestRest;
    }

    @PostMapping("/deepRequest")
    @ApiOperation(value = "请求参数多层", notes = "请求参数多层")
    public Rest<DeepRequest> deepRequest(@RequestBody DeepRequest sendUserRequest) {
        Rest<DeepRequest> requestRest = new Rest<>();
        requestRest.setData(sendUserRequest);
        return requestRest;
    }

    @PostMapping("/requestActInteger")
    @ApiOperation(value = "字符类型", notes = "字符类型")
    public Rest<ActInteger> requestActInteger(@RequestBody ActInteger sendUserRequest) {
        Rest<ActInteger> requestRest = new Rest<>();
        requestRest.setData(sendUserRequest);
        return requestRest;
    }


    @GetMapping("/sendUser1")
    @ApiOperation(value = "用户注册", notes = "填写用户信息注册用户")
    public Rest<SendUserRequest> requestGetRest(@ApiParam(value = "email") String email) {
        Rest<SendUserRequest> requestRest = new Rest<>();
        SendUserRequest sendUserRequest = new SendUserRequest();
        sendUserRequest.setEmail(email);
        requestRest.setData(sendUserRequest);
        return requestRest;
    }

}
