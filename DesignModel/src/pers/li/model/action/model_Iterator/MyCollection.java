package pers.li.model.action.model_Iterator;

public class MyCollection implements Collection {
      
        public String string[] = null;
//        public String string[] = {"A","B","C","D","E"};
        public MyCollection(String[] string){
            this.string=string;
        }

        @Override  
        public Iterator iterator() {  
            return new MyIterator(this);  
        }  
      
        @Override  
        public Object get(int i) {  
            return string[i];  
        }  
      
        @Override  
        public int size() {  
            return string.length;  
        }  
    }  
