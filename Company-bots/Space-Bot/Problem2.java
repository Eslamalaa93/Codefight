 String packetDescrambler(int[] seq, char[] fragmentData, int n) {
        String result = "";
        TreeMap<Integer, TreeMap<String, Integer>> map = new TreeMap<>();
        for (int i = 0; i < seq.length; i++) {
            if (map.get(seq[i]) == null) {
                TreeMap<String, Integer> m = new TreeMap<>();
                String s = "" + fragmentData[i];
                m.put(s, 1);
                map.put(seq[i], m);
            } else {
                TreeMap<String, Integer> m = (TreeMap<String, Integer>) map.get(seq[i]);
                String s = "" + fragmentData[i];
                if (m.get(s) == null) {
                    m.put(s, 1);
                } else {
                    m.put(s, m.get(s) + 1);
                }
                map.put(seq[i], m);
            }
        }
        int prev = -1, size = 0;
        for (Map.Entry mm : map.entrySet()) {
            TreeMap<String, Integer> m = (TreeMap<String, Integer>) mm.getValue();
            int max = 0;
            String append = "";
            for (Map.Entry mm2 : m.entrySet()) {
                if (max < (int) mm2.getValue()) {
                    append = (String) mm2.getKey();
                    max = (int) mm2.getValue();
                }
            }
            if ((max * 100) / n <= 50 || (append.equals("#") && size + 1 < map.size()) || (int) mm.getKey() - prev > 1) {

                return "";
            } else {
                result += append;
            }

            prev = (int) mm.getKey();
            size++;
        }

        return result;
    }
