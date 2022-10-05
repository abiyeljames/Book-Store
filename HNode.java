
class HNode {
	int key;
	String  name;
        int edition;
        String author;
	  HNode next;
	 
	HNode(int k, String nm, int a, String at)
		{ key = k;
		  name = nm;
            edition=a;
            author = at;
		  next = null;  }
	public int readKey(){return key;}
	public String readName(){return name;}
	public int readAge(){return edition;}
	public String readAuthor(){return author;}
	}