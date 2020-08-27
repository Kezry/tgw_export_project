package cn.woukfun.dao.company;

import cn.woukfun.domain.company.Company;

import java.util.List;

public interface CompanyDao {

    //查询全部企业
    List<Company> findAll();
    void save(Company company);
    void update(Company company);
    Company findById(String id);
    void deleteById(String id);
}
