public class TestChineseRemainderTheorem {

    public static void main(String[] args) {

        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem(999,998,997,995);
        long a = chineseRemainderTheorem.add(123684,413456);
        System.out.println(a);
        a= chineseRemainderTheorem.multiply(123684,413456);
        System.out.println(a);

    }

}
