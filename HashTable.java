

class HashTable{
	    public int hash(int id){ return id%10;}
	
        private HNode[] head=new HNode[10];
        
	    public  HashTable(){for(int i=0;i<10;i++)head[i]=null;}

		public  void insert(int k, String nm, int a, String at)
	        {      HNode temp =new HNode(k,nm,a,at);
	               int index=hash(k);
	               temp.next=head[index];
			       head[index]=temp;}

		public  HNode[] readHNode() {return head;}
		
		
		public  HNode search(int k)
	        {     
			int index=hash(k);
			HNode temp=head[index];	 
			boolean found=false;
			while(temp!=null&&found==false) {
				   if (temp.key==k){found=true; break;}
	               temp=temp.next;
	        }
            return temp;}

		 public  void delete(int k)
	        {     
			        int index=hash(k);
			        System.out.println("Index="+index);
	                HNode temp=head[index];	
	                
	                  // 1. head[index]-> null - list empty
	                if (temp==null) return;

	                        // 2. Only 1 item in list 
	                if (temp.next==null){
	                     if (temp.key==k){
	                         head[index]=null;}
	                     return;
	                    }
	                
	                      // 3. Item to be deleted is first in list
	                if (temp.key==k) {
	                	head[index]=temp.next;
	                	return;
	                }
	                
	                
	                    // 4. Its not the first item in list

			        boolean found=false;
	                HNode prev=temp;
	                temp=temp.next;
	     
			        while(temp!=null&&found==false) {
				            if (temp.key==k)
	                               {found=true; 
	                                prev.next=temp.next;
	                                return;}
				            prev=temp;
	                        temp=temp.next;
	                 }
	                }

		
   }


   