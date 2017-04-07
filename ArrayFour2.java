public static void main(String[] args){
        int[] input = {2,5,1,1,1,1,4,3,7,5,7};
        int[] sums = new int[input.length];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int tmp = 0;
        for (int i = 0; i < input.length; ++i) {
            tmp += input[i];
            sums[i] = tmp;
            hashMap.put(tmp, i);
        }

        for (int pos1 = 1; pos1 < input.length; ++pos1) {
            int sum = sums[pos1] - input[pos1];
            if (hashMap.containsKey(sum + sums[pos1])) {
                int pos2 = hashMap.get(sum + sums[pos1]) + 1;
                if (pos2 < input.length && hashMap.containsKey(sum + sums[pos2])) {
                    int pos3 = hashMap.get(sum + sums[pos2]) + 1;
                    if (pos3 < input.length && sums[sums.length - 1] - sums[pos3] == sum) {
                        System.out.println("result:"+pos1 + "---"+pos2+"----"+pos3);
                        return;
                    }
                }
            }
        }
        return;

    }
