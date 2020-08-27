package cn.woukfun.service.company;

import cn.woukfun.domain.company.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyService {
    //查询所有企业
    public List<Company> findAll();
    //添加
    public void save(Company company);
    //删除
    public void update(Company company);
    //更新页面
    public void toUpdate(String id);
    //根据id查找企业
    public Company findById(String id);
    //根据id删除企业
    public void deleteById(String id);
    //分页查询企业
    public PageInfo<Company> findByPage(int pageNum, int pageSize);
 }
