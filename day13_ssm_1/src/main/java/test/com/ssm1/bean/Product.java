package test.com.ssm1.bean;

/**
 * @author zero
 * @create 2020-06-05 20:45
 */
public class Product {

    private Integer id;
    private String shortTitle;
    private String longTitle;
    private double price;
    private int nums;
    private int sales;
    private int categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", shortTitle='" + shortTitle + '\'' +
                ", longTitle='" + longTitle + '\'' +
                ", price=" + price +
                ", nums=" + nums +
                ", sales=" + sales +
                ", categoryId=" + categoryId +
                '}';
    }
}
