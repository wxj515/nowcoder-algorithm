/**
 * 有猫狗两种宠物，按队列形式先进先出，但pollAll不限制类别，就是找出两种宠物那个进的更早
 * 解：定义新的结构，加入时间戳，实际就是个类似计数器count，标记进入的序号
 */
package Problems;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

public class DogAndCatQueue {

    public static class Pet {
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public void p(){
            System.out.println(type);
        }
    }

    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    public static class PetEnter{
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count){
            this.count = count;
            this.pet = pet;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }
    }

    public static class DogCatQueue{
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;

        public DogCatQueue(Queue<PetEnter> dogQ, Queue<PetEnter> catQ, long count) {
            this.dogQ = dogQ;
            this.catQ = catQ;
            this.count = 0;
        }

        public void add(Pet pet){
            if (pet.getType().equals("dog"))
                dogQ.add(new PetEnter(pet, count++));
            else if (pet.getType().equals("cat"))
                catQ.add(new PetEnter(pet, count++));
            else
                throw new RuntimeException("error");
        }

        public Pet pollAll(){
            if (!dogQ.isEmpty() && !catQ.isEmpty())
                return dogQ.peek().getCount() > catQ.peek().getCount() ? catQ.poll().getPet() : dogQ.poll().getPet();
            else if (dogQ.isEmpty())
                return catQ.poll().getPet();
            else if (catQ.isEmpty())
                return dogQ.poll().getPet();
            else
                throw new RuntimeException();
        }

        public Dog pollDog(){
            if (!dogQ.isEmpty())
                return (Dog) dogQ.poll().getPet();
            else
                throw new RuntimeException();
        }

        public Cat pollCat(){
            if (!catQ.isEmpty())
                return (Cat) catQ.poll().getPet();
            else
                throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.out.println(Pet.class.getName());
        Pet pet = new Pet("dog");
        System.out.println(pet.getClass().getName());
        Class c = pet.getClass();
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            if ("p".equals(m.getName()))
                m.invoke(pet);
        }
        c.getMethod("p").invoke(pet);
    }

}
