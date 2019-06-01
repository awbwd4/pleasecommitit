package noobchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;;

public class NoobChain {

	public static ArrayList<Block> blockChain = new ArrayList<Block>();

	public static int difficulty = 5;
	
	
	public static void main(String[] args) {

		/*
		 * Block genesisBlock = new Block("hi im the first block", "0");
		 * System.out.println("Hash for Block 1 : "+genesisBlock.hash);
		 * 
		 * Block secondBlock = new Block("2nd block", genesisBlock.hash);
		 * System.out.println("Hash for Block 2 : "+secondBlock.hash);
		 * 
		 * Block thirdBlock = new Block("2nd block", secondBlock.hash);
		 * System.out.println("Hash for Block 3 : "+thirdBlock.hash);
		 */
		// 이제 각 블럭들은 디지털 시그니쳐를 가지게 됨 : 해당 블럭의 정보와, 이전 블럭의 시그니처에 기반을 둠.

		blockChain.add(new Block("hi im the first block", "0"));
		System.out.println("trying to mine block 1");
		blockChain.get(0).mineBlock(difficulty);
		
		
		blockChain.add(new Block("2nd block", blockChain.get(blockChain.size() - 1).hash));
		System.out.println("trying to mine block 2");
		blockChain.get(1).mineBlock(difficulty);
		
		
		blockChain.add(new Block("3rd block", blockChain.get(blockChain.size() - 1).hash));
		System.out.println("trying to mine block 3");
		blockChain.get(2).mineBlock(difficulty);

		
		System.out.println("\nBlockchain is Valid : "+isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);

		System.out.println(blockchainJson);

	}

	public static Boolean isChainValid() {

		/*
		 * 체인 안에 있는 모든 블럭들을 루프하면서 해쉬값들을 비교.
		 *  블럭의 해쉬 변수가 실제로 계산된 해쉬값과 같은지 이전 블럭의 해쉬값이 
		 *  이전 해쉬 변수와 같은지를 비교.
		 *  
		 *  각 블럭이 마이닝에 의해서 해결된 해쉬값을 지니고 있는지 체크
		 *  
		 */

		Block currentBlock;
		Block previousBlock;
		String hashTarget
			= new String(new char[difficulty]).replace('\0', '0');
		
		
		
		// loop through blockchain to check hashes
		for (int i = 1; i < blockChain.size(); i++) {

			currentBlock = blockChain.get(i);
			previousBlock = blockChain.get(i - 1);

			// compare registerd hash and calculated hash

			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("current hashes are not equal!");
				return false;
			}

			// compare previous hash and registered previous hash
			if (!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("previous hashes are not equal!");
				return false;
			}
			
			//check if hash is solved or not
			if(!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("this block hasn't been mined!");
				return false;
			}
		}
		return true;

	}

}
