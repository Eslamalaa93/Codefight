String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        int days[] = ParseDayoftheWeek(daysOfTheWeek);
        String result[] = new String[n]; 
        Arrays.sort(days);
        
        try {
            int indx = 0;
            Date d = form.parse(firstDate);
            while (n > 0){
                int c = 0;
                for(int i = 0;i<7;i++){
                     Date d2 = (Date)d.clone();
                     d2.setDate(d2.getDate()+i);
                    if(Arrays.binarySearch(days,d2.getDay()) >= 0){
                        result[indx] = form.format(d2);
                        indx++;
                        n--;
                        c++;
                    }
                    if(c == days.length)break;
                }
                d.setDate(d.getDate()+(k*7));
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    return  result;
    }

    public int[] ParseDayoftheWeek(String[] daysOfTheWeek) {
        int result[] = new int[daysOfTheWeek.length];//"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        for (int i = 0; i < daysOfTheWeek.length; i++) {
            if (daysOfTheWeek[i].equals("Sunday")) {
                result[i] = 0;
            } else if (daysOfTheWeek[i].equals("Monday")) {
                result[i] = 1;
            } else if (daysOfTheWeek[i].equals("Tuesday")) {
                result[i] = 2;
            } else if (daysOfTheWeek[i].equals("Wednesday")) {
                result[i] = 3;
            } else if (daysOfTheWeek[i].equals("Thursday")) {
                result[i] = 4;
            } else if (daysOfTheWeek[i].equals("Friday")) {
                result[i] = 5;
            } else if (daysOfTheWeek[i].equals("Saturday")) {
                result[i] = 6;
            }
        }
        return result;
    }
