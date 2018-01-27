int[] tasksTypes(int[] deadlines, int day) {
    int result[] = new int[3];
    for(int i=0;i<deadlines.length;i++){
        if(deadlines[i] <= day)result[0]++;
        else if (day+7 >= deadlines[i])result[1]++;
        else result[2]++;
    }
    return result;
}