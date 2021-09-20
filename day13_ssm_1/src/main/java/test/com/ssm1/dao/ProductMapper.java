package test.com.ssm1.dao;

import org.apache.ibatis.annotations.Param;
import test.com.ssm1.bean.Product;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-05 19:44
 */
public interface ProductMapper {
    int addProduct(Product product);

    List<Product> listPage(Map<String, Integer> params);

    int getCount(@Param("categoryId") Integer categoryId);

    int saveImgPath(@Param("path") String path, @Param("first") Integer first,@Param("id") Integer id);

    void deleteAllFile(Integer id);
}
