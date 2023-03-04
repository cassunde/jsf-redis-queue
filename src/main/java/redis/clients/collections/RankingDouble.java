package redis.clients.collections;

class RankingDouble implements Ranking<Double> {

	private String name;

	private Double point;

	RankingDouble(String key, String value) {
		this.name = key;
		this.point = Double.valueOf(value);
	}
	
	RankingDouble(String key, Double point) {
		this.name = key;
		this.point = point;
	}

	@Override
	public Double getPoints() {
		return point;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "br.com.elo7.elodum.redis.builder.Ranking<Double> name: " + name + " point: " + point;
	}

}
