package es.unizar.tmdad.lab3.service;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@Service
public class TwitterLookupService {

	private final ConcurrentMap<String, String> connections = new ConcurrentLinkedHashMap.Builder<String, String>()
			.maximumWeightedCapacity(10).build();

	public void search(String query) {
		System.out.println("tls.search");
		connections.putIfAbsent(query, query);
	}

	public Set<String> getQueries() {
		System.out.println("tls.getQueries");
		return connections.keySet();
	}

}

