 String[] chatBot(String[][] conversations, String[] currentConversation) {
        String curent[] = currentConversation.clone();
        Arrays.sort(curent);
        int max = 0, stop = 0, indx = 0;
        for (int i = 0; i < conversations.length; i++) {
            int m = 0, s = 0;
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int j = 0; j < conversations[i].length; j++) {
                if (Arrays.binarySearch(curent, conversations[i][j]) >= 0) {
                    if (map.get(conversations[i][j]) == null) {
                        m++;
                    }
                    s = j;
                    map.put(conversations[i][j], 1);
                }
            }
            if (max < m) {
                max = m;
                stop = s;
                indx = i;
            }
            map.clear();
        }

        ArrayList<String> r = new ArrayList<>(Arrays.asList(currentConversation));
        String conv[] = conversations[indx];
        if (max > 0) {

            for (int k = stop + 1; k < conv.length; k++) {
                r.add(conv[k]);
            }
        }
        return r.toArray(new String[r.size()]);
    }
