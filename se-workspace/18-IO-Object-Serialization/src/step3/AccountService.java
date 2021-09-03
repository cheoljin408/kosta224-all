package step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AccountService {
	private String path;
	
	public AccountService(String path) {
		super();
		this.path = path;
	}

	/*
	 	throws
	 	try finall 구조로 oos.close()
	 	FileOutputStream, ObjectOutputStream
	 	writeObject(avo);
	 */
	public void saveObject(AccountVO avo) throws FileNotFoundException, IOException {
		// 내 풀이
		/*
		 * FileOutputStream fos = null; ObjectOutputStream oos = null; try { oos = new
		 * ObjectOutputStream(new FileOutputStream(path));
		 * 
		 * oos.writeObject(avo);
		 * 
		 * System.out.println("출력완료"); } finally { if(oos != null) { oos.close(); } }
		 */
		
		// 강사님 풀이
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(avo);
		} finally {
			if(oos != null){
				oos.close();
			}
		}
	}

	/*
	 	throws
	 	try finally close
	 	FileInputStream, ObjectInputStream readObject()
	 */
	public AccountVO loadObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		// 내 풀이
		/*
		 * AccountVO avo; ObjectInputStream ois = null;
		 * 
		 * try { ois = new ObjectInputStream(new FileInputStream(path)); avo =
		 * (AccountVO)ois.readObject(); } finally { if(ois != null) { ois.close(); } }
		 * 
		 * return avo;
		 */
		
		//강사님 풀이
		ObjectInputStream ois = null;
		AccountVO accountVO;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			accountVO = (AccountVO)ois.readObject();
		} finally {
			if(ois != null) {
				ois.close();
			}
		}
		return accountVO;
	}
	
	
}
