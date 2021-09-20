package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.com.ssm1.bean.Category;
import test.com.ssm1.service.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-04 16:13
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*
        一级分类

     */

    //一级分类查询
    @GetMapping("/oneLevelUI")
    public String getOneLevelUI(){
        return "oneLevelUI";
    }

    @RequestMapping("/oneLevelPageMsg")
    @ResponseBody
    public Map<String,Object> oneLevelPageMsg(Integer page,Integer limit,Integer pId){

//        System.out.println("--=====:page:"+page+",limit:=====--:"+limit+",====---pid:"+pId);

//        Map<String,Object> param = new HashMap<>();
//        param.put("start",(page-1)*limit);
//        param.put("limit",limit);
//        param.put("level",1);
//        List<Category> data = categoryService.getCategoryLevelAll(param);
//
//        int count  = categoryService.getCategoryLevelCount();
//
//       Map<String,Object> result = new HashMap<>();
//
//        //{"code":0,"msg":"","count":1000,"data":[{"
//        result.put("code",0);
//        result.put("msg","");
//        result.put("count",count);
//        result.put("data",data);
//
//        return result;

        return  getPage(page, limit, 1,pId);
    }

    private Map<String,Object> getPage(Integer page,Integer limit,Integer level,Integer pId){
        Map<String,Object> param = new HashMap<>();
        param.put("start",(page-1)*limit);
        param.put("limit",limit);
        param.put("level",level);
        param.put("pId",pId);
        List<Category> data = categoryService.getCategoryLevelAll(param);

        int count  = categoryService.getCategoryLevelCount(param);

        Map<String,Object> result = new HashMap<>();

        //{"code":0,"msg":"","count":1000,"data":[{"
        result.put("code",0);
        result.put("msg","");
        result.put("count",count);
        result.put("data",data);

        return result;
    }

//    //一级分类新增
//    @RequestMapping("/addOneLevelUI")
//    public String addOneLevelUI(){
//        return "addOneLevelUI";
//    }

    //转发
    @RequestMapping("/forwardPage/{path}")
    public String forwardPage(@PathVariable("path") String path){
        return path;
    }

    //一级分类新增
    @RequestMapping("/addOneLevel")
    @ResponseBody
    public boolean addOneLevel(Category category){
//        Category category = new Category();

        Map<String,Object> param = new HashMap<>();
        param.put("level",1);
        //只有name    需要 order(数据库获取) level
//        category.setName(name);
        int maxorder = categoryService.getMaxOrder(param);
        category.setLevel(1);
        category.setOrder(maxorder+1);

//        System.out.println(category+"-----------------------------------------------------------");

        return categoryService.addCategory(category);

    }

    //删除
    @RequestMapping("/deleteCategory/{id}")
    @ResponseBody
    public boolean deleteCategory(@PathVariable("id") Integer id){
        return categoryService.delete(id);
    }

    //修改
    @RequestMapping("/updateCategory")
    @ResponseBody
    public boolean updateCategory(String name, String id){//"name":name,"id":id
        System.out.println(name+","+id+"---------------------------------");
        return categoryService.updateCategory(name,id);
    }

    @PostMapping("/upMove/{id}")
    @ResponseBody
    public boolean upMove(@PathVariable("id") Integer id){
        System.out.println("-----------------------------------id:"+id);
        return categoryService.upMove(id);
    }
    @PostMapping("/downMove")
    @ResponseBody
    public boolean downMove(Integer id,Integer pId){
        return categoryService.downMove(id,pId);
    }




    /*
        二级分类
     */
    //二级分类查询
    @GetMapping("/twoLevelUI")
    public String getTwoLevelUI(Model model){
        List<Category> c = categoryService.selectLevel(1);
        model.addAttribute("categorys",c);
        return "twoLevelUI";
    }

    @RequestMapping("/twoLevelPageMsg")
    @ResponseBody
    public Map<String,Object> twoLevelPageMsg(Integer page,Integer limit,Integer pId){
//        System.out.println("-----:page:"+page+",limit:-----------:"+limit+",-----------pid:"+pId);
        return getPage(page, limit, 2,pId);
    }

    //二级分类新增


}
