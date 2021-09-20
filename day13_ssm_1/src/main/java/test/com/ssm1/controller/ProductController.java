package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.com.ssm1.bean.Category;
import test.com.ssm1.bean.Product;
import test.com.ssm1.service.CategoryService;
import test.com.ssm1.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author zero
 * @create 2020-06-05 19:44
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //转发  转发前查询出所有一级分类
    @GetMapping("/forwardPages/{path}")
    public String forwardPages(@PathVariable("path") String path, Model model){

        List<Category> c = categoryService.selectLevel(1);
        System.out.println(c);
        model.addAttribute("category",c);

        return path;
    }

//    @GetMapping("/addProductUI")
//    public String forwardPages(Model model){//@PathVariable("path") String path,
//
//        List<Category> c = categoryService.selectLevel(1);
//        System.out.println(c);
//        model.addAttribute("category",c);
//
//        return "addProductUI";
//    }

    @RequestMapping("/twoLevelMsg/{pId}")
    @ResponseBody
    public List<Category> twoLevelMsg(@PathVariable("pId") Integer pId){
        System.out.println("pid:"+pId);
        return categoryService.twoLevelMsg(pId,2);
    }

    //addProduct
    @PostMapping("/addProduct")
    @ResponseBody
    public boolean addProduct(Product product){
        System.out.println(product+"--------------------------------------");
        return productService.addProduct(product);
//        return false;
    }

    @RequestMapping("/productListPage")
    @ResponseBody
    public Map<String,Object> productListPage(Integer page,Integer limit,Integer categoryId){

        System.out.println("page:"+page+",limit:"+limit+",categoryId:"+categoryId);

        Map<String,Integer> params = new HashMap<>();
        params.put("start",(page-1)*limit);
        params.put("limit",limit);
        params.put("categoryId",categoryId);
        List<Product> List = productService.listPage(params);

        System.out.println(List);

        int count = productService.getCount(categoryId);

        //{"code":0,"msg":"","count":1000,"data":[{"i
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("msg","");
        result.put("count",count);
        result.put("data",List);

        return result;
    }

    @GetMapping("/productImgAddUI/{id}")
    public String productImgAddUI(@PathVariable("id") Integer id,Model model){
        model.addAttribute("id",id);
        return "productImgAdd";
    }

    //添加图片
    @PostMapping("/addImg")
    public String addImg(Integer id,MultipartFile firstImg, List<MultipartFile> otherImg, HttpServletRequest request) throws IOException {
        System.out.println("id:"+id+",-------------------------------");

        //添加前删除以前的图片
        productService.deleteAllFile(id);

        ///product/addImg
//        System.out.println("getServletPath:"+request.getServletPath());

        //D:\developer_tools\apache-tomcat-9.0.35-windows-x64\apache-tomcat-9.0.35\webapps\day13_ssm_1\statics\images\Snipaste_2020-05-24_01-54-54.png
        //D:\developer_tools\apache-tomcat-9.0.35-windows-x64\apache-tomcat-9.0.35\webapps\day13_ssm_1\statics\images\bb3c5381-86c4-4b7b-8fae-1a8c080ad153.jpg
//        System.out.println("getRealPath:"+request.getServletContext().getRealPath("statics/images/Snipaste_2020-05-24_01-54-54.png"));

        //存放地址
        String realPath = request.getServletContext().getRealPath("statics/images");
        System.out.println("存放地址:"+realPath);

        String uuid = UUID.randomUUID().toString();

        //获取文件后缀
//        System.out.println("firstImg:"+firstImg.getOriginalFilename());
        String suffix = firstImg.getOriginalFilename().substring(firstImg.getOriginalFilename().lastIndexOf("."));
        //拼装文件路径
        String filePath = realPath + "\\" + uuid + suffix;
        System.out.println("拼装文件路径:"+filePath);

        //将文件存储到服务器上
        firstImg.transferTo(new File(filePath));

        //将图片存放到数据库
        String savePath = "\\statics\\images\\"+ uuid + suffix;
        productService.saveImgPath(savePath,1,id);

        /*--------------------------------------------*/

        for (MultipartFile i : otherImg){
//            System.out.println("other:"+i.getOriginalFilename());
            String uuidf = UUID.randomUUID().toString();
            String substring = i.getOriginalFilename().substring(i.getOriginalFilename().lastIndexOf("."));

            String s = realPath + "\\" + uuidf + substring;

            i.transferTo(new File(filePath));

            String savePathF = "\\statics\\images\\"+ uuidf + substring;
            productService.saveImgPath(savePathF,0,id);

        }

        return "redirect:forwardPages/listProductUI";
    }




}
