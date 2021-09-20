package spring_1.helloworld;

public class HelloWorld {

    private String user;

    public HelloWorld() {
        System.out.println("HelloWorld's constructor...");
    }

    public HelloWorld(String user) {
        System.out.println("HelloWorld 构造器");
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        System.out.println("setUser:"+user);
        this.user = user;
    }

    public void hello(){
        System.out.println("Hello:"+user);
    }
}
