package MSTbyPrim;

import java.util.Comparator;

public class Comp implements Comparator<Node> {

	@Override
	public int compare(Node arg0, Node arg1) {
		//간선들의 가중치 비교
		return arg0.v > arg1.v ? 1 : -1 ;
	}

}
