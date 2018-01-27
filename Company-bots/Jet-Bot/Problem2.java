String[][] catalogUpdate(String[][] catalog, String[][] updates) {
        TreeMap<String,ArrayList<String> > cat = new TreeMap<String,ArrayList<String> >();
        for(int i=0;i<catalog.length;i++){
            ArrayList<String>s = new ArrayList<String>();
            
            for(int j=1;j<catalog[i].length;j++)
                s.add(catalog[i][j]);
            
           Collections.sort(s);
           cat.put(catalog[i][0], s);
        }
        
        for(int i=0;i<updates.length;i++){
            ArrayList<String>s = new ArrayList<String>();
            if(cat.get(updates[i][0])!= null)
                s = cat.get(updates[i][0]);
            for(int j=1;j<updates[i].length;j++)
                s.add(updates[i][j]);
           
            Collections.sort(s);
           cat.put(updates[i][0], s);
        }
        String[][] catalogUpdate = new String[cat.size()][];
        int indx = 0;
        for(Map.Entry m: cat.entrySet()){
            ArrayList<String>s = (ArrayList<String>)m.getValue();
              catalogUpdate[indx] = new String[s.size()+1];
            catalogUpdate[indx][0] =(String) m.getKey();
            
            for(int i=0;i<s.size();i++){
                catalogUpdate[indx][i+1] = s.get(i);
            }
            
            indx++; 
        }
        return catalogUpdate;
    }