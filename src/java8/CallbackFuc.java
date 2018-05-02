package java8;

public class CallbackFuc {
    private static void test(Integer num){
        System.out.println(num); // 1.输出5
        if(num<10){ // 2.满足条件
            test(num*num); // 3.回调test(25)

//            【
//                    System.out.println(num); // 4.输出25
//                    if(num<10){ // 5.不满足条件
//                        test(num*num);
//                    }
//                    System.out.println(num); // 6.输出25
//            】
        }
        System.out.println(num); // 7.输出5
    }

    public static void main(String[] args) {
        test(5);
    }
}
