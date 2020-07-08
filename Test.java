给定一个 没有重复 数字的序列，返回其所有可能的全排列。

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        back(new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }
    private void back(List<Integer> row,int[] nums,boolean[] v){
        if(row.size()==nums.length){
            res.add(new ArrayList(row));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!v[i]){
                row.add(nums[i]);
                v[i]=true;
                back(row,nums,v);
                row.remove(row.size()-1);
                v[i]=false;
            }
        }
    }
}

给定一个可包含重复数字的序列，返回所有不重复的全排列。

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        back(nums,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    private void back(int[] nums,List<Integer> row,boolean[] v){
        if(row.size()==nums.length){
            res.add(new ArrayList(row));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(v[i]){
                continue;
            }
            if(i!=0&&nums[i]==nums[i-1]&&!v[i-1]){
                continue;
            }
            row.add(nums[i]);
            v[i]=true;
            back(nums,row,v);
            row.remove(row.size()-1);
            v[i]=false;
        }
    }
}