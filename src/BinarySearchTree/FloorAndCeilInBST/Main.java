package BinarySearchTree.FloorAndCeilInBST;

import java.util.ArrayList;

//���Զ����������е�floor��ceil��������
public class Main {

 // ��������˳��
 private static void shuffle(ArrayList arr){

     for(int i = arr.size()-1 ; i >= 0 ; i --){
         int pos = (int) (Math.random() * (i+1));
         Object t = arr.get(pos);
         arr.set(pos, arr.get(i));
         arr.set(i, t);
     }
 }

 // ���Զ����������е�floor��ceil��������
 public static void main(String[] args) {

     BST<Integer, Integer> bst = new BST<Integer, Integer>();

     //��[0, N)֮���ż��������nums��
     int N = 1000;
     ArrayList<Integer> nums = new ArrayList<Integer>();
     for(int i = 0 ; i < N ; i += 2)
         nums.add(i);
     int minNum = nums.get(0);
     int maxNum = nums.get(nums.size()-1);

     // ��nums������
     shuffle(nums);

     // ������������в���[0, N)֮�������ż��
     for(Integer num: nums)
         bst.insert(num, num);

     // ��[0...N]�������N+1����, ���ö�����������floor��ceil, �鿴����
     for( int i = 0 ; i < N ; i ++ ){

         // ����floor
         Integer floorKey = bst.floor(new Integer(i));
         if(i % 2 == 0){
             if(i >= 0 && i < N) assert floorKey == i;
             else if(i < 0)      assert floorKey == null;
             else                assert floorKey == maxNum;
         }
         else{
             if(i - 1 >= 0 && i - 1 < N) assert floorKey == i - 1;
             else if(i - 1 < 0)          assert floorKey == null;
             else                        assert floorKey == maxNum;
         }

         System.out.print( "The floor of " + i + " is ");
         if( floorKey == null )
             System.out.println("NULL");
         else
             System.out.println(floorKey);


         // ����ceil
         Integer ceilKey = bst.ceil(new Integer(i));
         if(i % 2 == 0) {
             if( i >= 0 && i < N ) assert ceilKey == i;
             else if(i < 0)        assert ceilKey == minNum;
             else                  assert ceilKey == null;
         }
         else{
             if(i + 1 >= 0 && i + 1 < N) assert ceilKey == i + 1;
             else if(i + 1 < 0)          assert ceilKey == minNum;
             else                        assert ceilKey == null;
         }

         System.out.print( "the ceil of " + i + " is ");
         if( ceilKey == null )
             System.out.println("NULL");
         else
             System.out.println(ceilKey);

         System.out.println();
     }
 }
}
