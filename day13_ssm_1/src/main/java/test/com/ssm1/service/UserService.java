package test.com.ssm1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.com.ssm1.bean.User;
import test.com.ssm1.dao.UserMapper;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-02 23:44
 */
@Service
public class UserService {


    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> test(){
        return sqlSession.getMapper(UserMapper.class).test();
    }


    public List<User> listPage(Map<String, Integer> params) {

        return sqlSession.getMapper(UserMapper.class).listPage(params);

    }

    public int getCount() {
        return sqlSession.getMapper(UserMapper.class).getCount();
    }

    public boolean deleteById(Integer userId) {

        return sqlSession.getMapper(UserMapper.class).deleteById(userId) == 1;

    }

    @Transactional
    public boolean add(User user) {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = mapper.checkUserName(user.getUserName());

        if(u==null){
            return mapper.add(user) == 1;
        }else {
            return false;
        }


    }

    @Transactional
    public boolean updateById(User user) {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.updateById(user) == 1;

    }

    /**
     * 校验是否有相同的姓名
     * @param userName
     * @return
     */
    public boolean checkUserName(String userName) {

        User u = sqlSession.getMapper(UserMapper.class).checkUserName(userName);
//        System.out.println("---------------u:"+u);

        return u == null;


    }

    public User selectById(Integer id) {

        return sqlSession.getMapper(UserMapper.class).selectById(id);
    }

    /**
     * 登入
     * @param param
     * @return
     */
    public User getUserForUsernameAndUserpassword(Map<String, Object> param) {

        User u = sqlSession.getMapper(UserMapper.class).getUserForUsernameAndUserpassword(param);

        return u;

    }

    /**
     * 修改密码
     * @param param
     * @return
     */
    public int modifyPassword(Map<String, Object> param) {

        return sqlSession.getMapper(UserMapper.class).modifyPassword(param);

    }

    public void updateIcon(Map<String, Object> param) {

        sqlSession.getMapper(UserMapper.class).updateIcon(param);


    }

    public boolean updateRid(Integer uid, Integer rid) {

        return sqlSession.getMapper(UserMapper.class).updateRid(uid,rid) == 1;
    }
}
