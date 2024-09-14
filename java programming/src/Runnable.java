public class Runnable {
    public static void main(String[] args) {
        //set user information
       //person  person1=new person();
       //person  person2=new person();
      // person person3=new person();

        Person person1 = new Person("Parmila", 45, 6);
        Person person2 = new Person("Mohammad", 32, 5);
        Person person3 = new Person("AHMAD", 40, 8);
        System.out.println(" The name of the Person " + person1.getName());
        System.out.println(" The name of the Person " + person2.getName());
        System.out.println(" The name of the Person " + person3.getName());
    }
}