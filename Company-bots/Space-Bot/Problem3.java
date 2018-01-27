boolean allExec(boolean execute[]) {
        for (int i = 0; i < execute.length; i++) {
            if (execute[i] == false) {
                return false;
            }
        }
        return true;
    }

    String cpuEmulator(String[] subroutine) {
        boolean execute[] = new boolean[subroutine.length];
        Arrays.fill(execute,false);
        long arr[] = new long[43];
        Arrays.fill(arr,0);
        long size = (long)Math.pow(2,32); 
        while (!allExec(execute)) {
            
            for (int i = 0; i < subroutine.length; i++) {
                subroutine[i]  = subroutine[i].replace(",", " ");
                String split[] = subroutine[i].split(" ");
                if (split[0].equals("MOV")) {
                    if (Character.isAlphabetic(split[1].charAt(0))) {
                        int findx = Integer.parseInt(split[1].substring(1));
                        int lindx = Integer.parseInt(split[2].substring(1));
                        arr[lindx] = arr[findx];
                    } else {
                        long value = Long.parseLong(split[1]);
                        int lindx = Integer.parseInt(split[2].substring(1));
                        arr[lindx] = value;
                    }
                    execute[i] = true;
                }
                else if(split[0].equals("ADD")){
                        int findx = Integer.parseInt(split[1].substring(1));
                        int lindx = Integer.parseInt(split[2].substring(1));
                       
                        arr[findx] = (arr[findx]+arr[lindx])%size;
                        
                        execute[i] = true;
                }
                else if(split[0].equals("DEC")){
                    int findx = Integer.parseInt(split[1].substring(1));
                    if(arr[findx]==0) arr[findx] = (long)size-1;
                    else    
                    arr[findx]--;
                    execute[i] = true;
                }
                else if(split[0].equals("INC")){
                int findx = Integer.parseInt(split[1].substring(1));
                    if(arr[findx] == size-1)arr[findx] = 0;
                  else  
                  arr[findx]++;
                  execute[i] = true;
                }
                else if(split[0].equals("INV")){
                int findx = Integer.parseInt(split[1].substring(1));
                    arr[findx] = size + ~arr[findx];
                    execute[i] = true;
                }
                else if(split[0].equals("JMP")){
                    execute[i] = true;
                    i = Integer.parseInt(split[1]) - 2;
                    
                }
                else if(split[0].equals("JZ") && arr[0] == 0){
                    execute[i] = true;
                    i = Integer.parseInt(split[1]) - 2;
                }
                else
                    execute[i] = true;        
            }
            
        }
    
        return Long.toString(arr[42]);
    }