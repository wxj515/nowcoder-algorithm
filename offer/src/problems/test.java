package Problems;

class a {
    public a(){
        System.out.println("a");
    }
    {
        System.out.println("a class");
    }
    static {
        System.out.println("sta a");
    }
}

class b extends a{
    public b(){
        System.out.println("b");
    }
    static {
        System.out.println("b class");
    }
    static {
        System.out.println("sta b");
    }
}
public class test {
    public static void main(String[] args) {
        b c;
        c = new b();
    }
}

