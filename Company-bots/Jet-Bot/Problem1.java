int packageBoxing(int[] pkg, int[][] boxes) {
    int indx=-1,v=Integer.MAX_VALUE;
    Arrays.sort(pkg);
    for(int i=0;i<boxes.length;i++){
        Arrays.sort(boxes[i]);
        if(pkg[0] <= boxes[i][0] && pkg[1] <= boxes[i][1] && pkg[2] <= boxes[i][2]){
            int vol = boxes[i][0]*boxes[i][1]*boxes[i][2];
         if(v > vol){
             v = vol;
             indx = i;
         }
        }
        
    }
    return indx;
}