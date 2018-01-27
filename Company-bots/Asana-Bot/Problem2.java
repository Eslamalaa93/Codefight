class Person implements Comparable<Person>{

      public  String name="";
       public int proj=0;
        public int tasks=0;
        public Person(String na,int p,int t){
            name = na;
            proj = p;
            tasks = t;       
        }

        @Override
        public int compareTo(Person o) {
           if(tasks < o.tasks)return -1;
           else if(tasks > o.tasks)return 1;
           return proj <= o.proj? -1:1;
        }
    }

    String smartAssigning(String[] names, boolean[] statuses, int[] projects, int[] tasks) {
           ArrayList<Person>persons =  new ArrayList<>();
           for(int i=0;i<tasks.length;i++){
               if(!statuses[i]){
                Person p  = new Person(names[i], projects[i], tasks[i]);
                persons.add(p);
               }
           }
        
           Collections.sort(persons);
           
           return persons.get(0).name;
    }
