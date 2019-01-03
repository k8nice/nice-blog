class Resource{
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Demo1 implements Runnable{
    Resource resource;

    public Demo1(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int x = 0;
        while (true){
            if (x == 0){
                System.out.println(resource.getName());
                System.out.println(resource.getAge());
            }else {
                System.out.println("nice");
                System.out.println("123");
            }
           x= (x+1)%2;
        }
    }
}

class Demo2 implements Runnable{
    Resource resource;

    public Demo2(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
            while (true){
                resource.setName("bug");
                resource.setAge(18);
            }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Demo1 demo1 = new Demo1(resource);
        Demo2 demo2 = new Demo2(resource);
        Thread thread1 =new Thread(demo1);
        Thread thread2 =new Thread(demo2);
        thread1.start();
        thread2.start();
    }
}
