package cn.woukfun.service.company.impa;

import cn.woukfun.dao.company.CompanyDao;
import cn.woukfun.domain.company.Company;
import cn.woukfun.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
