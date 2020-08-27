package cn.woukfun.web.controller;

import cn.woukfun.domain.company.Company;
import cn.woukfun.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

/*    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List<Company> list = companyService.findAll();
        //把业务存储Dao域中
        request.setAttribute("list", list);
        return "company/company-list";
    }

    @RequestMapping("/save")
    public String save(Date birthday) {
        System.out.println(birthday);
        return "success";
    }*/

    /*进入添加页面*/
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "company/company-add";
    }
}
