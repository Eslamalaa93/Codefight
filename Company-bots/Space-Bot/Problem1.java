boolean launchSequenceChecker(String[] systemNames, int[] stepNumbers) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < systemNames.length; i++) {
            if (map.get(systemNames[i]) == null) {
                map.put(systemNames[i], stepNumbers[i]);
            } else {
                if (map.get(systemNames[i]) >= stepNumbers[i]) {
                    return false;
                }
                map.put(systemNames[i], stepNumbers[i]);
            }
        }
        return true;
    }