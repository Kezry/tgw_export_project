package cn.woukfun.test;

import cn.woukfun.domain.company.Company;
import cn.woukfun.service.company.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @Test
    public void test01() {
        List<Company> list = companyService.findAll();
        System.out.println("企业列表" + list);
    }
}