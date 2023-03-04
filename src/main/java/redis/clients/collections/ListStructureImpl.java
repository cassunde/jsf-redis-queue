package redis.clients.collections;

import java.util.List;

import redis.clients.jedis.Jedis;

class ListStructureImpl<T> extends AbstractExpirable<T> implements ListStructure<T> {

	

	ListStructureImpl(Jedis jedis, Class<T> clazz, String nameSpace) {
		super(jedis, clazz, nameSpace);
	}
	
	@Override
	public List<T> get(String key) {
		return new RedisList<> (jedis, clazz, RedisUtils.createKeyWithNameSpace(key, nameSpace));
	}

	@Override
	public void delete(String key) {
		jedis.del(RedisUtils.createKeyWithNameSpace(key, nameSpace));

	}

}
