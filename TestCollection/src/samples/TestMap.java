package samples;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapの練習
 *
 */
public class TestMap {

	public static void main(String[] args) {

		// 都市の名前（キー）と人口（値）を組み合わせてひとまとめにします。
		Map<String, Integer> mapPopulation = new HashMap<>();

		// マップにオブジェクトを格納します。
		mapPopulation.put("横浜市", 3770000);
		mapPopulation.put("大阪市", 2750000);
		mapPopulation.put("名古屋市",2320000);
		mapPopulation.put("札幌市", 1970000);
		mapPopulation.put("福岡市", 1610000);

		// マップの値を順に取り出し、表示します。
		System.out.println(mapPopulation.get("横浜市"));
		System.out.println(mapPopulation.get("大阪市"));
		System.out.println(mapPopulation.get("名古屋市"));
		System.out.println(mapPopulation.get("札幌市"));
		System.out.println(mapPopulation.get("福岡市"));
	}

}
