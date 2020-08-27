package cn.woukfun.test;

import cn.woukfun.dao.company.CompanyDao;
import cn.woukfun.domain.company.Company;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class PageTest {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testPage() {
        //设置当且页面大小
        PageHelper.startPage(1,3);
        //查询页面所有数据
        List<Company> list = companyDao.findAll();
        //构建一个PageInfo对象
        PageInfo<Company> pageInfo = new PageInfo<>(list);
        System.out.println("当前页" + pageInfo.getPageNum());
        System.out.println("页面大小" + pageInfo.getPageSize());
        System.out.println("总记录数" + pageInfo.getTotal());
        System.out.println("总页数" + pageInfo.getPages());
        System.out.println("页面数据" + pageInfo.getList());
    }

}
