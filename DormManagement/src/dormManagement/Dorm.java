package dormManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
public class Dorm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7159495122199261102L;
	public enum types{FOR_BOYS,FOR_GIRLS}
	private String authorize_key=null;
	private String name;
	private types type;
	private int count_of_blocks=-1;
	private Manager mngr;
	private ArrayList<Block> blocks=new ArrayList<Block>();
	private ArrayList<Student>students=new ArrayList<Student>();
	public Dorm(String name,types type) {
		this.name=name;
		this.type=type;
		count_of_blocks=blocks.size();
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public String getName() {
		return name;
	}
	public Manager getMngr() {
		return mngr;
	}
	public boolean setMngr(Manager mngr,String key) {
		if(authorize_key==null) {
			this.mngr = mngr;
			return true;
		}
		else if(authorize_key.equals(key)) {
			authorize_key=null;
			this.mngr = mngr;
			return true;
		}
		else {
			return false;
		}
	}
	public String unsetMngr(Boolean lock) {
		mngr=null;
		if(lock) return getAuthorizeKey(22);
		else return null;
	}
	public int getCount_of_blocks() {
		return count_of_blocks;
	}
	public types getType() {
		return type;
	}
	public void setType(types t) {
		this.type=t;
	}
	public Block getLastBlock() {
        return blocks != null && !blocks.isEmpty() ? blocks.get(blocks.size() - 1) : null;
    }
	public ArrayList<Block> getBlocks(){
		return blocks;
	}
	public String blocks_toString() {
		String out=new String();
		for(int i=0;i<blocks.size();i++) {
			out+=blocks.get(i).getNumber();
			if((i>1)&&((i%3)==0))out+="\n";
			else out+="\t";
		}
		return out;
	}
	public Block getBlockAtNumber( String block_num) {
		Block out =null;
		for(int i=0;i<blocks.size();i++) {
			if(blocks.get(i).getNumber().equals(block_num)) {
				out=blocks.get(i);
				break;
			}
		}
		return out;	
	}
	public boolean removeBlock(String number) {
		Block block=getBlockAtNumber(number);
		boolean res=false;
		if(block!=null){
			res=blocks.remove(block);
			count_of_blocks=blocks.size();
		}
		return res;
	}
	public boolean is_locked() {
		if(authorize_key==null)return false;
		else return true;
	}
	private char getNextKeyChar() {
		Random rand = new Random();
		int rnd=rand.nextInt(93)+33;//ASCII between 33 and 125 
		return (char)rnd;
	}
	private String generateKey(int len) {
		String key=new String();
		for(int i=0;i<len;i++) {
			key+=getNextKeyChar();
		}
		return key;
	}
	public String getAuthorizeKey(int len) {
		authorize_key=generateKey(len);
		return authorize_key;
	}
	private boolean is_Duplicate(String inp) {
		boolean res=false;
		for(int i=0;i<blocks.size();i++) {
			if(blocks.get(i).getNumber().equals(inp)) {
				res=true;
			}
		}
		return res;
	}
	public boolean addNewBlock(String number,int count_of_floors) {
		if(!is_Duplicate(number)) {
			blocks.add(new Block(this,number, count_of_floors));
			count_of_blocks=blocks.size();
			return true;
		}
		else {
			return false;
		}
	}
	
}
