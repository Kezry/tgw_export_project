package cn.woukfun.web.controller;

import cn.woukfun.domain.company.Company;
import cn.woukfun.service.company.CompanyService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

/*
    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        List<Company> list = companyService.findAll();
        //把业务存储Dao域中
        request.setAttribute("list", list);
        return "company/company-list";
    }
*/

    /**
     * 分页查询所有企业
     * @param birthday
     * @return
     */
    @RequestMapping("/list")
    public String list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "5") int pageSize,
            HttpServletRequest request) {
        List<Company> list = companyService.findAll();
        //把业务存储Dao域中
        request.setAttribute("list", list);
        PageInfo<Company> pageInfo = companyService.findByPage(pageNum, pageSize);
        request.setAttribute("pageInfo", pageInfo);
        return "company/company-list";
    }

    @RequestMapping("/save")
    public String save(Date birthday) {
        System.out.println(birthday);
        return "success";
    }

    /*进入添加页面*/
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "company/company-add";
    }

    @RequestMapping("/edit")
    public String edit(Company company) {
        if (StringUtil.isEmpty(company.getId())) {
            companyService.save(company);
        } else {
            companyService.update(company);
        }
        return "redirect:/company/list.do";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(String id) {
        ModelAndView mv = new ModelAndView();
        //根据id查找页面
        Company company = companyService.findById(id);
        //保存到域
        mv.addObject("company",company);
        //设置返回的jsp页面
        mv.setViewName("company/company-update");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        companyService.deleteById(id);
        return "redirect:/company/list.do";
    }



}
