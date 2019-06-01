package noobchain;

import java.util.Date;

public class Block {

	public String hash;// 블럭의 디지털 서명.
	public String previousHash;

	private String data;
	private long timeStamp;

	private int nonce;
	
	
	public Block(String data, String previousHash) {

		this.data = data;
		this.previousHash = previousHash;
		
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	
	}
	
	
	// 앞 블록 해쉬 계산
	public String calculateHash() {

		String calculatedHash = StringUtil.applySha256(
				previousHash  
				+ Long.toString(timeStamp) 
				+Integer.toString(nonce)
				+ data
		);

		return calculatedHash;
	}

	public void mineBlock(int difficulty) {
		
		//int difficulty : 풀어야할 자릿수의 숫자
		System.out.println("difficulty : "+difficulty);
		String target = new String(new char[difficulty]).replace('\0', '0');
		System.out.println("target : "+target);
		
		while(!hash.substring(0, difficulty).equals(target)) {
			//해쉬값이 target값과 같을때까지 반복.
			nonce++;
			hash = calculateHash();
			System.out.printf("%d hash : %s \n", nonce, hash);
		}
		System.out.println("Block Mined!!"+hash);
	}
	
	
}
