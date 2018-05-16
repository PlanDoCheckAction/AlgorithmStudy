package BinarySearchTree.PredecessorAndSuccessorInBST;

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

 // ���Զ����������е�predecessor��successor��������
 public static void main(String[] args) {

     // ���� 0 �� N-1 һ�� N �����ֵ�����
     int N = 1000;
     ArrayList<Integer> nums = new ArrayList<Integer>();
     for( int i = 0 ; i < N ; i ++)
         nums.add(i);

     // �������е���������
     shuffle(nums);

     // �����N�������뵽��������
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     for(Integer num: nums)
         bst.insert(num, num);

     // ����ǰ���㷨, ��������0û��ǰ��, ÿ������x��ǰ��Ӧ��Ϊx-1
     for(int i = 0 ; i < N ; i ++) {
         if (i == 0) {
             assert bst.predecessor(i) == null;
             System.out.println("The predesessor of 0 is NULL");
         } else {
             assert bst.predecessor(i) == i - 1;
             System.out.println("The predesessor of " + i + " is " + (i - 1));
         }
     }

     System.out.println();

     // ���Ժ���㷨, ��������û��N-1���, ÿ������x�ĺ��Ӧ��Ϊx+1
     for(int i = 0 ; i < N ; i ++){
         if( i == N-1 ){
             assert bst.successor(i) == null;
             System.out.println("The successor of " + i + " is NULL");
         }
         else{
             assert bst.successor(i) == i+1;
             System.out.println("The successor of " + i + " is " + (i+1));
         }
     }
 }
}
