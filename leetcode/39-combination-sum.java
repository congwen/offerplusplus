import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();//返回结果
        List<Integer> path=new ArrayList<>();//保存中间结果
        Arrays.sort(candidates);//排序后，当其中的某个元素大于target时，之后的元素不用再计算了
        backtrace(candidates,target,res,0,path);
        return res;

    }
    public void backtrace(int[] candidates,int target,List<List<Integer>> res,int i,List<Integer> path){
        if(target<0) return;// 剪枝
        if(target==0){//找到解   
            res.add(new ArrayList<>(path));//复制结果
        }
        for(int start=i;start<candidates.length;start++){
            if(target>=0){//剪枝，只处理满足条件的数据
                path.add(candidates[start]);//存入数据
                backtrace(candidates,target-candidates[start],res,start,path);//递归，元素可以重复，所以start没有递增
                path.remove(path.size()-1);//回溯
            }
        }
    }
}