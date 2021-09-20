package test.com.ssm1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.com.ssm1.bean.Product;
import test.com.ssm1.dao.ProductMapper;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-05 19:45
 */
@Service
public class ProductService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public boolean addProduct(Product product) {
        return sqlSession.getMapper(ProductMapper.class).addProduct(product) == 1;
    }

    public List<Product> listPage(Map<String, Integer> params) {
        return sqlSession.getMapper(ProductMapper.class).listPage(params);
    }

    public int getCount(Integer categoryId) {
        return sqlSession.getMapper(ProductMapper.class).getCount(categoryId);
    }

    public void saveImgPath(String path, int first, Integer id) {

        sqlSession.getMapper(ProductMapper.class).saveImgPath(path,first,id);

    }

    public void deleteAllFile(Integer id) {
        sqlSession.getMapper(ProductMapper.class).deleteAllFile(id);
    }
}
