package cn.woukfun.service.company.impa;

import cn.woukfun.dao.company.CompanyDao;
import cn.woukfun.domain.company.Company;
import cn.woukfun.service.company.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    //新增企业
    @Override
    public void save(Company company) {
        //由于company目前没有id，新增的时候需要设置id，这里的id不是int的增类型，是uuid
        company.setId(UUID.randomUUID().toString());
        companyDao.save(company);
    }

    //更新企业
    @Override
    public void update(Company company) {
        companyDao.update(company);

    }

    @Override
    public void toUpdate(String id) {
        companyDao.findById(id);
    }

    @Override
    public Company findById(String id) {
        return companyDao.findById(id);
    }

    @Override
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    @Override
    public PageInfo<Company> findByPage(int pageNum, int pageSize) {
        //设置当前页面大小
        PageHelper.startPage(pageNum, pageSize);
        //查询企业的所有
        List<Company> list = companyDao.findAll();
        //构建一个PageInfo对象
        PageInfo<Company> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }


}
