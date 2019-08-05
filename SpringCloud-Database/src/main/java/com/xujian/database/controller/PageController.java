package com.xujian.database.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xujian.database.entity.Country;
import com.xujian.database.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xujian on 2019-08-04
 */
@RestController
public class PageController {
    @Autowired
    private CountryMapper countryMapper;

    //http://localhost:8080/getCountry?pageNo=3&pageSize=10
    @RequestMapping("/getCountry")
    public List<Country> getCountries(HttpServletRequest request) {
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        //只有紧接着PageHelper.startPage(2,3); 后的那句sql才会进行分页，再下一句sql则不分页。
        PageHelper.startPage(pageNo, pageSize, false);
        PageHelper.orderBy("countryname DESC  ");
        //PageHelper.orderBy("countryname DESC, countrycode ASC  ");

        List<Country> countries = countryMapper.findAll();
        System.out.println("Total: " + ((Page) countries).getTotal());
        for (Country country : countries) {
            System.out.println("Country Name: " + country.getCountryname());
        }

        return countries;
    }
}
