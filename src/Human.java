public class Human {
    // thuoc tinh
    public String name ;
    public int age;
    public String phone ;
    // public o dau cung goi dc

    //ham tao
    public Human(){
        this.name = " no name";
        this.age = 10;
        this.phone = " 0123456789";
    }

    public Human(String name, int age,  String phone){
        this.name = name;
        this.age = age ;
        this.phone = phone;
    }
    // this  dai dien cho chinh object di ra tu class

    // phuong thuc
    public void eat() {
        System.out.println("Eating..");
    }

    public void sleep(int duration){
        System.out.println("sleeping in " + duration + " hour..");
    }
}
